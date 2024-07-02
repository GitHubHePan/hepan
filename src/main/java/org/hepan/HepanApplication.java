package org.hepan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "org.hepan.mapper")
@EnableCaching
public class HepanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HepanApplication.class, args);
    }

}
