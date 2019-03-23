package com.leyou.scm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ScmUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScmUploadApplication.class);
    }
}
