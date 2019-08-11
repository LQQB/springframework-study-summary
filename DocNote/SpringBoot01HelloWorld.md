### 什么是单体应用


### 什么是微服务
- 每一个职责单一的功能放在一个独立的服务中 
- 每个服务运行在一个单独的进程
- 每一个服务都可以根据性能需求进行水平拓展
- 每一个服务都有自己的数据存储，包括数据库、缓存、消息队列


### 简化布署
```xml
    <!-- 这个插件可以将应用打包成可执行的jar文件 -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

```

### Hello World 探究
#### 1. POM文件
##### 1. 父项目
```xml
    <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>2.1.6.RELEASE</version>
       <relativePath/> 
    </parent>
    他的父项目是
    <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-dependencies</artifactId>
       <version>2.1.6.RELEASE</version>
       <relativePath>../../spring-boot-dependencies</relativePath>
    </parent>
```
   这是父项目的版本仲裁中心，以后我们导入依赖的是默认不需要版本依赖的（没有在dependencie里面
   管理的依赖自然需要添加版本号）
   
##### 2. 场景启动器 
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
**spring-boot-starter**-web:
    
    spring-boot-starters: spring-boot场景启动器;导入web模块正常运行依赖的所有组件
    
 SpringBoot 的所有场景都抽取出来做成一个一个的 starters(启动器)，要用什么功能就在项目里引入什么的场景启动器。
 
#### 2. SpringBoot 主程序类 主入口类


### SpringBoot 启动方法
```java
@SpringBootApplication      // 来标注一个主程序，来说明这是一个SpirngBoot 应用
public class HelloApplication {

    public static void main(String[] args) {
        // Spring 应用启动
        SpringApplication.run(HelloApplication.class, args);
    }
}
```
**@SpringBootApplication**: 使用 @SpringBootApplication 来标注的主程序，来说明这是一个SpirngBoot 的主配置类，SpringBoot就应该
运行该类的main方法来启动SrpringBoot。

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {}
```
SpringBoot 是一个组合注解，里面包含了如: @SpringBootConfiguration、@EnableAutoConfiguration等

**@SpringBootConfiguration**: \
  > 标注在某个类上表示它是 SpringBoot 的配置类;\
    @Configuration 配置类上来标注这个注解\
    配置类---配置文件， 配置类也是容器的一个组件(@Component)
    
**@EnableAutoConfiguration**: 开启自动配置功能
        
        