package com.leyou.scm;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;



@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.scm.mapper")
@Slf4j
public class ScmHumanApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScmHumanApplication.class);
    }
}
