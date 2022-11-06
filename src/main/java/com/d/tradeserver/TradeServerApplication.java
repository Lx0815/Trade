package com.d.tradeserver;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScans({
        @MapperScan("com.d.tradeserver.mapper")
})
public class TradeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServerApplication.class, args);
    }

}
