package com.capacity.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SystemApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SystemApplication.class, args);
    }
}
