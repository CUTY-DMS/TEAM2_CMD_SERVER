package com.example.cmdproject_team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CmdProjectTeam2Application {
    //test
    public static void main(String[] args) {
        SpringApplication.run(CmdProjectTeam2Application.class, args);
    }

}
