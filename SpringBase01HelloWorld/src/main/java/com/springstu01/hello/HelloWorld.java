package com.springstu01.hello;

public class HelloWorld {

    private String username;

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void sayHello() {
        System.out.println("欢迎来到Spring 帝国,您好  " + username+" age:"+age);
    }

}
