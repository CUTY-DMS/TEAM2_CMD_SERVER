package com.example.cmdproject_team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableRedisRepositories
@ConfigurationPropertiesScan
@SpringBootApplication
public class CmdProjectTeam2Application {

    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication.run(CmdProjectTeam2Application.class, args);
    }

}
