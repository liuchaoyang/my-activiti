package cn.innotree.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.activiti.spring.boot.SecurityAutoConfiguration;
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(value = {"cn.innotree" })
public class ActivitiApplication {
    public static void main( String[] args ){
        SpringApplication.run(ActivitiApplication.class, args);
    }
}
