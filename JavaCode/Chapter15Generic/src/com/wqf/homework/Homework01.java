package com.wqf.homework;

import java.util.*;

/**
 * @author 小白学java
 * @version 1.0
 */
public class Homework01 {

    public static void main(String[] args) {

        DAO<User> objectDAO = new DAO<>();
        objectDAO.save("1", new User(1, 20, "小王"));
        objectDAO.save("2", new User(1, 20, "小王"));
        objectDAO.save("3", new User(1, 20, "小王"));
        objectDAO.save("4", new User(1, 20, "小王"));
//        System.out.println(objectDAO);
//        System.out.println(objectDAO.get("4"));
//        objectDAO.update("2", new User(1, 20, "小chen"));
//        System.out.println(objectDAO);
//        List<User> list = objectDAO.list();
//        System.out.println(list);
        Collection<User> list = objectDAO.list();
//        objectDAO.delete("1");
//        System.out.println(objectDAO);
    }
}
class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        //保存T类型对象到Map成员变量中
        map.put(id, entity);
    }
    public T get(String id) {
        //从map中获取id对应对象
        return map.get(id);
    }
    public void update(String id, T entity) {
        //替换map中key为id的内容改为entity对象
        map.put(id, entity);
    }
    public List<T> list() {
        //返回map中存放的对象
        List<T> users = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String obj : set) {
            users.add(map.get(obj));
        }
        return users;
    }
    public void delete(String id) {
        //删除指定id对象
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
