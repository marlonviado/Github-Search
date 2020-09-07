package com.marlonviado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.marlonviado.config.EurekaClientConfiguration;
import com.marlonviado.config.ZuulServerConfiguration;

@SpringBootApplication
@Import({EurekaClientConfiguration.class,ZuulServerConfiguration.class})
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
