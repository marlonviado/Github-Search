package com.marlonviado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.marlonviado.config.EurekaServerConfiguration;

@SpringBootApplication
@Import(EurekaServerConfiguration.class)
public class DiscoveryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DiscoveryServiceApplication.class, args);
		
	}
	
}
