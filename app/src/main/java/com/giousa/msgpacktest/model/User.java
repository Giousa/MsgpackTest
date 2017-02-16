package com.giousa.msgpacktest.model;

import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/16
 * Email:65489469@qq.com
 */
@Message
public class User implements Serializable {

    /**
     *serialVersionUID
     */
    private static final long serialVersionUID = -5848295770696335660L;
    private int id;
    private String name;
    private transient String password;
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
    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password
                + "]";
    }
    public User() {

    }

}
