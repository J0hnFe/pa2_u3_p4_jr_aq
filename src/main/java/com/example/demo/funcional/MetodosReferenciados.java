package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	// SUPPLIER
	public static Integer getId() {
		return 8;
	}

	public static String getIdHO() {
		LOG.info("Metodos Referenciados HO");
		return "Texto HO Supplier";
	}

	// CONSUMER
	public static void aceptar(String arg) {
		String cadena = "Nombre consumer";
		LOG.info(cadena + " " + arg);
	}

	// PREDICATE
	public static boolean evaluar(Integer arg) {
		if (arg.compareTo(2) == 0) {
			return true;
		} else {
			return false;
		}

	}

	// FUNCTION
	public String aplicar(Integer arg) {
		String valorFinal = arg.toString().concat(" - valor string");
		return valorFinal;
	}

	// UNARY
	public Double aplicar(Double arg) {
		Double num = arg * 0.3;
		return num;
	}
}
