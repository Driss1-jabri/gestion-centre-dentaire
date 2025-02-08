package org.example.consultationservice;

import org.example.consultationservice.feign.FacturationRestClient;
import org.example.consultationservice.feign.PatientRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsultationServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConsultationServiceApplication.class, args);
	}
	@Bean CommandLineRunner runner(FacturationRestClient facturationRestClient,
								   PatientRestClient patientRestClient
								   ){
		return (args)-> {
			String str = facturationRestClient.getDac();
			String str2=patientRestClient.getPati().getBody().getFirstName();
			System.out.println(str);
			System.out.println(str2);
		};
	}
}
