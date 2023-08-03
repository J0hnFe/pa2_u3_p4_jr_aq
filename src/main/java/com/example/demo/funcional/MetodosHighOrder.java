package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	//SUPPLIER
	public void metodo(IPersonaSupplier<String> funcion) {
		LOG.info("High order supplier: " + funcion.getId());
	}

	//CONSUMER
	public void metodoCons(IPersonaConsumer<String> nombre, String arg) {
		nombre.accept(arg);
		LOG.info("High order consumer: " + arg);
	}

}
