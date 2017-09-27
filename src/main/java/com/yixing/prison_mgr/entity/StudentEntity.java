package com.yixing.prison_mgr.entity;

/**
 * Created by Master_Q on 2017/9/18.
 */

public class StudentEntity {
    private int id;
    private String name;
    private String password;
    private int age;
    private int sex;
    private String sexs;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSexs() {
        return sexs;
    }

    public void setSexs(String sexs) {
        this.sexs = sexs;
    }
}
