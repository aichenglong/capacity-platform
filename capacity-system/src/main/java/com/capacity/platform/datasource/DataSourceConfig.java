package com.capacity.platform.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: icl
 * Date:2018/06/02
 * Description:
 * Created by icl on 2018/06/02.
 */
@Configuration
@MapperScan("com.capacity.platform.system.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment env;

    @Autowired
    private DataSourceProperties properties;

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
        return paginationInterceptor;
    }

    /**
     * 通过Spring JDBC 快速创建 DataSource
     * 参数格式
     * spring.datasource.master.jdbcurl=jdbc:mysql://localhost:3306/charles_blog
     * spring.datasource.master.username=root
     * spring.datasource.master.password=root
     * spring.datasource.master.driver-class-name=com.mysql.jdbc.Driver
     *
     * @return DataSource
     */
    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


    /**
     * 手动创建DruidDataSource,通过DataSourceProperties 读取配置
     * 参数格式
     * spring.datasource.url=jdbc:mysql://localhost:3306/test
     * spring.datasource.username=root
     * spring.datasource.password=root
     * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
     *
     * @return DataSource
     * @throws SQLException
     */
    @Bean(name = "slaveDataSource")
    @Qualifier("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(100);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setFilters("stat,wall");
        return dataSource;
    }


    /**
     *  构造多数据源连接池
     *  Master 数据源连接池采用 HikariDataSource
     *  Slave  数据源连接池采用 DruidDataSource
     * @param master
     * @param slave
     * @return
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("masterDataSource") DataSource master,
                                        @Qualifier("slaveDataSource") DataSource slave) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.master, master);
        targetDataSources.put(DatabaseType.slave, slave);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(slave);// 默认的datasource设置为myTestDbDataSource

        String read = env.getProperty("spring.datasource.read");
        dataSource.setMethodType(DatabaseType.slave, read);

        String write = env.getProperty("spring.datasource.write");
        dataSource.setMethodType(DatabaseType.master, write);

        return dataSource;
    }


//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource myTestDbDataSource,
//                                               @Qualifier("slaveDataSource") DataSource myTestDb2DataSource) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(this.dataSource(myTestDbDataSource, myTestDb2DataSource));
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
//        return fb.getObject();
//    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("masterDataSource") DataSource master,
                                                          @Qualifier("slaveDataSource") DataSource slave) throws Exception {
        MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
        fb.setDataSource(this.dataSource(master, slave));
        // 是否启动多数据源配置，目的是方便多环境下在本地环境调试，不影响其他环境
//        if (properties.getOnOff() == true) {
            fb.setPlugins(new Interceptor[]{new DatabasePlugin()});
//        }
        return fb;
    }


    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
