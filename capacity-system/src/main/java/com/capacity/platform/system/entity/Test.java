package com.capacity.platform.system.entity;


/**
 * Author: icl
 * Date:2018/06/02
 * Description: 使用DatabaseContextHolder获取当前线程的DatabaseType
 * Created by icl on 2018/06/02.
 */
public class Test {
    private int id;
    private String name;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
