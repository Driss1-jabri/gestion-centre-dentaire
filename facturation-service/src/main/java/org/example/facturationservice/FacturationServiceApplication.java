package org.example.facturationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class FacturationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run( FacturationServiceApplication.class , args);
  }


  public String testservice(){
    return "facturation conntroller";
  }
}
