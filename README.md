### Spring Framework 的学习记录总结
#### 一 在没有使用Spring之前，存在的问题：
1. 代码耦合度较高
    ```Java
       
    ```

2. 控制事务繁琐
3. 第三方框架运用整合麻烦

#### 二 Spring 基础
1. ioC 和 DI 思想

    ioc(控制反转): 将原本程序手动创建对象的控制权,交给spring容器管理。
    
    di(依赖注入): Spring创建对象的过程中，将对象依赖的属性（常量、对象、集合）通过配置设置给改对象
    
2. 代码配置

    元数据的配置方式有三种
    1. xml 的方式配置
    2. 注解的方式配置
    3. Java configuation 的方式配置
    
    > bena 必须存在一个无参的构造器

3. 程序分析

    1. 通过 Resouce 对象加载配置文件
    2. 解析配置文件，得到指定的 bean
    3. 解析 bean 元素， id 做为 bean 的名字， class 用于反射 bean 的实例
    4. 调用 getBean 方法，从容器中返回对象实例
    
4. Spring 基本配置
    
    ```xml
        <import resource="" />  元素: 系统中<bean> 元素配置大量增加时,为了提高可读性,可以将 applicationContext.xml 配置文件
       分解成多个配置文件,然后在 applicationContext.xml 包含其他配置文件
    ```

5. Spring 的测试框架

    传统测试
    Spring测试