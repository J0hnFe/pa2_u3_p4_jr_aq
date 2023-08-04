package com.example.demo.funcional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		IPersona persona = new PersonaImpl();
		persona.caminar();

		// 1. SUPPLIER
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
		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::getId;
		LOG.info("Supplier  met. referenciado: " + supplier4.getId());

		// 2. CONSUMER
		// Clases
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consumer  clase: ");
		consumer1.accept("Texto consumer clase");

		// Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("2");
			LOG.info(cadena);
		};
		LOG.info("Consumer  lambda: ");
		consumer2.accept("Texto consumer lambda");

		// Met. Referenciados
		IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
		LOG.info("Consumer  met. referenciado: ");
		consumer3.accept("Gerardo");

		// 3. PREDICATE
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

		// Ej3 (BiPredicate)
		IPersonaBiPredicate<String, String> predicate4 = (letra, cadena) -> cadena.contains(letra);
		LOG.info("Predicate  lambda4: " + predicate4.evaluar("h", "holi"));

		// Metodos referenciados
		IPersonaPredicate<Integer> predicate5 = MetodosReferenciados::evaluar;

		LOG.info(" Predicate M. Referenciados " + predicate5.evaluar(2));

		// 4. FUNCTION
		// Lambda
		IPersonaFunction<String, BigDecimal> function = numero -> numero.toString();
		LOG.info("Function lambda: " + function.aplicar(new BigDecimal(10.1)));

		IPersonaFunction<String, Integer> function1 = numero1 -> {
			String valorFinal = numero1.toString().concat(" valor String");
			return valorFinal;
		};

		LOG.info("Function lambda2: " + function1.aplicar(10));

		// Met. referenciados
		IPersonaFunction<String, Integer> function2 = MetodosReferenciados::aplicar;
		LOG.info(" Function M.Referenciados " + function2.aplicar(55));

		// 5. Unary Operator
		// Lambda
		IPersonaUnary<Integer> unary = numero -> numero + (numero * 2);
		LOG.info("Unary lambda1: " + unary.aplicar(25));

		// Lambda - UnaryFunc
		IPersonaUnaryFunction<Integer> unaryFunc = numero -> numero + (numero * 2);
		LOG.info("UnaryFunc lambda1: " + unaryFunc.aplicar(15));

		// Met. referenciados
		IPersonaUnary<Double> unary2 = MetodosReferenciados::aplicar;
		LOG.info(" Unary M.Referenciados " + unary2.aplicar(55.0));

		IPersonaUnaryFunction<Double> unary3 = MetodosReferenciados::aplicar;
		LOG.info(" UnaryFunc M.Referenciados " + unary3.aplicar(100.0));
		// ********************************************************************************************************************************************************
		// Metodos referenciados
		// (Mientras cumpla el contrato lo puedo pasar como una implementacion de la
		// Interfaz funcional)
		// Metodos HighOrder
		LOG.info("\n\nUso Metodos High Order:");
		MetodosHighOrder highOrder = new MetodosHighOrder();

		// SUPPLIER
		// 1. Clase
		IPersonaSupplier<String> supplierHO = new PersonaSupplierImpl();
		highOrder.metodo(supplierHO);

		// 2. Lambdas
		highOrder.metodo(() -> "Lambda texto supp");

		// 3. Metodos referenciados
		highOrder.metodo(MetodosReferenciados::getIdHO);

		LOG.info("");

		// CONSUMER
		// 1. Clase
		IPersonaConsumer<String> consumerHO = new PersonaConsumerImpl();
		highOrder.metodoCons(consumerHO, "Clase consumer");

		// 2. Lambda
		highOrder.metodoCons(cadena -> LOG.info(cadena), "Lambda Consumer");

		// 3. Metodos referenciados
		highOrder.metodoCons(MetodosReferenciados::aceptar, "luna");

		LOG.info("");

		// PREDICATE
		// 1. Clase
		IPersonaPredicate<Integer> predicateHO = new PersonaPredicateImpl();
		highOrder.metodoPred(predicateHO, 12);

		// 2. Lambda
		highOrder.metodoPred(x -> {
			LOG.info("Lambda: ");
			if (x >= 20) {
				return true;
			} else {
				return false;
			}
		}, 31);

		// 3. Metodos referenciados
		LOG.info("MR: ");
		highOrder.metodoPred(MetodosReferenciados::evaluar, 10);

		LOG.info("");

		// FUNCTION
		// 1. Clase
		IPersonaFunction<String, Integer> functionHO = new PersonaFunctionImpl();
		highOrder.metodoFunc(functionHO, 65);

		// 2. Lambda
		highOrder.metodoFunc(x -> {
			Double valorAux = x * 0.5;
			return "valor lambda: " + valorAux.toString();
		}, 3);

		// 3. Metodos referenciados
		highOrder.metodoFunc(MetodosReferenciados::aplicar, 45);

		LOG.info("");

		// UNARY
		// 1. Clase
		LOG.info("Clase");
		IPersonaUnary<BigDecimal> unaryHO = new PersonaUnaryImpl();
		highOrder.metodoUnary2(unaryHO, new BigDecimal(100));

		// 2. Lambda
		highOrder.metodoUnary(x -> {
			LOG.info("Lambda: ");
			Double valAux = (x * 0.3);
			return valAux;
		}, 33.25);

		// 3. Metodos referenciados
		LOG.info("M.R: ");
		highOrder.metodoUnary(MetodosReferenciados::aplicar, 25.0);

		// *******************************************************************************************************************************************
		// INT. FUNCIONALES JAVA
		// 1. Supplier
		// Supplier
		LOG.info("\n\nUso Interfaces Funcionales:");

		Stream<String> lista = Stream.generate(() -> "123").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));

		// 2. Consumer
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
		listaNumeros.forEach(cadena -> LOG.info("" + cadena));

		// 3. Predicate
		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOG.info("Valor: " + numero));

		// 4. Function
		Stream<String> listaCamb = listaNumeros.stream().map(numero -> {
			Integer num = 10;
			num = numero + num;
			return "n: " + num;
		});
		listaCamb.forEach(x -> LOG.info(x));

		// 5. UnaryOperator
		Stream<Integer> listaCamb2 = listaNumeros.stream().map(x -> {
			Integer num = 10;
			num = x + num;
			return num;
		});
		listaCamb2.forEach(x -> LOG.info("" + x));

		// Tarea 16***************************************************************
		List<Integer> listaMain = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 1. SUPPLIER
		Stream<String> listaSup = Stream.generate(MetodosReferenciados::getIdHO).limit(5);
		listaSup.forEach(x -> LOG.info("" + x));

		// 2. CONSUMER
		List<String> listCons = Arrays.asList("a", "b", "c", "d");
		listCons.forEach(MetodosReferenciados::aceptar);

		// 3. PREDICATE
		Stream<Integer> listaPred = listaMain.stream().filter(MetodosReferenciados::evaluar);
		listaPred.forEach(x -> LOG.info("ValorFinal:" + x));

		// 4. FUNCTION
		Stream<String> listaFunc = listaMain.stream().map(MetodosReferenciados::aplicar);
		listaFunc.forEach(MetodosReferenciados::aceptar);

		// 5. UNARY
		Stream<String> listaUnary = listaMain.stream().map(MetodosReferenciados::aplicarUn);
		listaUnary.forEach(numero -> LOG.info(numero));

	}
}
