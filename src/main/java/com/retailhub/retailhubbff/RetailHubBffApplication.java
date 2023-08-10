package com.retailhub.retailhubbff;

import com.retailhub.retailhubbff.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class RetailHubBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailHubBffApplication.class, args);
	}

}
