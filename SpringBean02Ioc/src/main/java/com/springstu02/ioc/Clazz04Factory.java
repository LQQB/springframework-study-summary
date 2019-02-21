package com.springstu02.ioc;

import org.springframework.beans.factory.FactoryBean;

public class Clazz04Factory implements FactoryBean<Clazz04> {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Clazz04 getObject() throws Exception {
        Clazz04 clazz04 = new Clazz04();
        System.out.println(username);
        // TODO
        return clazz04;
    }

    @Override
    public Class<?> getObjectType() {
        return Clazz04.class;
    }

}
