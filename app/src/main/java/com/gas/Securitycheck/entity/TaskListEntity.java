package com.gas.Securitycheck.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/17 0017.
 */
public class TaskListEntity implements Serializable {
    private static final long serialVersionUID = 3L;
    private String SerialNumber;  //���
    private String name; //����
    private String CompletionStatus; //�����
    private String state; //״̬
    private String operation; //����
    private String time; //ʱ��

    @Override
    public String toString() {
        return "TaskListEntity{" +
                "SerialNumber='" + SerialNumber + '\'' +
                ", name='" + name + '\'' +
                ", CompletionStatus='" + CompletionStatus + '\'' +
                ", state='" + state + '\'' +
                ", operation='" + operation + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompletionStatus() {
        return CompletionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        CompletionStatus = completionStatus;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
