package fr.insa.soa.userManagementMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
public class UserManagementMsApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserManagementMsApplication.class, args);
	}

}
