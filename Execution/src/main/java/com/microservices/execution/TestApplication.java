package com.microservices.execution;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class TestApplication {
    private static final String JMS_BROKER_URL = "vm://embedded?broker.persistent=false,useShutdownHook=false";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(JMS_BROKER_URL);
    }

    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        SpringApplication.run(TestApplication.class, args);
	}
}
