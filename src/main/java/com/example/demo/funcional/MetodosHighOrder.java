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
		LOG.info("High order consumer: ");
		nombre.accept(arg);
	}
	
	//PREDICATE
	public void metodoPred(IPersonaPredicate<Integer> valor, Integer arg) {
		LOG.info("High order predicate: " + valor.evaluar(arg));;
	}
	//FUNCTION
	public void metodoFunc(IPersonaFunction<String, Integer> valor, Integer arg) {
		LOG.info("High order function: " + valor.aplicar(arg));
	}
	
	//UNARY
	public void metodoUnary(IPersonaUnary<Double> valor, Double arg) {
		LOG.info("High order unary: " + valor.aplicar(arg));
	}

}
