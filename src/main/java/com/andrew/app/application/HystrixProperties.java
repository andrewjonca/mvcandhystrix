package com.andrew.app.application;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hystrix", ignoreUnknownFields = true)
public class HystrixProperties {
	boolean enabled = true;
	boolean streamEnabled = true;
	String streamUrl = "/hystrix.stream";
}
