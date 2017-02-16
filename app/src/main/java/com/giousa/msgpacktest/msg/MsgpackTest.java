package com.giousa.msgpacktest.msg;

import com.giousa.msgpacktest.model.ComplexEntity;
import com.giousa.msgpacktest.model.User;

import org.msgpack.MessagePack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 1.单个对象使用Msgpack <BR />
 *   1.1 此对象必须要实现Serializable接口(java.io.Serializable) <BR />
 *   1.2 此对象必须要使用@Message注解(org.msgpack.annotation.Message) <BR />
 *   1.3 此对象属性中不能有用transient修饰的字段. <BR />
 * 2.序列化List，Map(List接口)直接这么做msgpack不支持. <BR />
 *   2.1 构建含有List,Map属性的字段对象 <BR />
 *   2.2 该有的步骤和构建单个对象使用Msgpack一样。<BR />
 *
 * <Detail description>
 *
 * @author  Peter.Qiu
 * @version  [Version NO, 2015-12-16]
 * @see  [Related classes/methods]
 * @since  [product/module version]
 */
public class MsgpackTest {

    public static void main(String[] args) {
        MessagePack pack = new MessagePack();
        User user = new User(1, "name", "password");
        try {
            System.out.println("单个对象使用Msgpack");
            System.out.println("序列化前: " + user.toString());
            // 序列化
            byte[] bytes = pack.write(user);
            // 反序列化
            User s = pack.read(bytes, User.class);
            System.out.println("反序列化: " + s.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        //ArrayList
        try {
            System.out.println("ArrayList使用Msgpack");
            ArrayList<User> list = new ArrayList<User>();
            list.add(user);
            System.out.println("序列化前: " + list.get(0).getId());
            // 序列化
            byte[] bytesList = pack.write(list);
            // 反序列化
            @SuppressWarnings("unchecked")
            ArrayList<User> lists = pack.read(bytesList, ArrayList.class);
            System.out.println("反序列化: " + lists.get(0).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        //Vector
        try {
            System.out.println("Vector使用Msgpack");
            Vector<User> list = new Vector<User>();
            list.add(user);
            System.out.println("序列化前: " + list.get(0).getId());
            // 序列化
            byte[] bytesList = pack.write(list);
            // 反序列化
            @SuppressWarnings("unchecked")
            Vector<User> lists = pack.read(bytesList, Vector.class);
            System.out.println("反序列化: " + lists.get(0).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        //Map
        try {
            System.out.println("Map使用Msgpack");
            Map<String,User> map = new HashMap<String,User>();
            map.put("user", user);
            System.out.println("序列化前: " + map.get("user"));
            // 序列化
            byte[] bytesList = pack.write(map);
            // 反序列化
            @SuppressWarnings("unchecked")
            Map<String,User> maps = pack.read(bytesList, Map.class);
            System.out.println("反序列化: " + maps.get("user"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        //ComplexEntity(自定义的Entity，只要包含一些集合的属性，List,Map)
        try {
            System.out.println("ComplexEntity使用Msgpack");
            ComplexEntity entity = new ComplexEntity();
            entity.maps.put("user", user);
            entity.lists.add(user);
            entity.lists.add(user);

            System.out.println("序列化前map: " + entity.maps.get("user"));
            System.out.println("序列化前list: " + entity.lists);
            // 序列化
            byte[] entityBytes = pack.write(entity);
            // 反序列化
            ComplexEntity entitys = pack.read(entityBytes, ComplexEntity.class);
            System.out.println("反序列化map: " + entitys.maps.get("user"));
            System.out.println("反序列化list: " + entitys.lists);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
