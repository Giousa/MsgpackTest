package com.giousa.msgpacktest.model;

import org.msgpack.annotation.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author:Giousa
 * Date:2017/2/16
 * Email:65489469@qq.com
 */
@Message
public class ComplexEntity implements Serializable {

    /**
     *serialVersionUID
     */
    private static final long serialVersionUID = -458914520933183052L;
    //为了能直接使用，全部都改为public了
    public List<User> lists = new ArrayList<User>();
    public Map<String,User> maps = new HashMap<String,User>();

    public Map<String, User> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, User> maps) {
        this.maps = maps;
    }

    public List<User> getLists() {
        return lists;
    }

    public void setLists(List<User> lists) {
        this.lists = lists;
    }
}
