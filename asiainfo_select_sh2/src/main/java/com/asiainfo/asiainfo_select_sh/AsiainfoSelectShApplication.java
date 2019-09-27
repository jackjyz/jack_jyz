package com.asiainfo.asiainfo_select_sh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.asiainfo.asiainfo_select_sh.mapper.tact5")
public class AsiainfoSelectShApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsiainfoSelectShApplication.class, args);
    }
}
