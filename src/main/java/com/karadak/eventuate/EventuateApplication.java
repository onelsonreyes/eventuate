package com.karadak.eventuate;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import({EventuateDriverConfiguration.class})
public class EventuateApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventuateApplication.class, args);
    }
}
