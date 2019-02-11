package com.springstu01.helloTest;

import com.springstu01.hello.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

public class HelloWorldTest {


    /**
     * 传统方式： 调用者手动创建对象，和创建对象依赖的对象，并组装依赖
     */
    @Test
    public void testOld() {
        // 创建依赖
        HelloWorld helloWorld = new HelloWorld();
        // 给当前对象设置相关的依赖属性
        helloWorld.setUsername("LQQB");
        helloWorld.setAge(17);
        helloWorld.sayHello();
    }

    /**
     * 使用 spring 容器之后
     */
    @Test
    public void testIoC() {
        HelloWorld helloWorld = null;
        // 1. 从 classpath 路径中寻找配置文件，创建资源对象
        Resource resource = new ClassPathResource("applicationContext.xml");
        // 2. 根据资源对象，创建 Spring ioc 容器对象
        BeanFactory factory = new XmlBeanFactory(resource);     // XmlBeanFactory 方法已经过时
        // 3. 从 spring 的 ioc 容器中获取指定对象名称（helloWorld）的对象
        // 签名一： 获取 bean 对象的方法 根据 bean对象在容器中的名称 寻找 bean 对象
        // helloWorld = (HelloWorld) factory.getBean("helloWorld");
        // 签名二： 获取 bean 对象的方法 根据 bean对象在容器中的类型 寻找 bean 对象
        helloWorld = factory.getBean(HelloWorld.class);
        // 签名三： 获取 bean 对象的方法 根据 bean对象在容器中的类型 + ID名称 寻找 bean 对象(推荐)
        helloWorld = factory.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();
    }


    /**
     * 模拟 Spring ioc 容器操作
     * @throws Exception
     */
    @Test
    public void testIoCMock() throws Exception {
        String className = "com.springstu01.hello.HelloWorld";

        // 创建一个对象
        HelloWorld hello = null;
        // 使用反射创建对象
        Class clazz = Class.forName(className);
        Constructor con = clazz.getConstructor();
        con.setAccessible(true);    // 设置构造器的访问性
        Object obj = con.newInstance();

        // 使用内省机制设置属性值
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor pd: pds) {
            // HelloWorld 类中所有的属性名称
            String propertyName = pd.getName();
            // 调用 username 的set 方法
            if("username".equals(propertyName)) {
                pd.getWriteMethod().invoke(obj, "LQB");
            } else if("age".equals(propertyName)) {
                pd.getWriteMethod().invoke(obj, 18);
            }
        }
        hello = (HelloWorld) obj;

        hello.sayHello();

    }
}
