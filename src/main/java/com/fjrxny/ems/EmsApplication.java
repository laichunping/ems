package com.fjrxny.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.fjrxny.ems.mapper")    //MyBatis扫描Mapper包路径
@EnableTransactionManagement //开启声明式事务
public class EmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmsApplication.class,args);
    }
}
