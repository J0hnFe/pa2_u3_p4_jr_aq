package com.example.demo.funcional;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class); // buena practica usar este logger para
																			// imprimir

	public static void main(String[] args) {

		IPersona persona = new PersonaImpl();
		persona.caminar();

		// 1.Supplier

		// Clases
		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier clase: " + supplier1.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "1234";
		LOG.info("Supplier  lambda: " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1234";
			cedula = cedula + "zzz";
			return cedula;
		};

		LOG.info("Supplier  lambda2: " + supplier3.getId());

		// Metodos referenciados
		MetodosReferenciados metodosReferenciados = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodosReferenciados::getId;
		LOG.info("Supplier  met. referenciado: " + supplier4.getId());

		// 2. Consumer
		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer  clase: ");
		consumer1.accept("Felipe Tamal");

		// Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer  lambda: ");
		consumer2.accept("Anddy Tamal");

		// Met. Referenciados
		IPersonaConsumer<String> consumer3 = metodosReferenciados::aceptar;
		LOG.info("Consumer  met. referenciado: ");
		consumer3.accept("Gerardo");

		// 3. Predicate
		// Lambda
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("Predicate  lambda: " + predicate1.evaluar(8));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOG.info("Predicate  lambda2: " + predicate2.evaluar(95));

		// Ej2
		IPersonaPredicate<String> predicate3 = valor3 -> valor3.contains("a");
		LOG.info("Predicate  lambda3: " + predicate3.evaluar(("Anddy").toLowerCase()));

		// Ej3
		IPersonaBiPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate  lambda4: " + predicate4.evaluar("h", "holi"));

		// metodos referenciados
		IPersonaPredicate<Integer> predicate5 = metodosReferenciados::evaluar;
		LOG.info(" Predicate M.Referenciados " + predicate5.evaluar(2));

		// 4. Function

		// Lambda
		IPersonaFunction<String, BigDecimal> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(new BigDecimal(10.1)));

		IPersonaFunction<String, Integer> function1 = numero1 -> {
			String valorFinal = numero1.toString().concat(" valor String");
			return valorFinal;
		};

		LOG.info("Function lambda2: " + function1.aplicar(10));
		
		//Met. referenciados
		IPersonaFunction<String, Integer> function2 = metodosReferenciados::aplicar;
		LOG.info(" Function M.Referenciados " + function2.aplicar(55));

		// 5. Unary Operator
		IPersonaUnary<Integer> unary = numero -> numero + (numero * 2);
		LOG.info("Unary lambda1: " + unary.aplicar(25));

		// UnaryFunc
		IPersonaUnaryFunction<Integer> unaryFunc = numero -> numero + (numero * 2);
		LOG.info("UnaryFunc lambda1: " + unaryFunc.aplicar(15));

		// Met. referenciados
		IPersonaUnary<Double> unary2 = metodosReferenciados::aplicar;
		LOG.info(" Unary M.Referenciados " + unary2.aplicar(55.0));
		
		IPersonaUnaryFunction<Double> unary3 = metodosReferenciados::aplicar;
		LOG.info(" UnaryFunc M.Referenciados " + unary3.aplicar(100.0));

	}
}
