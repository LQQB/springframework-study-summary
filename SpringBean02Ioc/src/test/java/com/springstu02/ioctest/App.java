package com.springstu02.ioctest;

import com.springstu02.ioc.Clazz01;
import com.springstu02.ioc.Clazz02;
import com.springstu02.ioc.Clazz03;
import com.springstu02.ioc.Clazz04;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "file:src/main/resources/applicationContext.xml")
public class App {


    @Autowired
    private Clazz01 clazz01;


    @Autowired
    private Clazz02 clazz02;

    @Autowired
    private Clazz03 clazz03;

    @Autowired
    private Clazz04 clazz04;

    @Autowired
    private Clazz04 clazz044;


    @Test
    public void ClazzTest() {
        System.out.println(clazz01);
        System.out.println(clazz02);
        System.out.println(clazz03);
        System.out.println(clazz04);
        System.out.println(clazz044);
    }




}
