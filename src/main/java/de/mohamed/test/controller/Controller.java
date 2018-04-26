package de.mohamed.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mohamed.test.domain.Objekt;

@RestController
public class Controller {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/send")
	public String send() {
		Objekt objekt = new Objekt(1, "Das ist eine schöne Nachricht, um JMS zu testen.");
		jmsTemplate.convertAndSend("TestQueue", objekt);
		return objekt.toString();
	}

}
