package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonaConsumerImpl implements IPersonaConsumer<String>{

	private static final Logger LOG = LoggerFactory.getLogger(PersonaConsumerImpl.class); // buena practica usar este logger para
	
	
	@Override
	public void accept(String arg) {
		LOG.info(arg);
	}
	
}
