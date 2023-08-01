package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class); // buena practica usar este
																							// logger para

	// Supplier
	public Integer getId() {
		return 8;
	}

	// Consumer
	public void aceptar(String arg) {
		String cadena = "Nombre";
		LOG.info(cadena + " " + arg);
	}

	// Predicate
	public boolean evaluar(Integer arg) {
		if (arg.compareTo(2) == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Function
	public String aplicar(Integer arg) {
		String valorFinal = arg.toString().concat(" - valor string");
		return valorFinal;
	}

	// Unary
	public Double aplicar(Double arg) {
		Double num = arg * 0.3;
		return num;
	}

}
