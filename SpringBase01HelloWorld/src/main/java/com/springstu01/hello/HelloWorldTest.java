package com.springstu01.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorldTest {


    @Test
    public void iocTest() {
        // 一个简单的 ioc 的例子
        HelloWorld helloWorld = null;
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);     // XmlBeanFactory 方法已经过时
        helloWorld = (HelloWorld) factory.getBean("helloWorld");
        helloWorld.sayHello();
    }


}
