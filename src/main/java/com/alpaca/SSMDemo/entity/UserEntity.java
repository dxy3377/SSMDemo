package com.alpaca.SSMDemo.entity;

/**
 * @Author: daixueyun
 * @Description:
 * @Date: Create in 22:11 2019/7/17
 */
public class UserEntity {

    //编号
    private Integer id;

    //姓名
    private String userName;

    //优点
    private String advantage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", advantage='" + advantage + '\'' +
                '}';
    }
}
