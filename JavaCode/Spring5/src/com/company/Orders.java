package com.company;

/**
 * @author 小白学java
 * @version 3.0
 */
public class Orders {

    private String name;
    private String address;

    public Orders(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Orders() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void initMethod() {
        System.out.println("order被创建");
    }

    public void destroyMethod() {
        System.out.println("order被销毁");
    }

    @Override
    public String toString() {
        return "Orders{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
