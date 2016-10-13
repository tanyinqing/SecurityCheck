package com.gas.Securitycheck.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String age;//年龄
    private String regTime;//注册时间
    private String email;//注册邮箱
    private String portrait;//头像
    private String userId;//用户id
    private String userName;//昵称
    private String password;//密码
    private String photoMob;//手机号
    private String gender;//性别
    private String realName;//用户名
    private String logins;//用户等级
}
