package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class); //buena practica usar este logger para imprimir
	
	public static void main(String[] args) {
		
		IPersona persona = new PersonaImpl();
		
		persona.caminar();
		
		//1.Supplier
		
		//Clases
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());
		
		//Lambdas
		IPersonaSupplier<String> supplier2  = ()->  "1234";
		LOG.info("Supplier  lambda: " + supplier2.getId());
		
		IPersonaSupplier<String> supplier3  = ()-> {
			String cedula = "1234";
			cedula = cedula + "zzz";
			return cedula;
		};
		LOG.info("Supplier  lambda2: " + supplier3.getId());
	
	}

}
