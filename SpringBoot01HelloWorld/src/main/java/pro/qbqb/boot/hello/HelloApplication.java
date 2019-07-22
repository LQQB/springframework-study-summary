package pro.qbqb.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication      // 来标注一个主程序，来说明这是一个SpirngBoot 应用
public class HelloApplication {

    public static void main(String[] args) {
        // Spring 应用启动
        SpringApplication.run(HelloApplication.class, args);
    }

}
