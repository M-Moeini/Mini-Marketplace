package com.Mehdi.SheypoorApp;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableFeignClients
public class Prj5Application {

    @Bean
    public RestTemplate getRestTemplate(){
        return new  RestTemplate();


    }



    public static void main(String[] args) {
        SpringApplication.run(Prj5Application.class, args);
    }

}
