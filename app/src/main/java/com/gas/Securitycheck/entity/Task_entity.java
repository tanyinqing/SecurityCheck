package com.gas.Securitycheck.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class Task_entity implements Serializable {
    private static final long serialVersionUID = 2L;
    private String address;   //地址
    private String state; //状态
    private String category; //分类
    private String operation; //操作

    @Override
    public String toString() {
        return "Task_entity{" +
                "address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", category='" + category + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
