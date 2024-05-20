package com.Navigator.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
