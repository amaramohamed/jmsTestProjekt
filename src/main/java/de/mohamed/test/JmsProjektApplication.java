package de.mohamed.test;

import javax.jms.ConnectionFactory;
import org.springframework.util.ErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@EnableJms
@SpringBootApplication
public class JmsProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsProjektApplication.class, args);
	}

	@Bean
	public JmsListenerContainerFactory<?> MeinFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {

		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

		// anonymous Klasse
		factory.setErrorHandler(new ErrorHandler() {
			@Override
			public void handleError(Throwable t) {
				System.err.println("Empfänger fällt aus.");
			}
		});

		// Lambda Funktion
		factory.setErrorHandler(t -> System.out.println("Empfänger fällt aus."));

		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
