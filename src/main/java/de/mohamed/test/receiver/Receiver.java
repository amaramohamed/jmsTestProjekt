package de.mohamed.test.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import de.mohamed.test.domain.Objekt;

@Component
public class Receiver {

	@JmsListener(destination = "TestQueue", containerFactory= "MeinFactory")
	public void receiveObjekt(Objekt objekt) {
		System.out.println(objekt.toString());
	}
	
}
