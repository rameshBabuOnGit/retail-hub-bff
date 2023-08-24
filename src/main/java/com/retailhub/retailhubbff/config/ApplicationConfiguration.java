package com.retailhub.retailhubbff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Import({RestTemplate.class})
@Configuration
public class ApplicationConfiguration {
}
