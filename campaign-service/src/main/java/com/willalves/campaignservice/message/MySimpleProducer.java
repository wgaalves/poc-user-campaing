package com.willalves.campaignservice.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class MySimpleProducer {
	
	private String defaultMessage = "Hello, Spring Cloud Stream"; 
	
	@InboundChannelAdapter(Source.OUTPUT)
	public String sendDefaultMessage() {
		return defaultMessage;
	}

}