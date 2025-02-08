package org.example.facturationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FacturationServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run( FacturationServiceApplication.class , args);
  }


  public String testservice(){
    return "facturation conntroller";
  }
}
