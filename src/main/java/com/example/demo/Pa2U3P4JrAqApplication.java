package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.aspectj.runtime.CFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repo.modelo.CtaBancaria;
import com.example.demo.service.ICtaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4JrAqApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4JrAqApplication.class);

	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private ITransferenciaService transferenciaService;
	@Autowired
	private ICtaBancariaService ctaBancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JrAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// asincrono sin retorno
//
//		LOG.info("Hilo: " + Thread.currentThread().getName());
//
//		// Inicio
//		long tiempoInicial = System.currentTimeMillis();
//		List<CtaBancaria> lista = new ArrayList<>();
//
//		for (int i = 1; i <= 10; i++) {
//
//			CtaBancaria ctaFor = new CtaBancaria();
//			ctaFor.setNumero(String.valueOf(i));
//			ctaFor.setSaldo(new BigDecimal(100));
//			ctaFor.setTipo("A");
//			lista.add(ctaFor);
//			
//		this.ctaBancariaService.agregarAsincrono(ctaFor);
//
//		}
//
//		// Final
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
//		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
//		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
//		
//		LOG.info("C  termino todo ☺ : ");

//Asincrono con respuesta
		LOG.info("Hilo: " + Thread.currentThread().getName());

		// Inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
		List<CtaBancaria> lista = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {

			CtaBancaria ctaFor = new CtaBancaria();
			ctaFor.setNumero(String.valueOf(i));
			ctaFor.setSaldo(new BigDecimal(100));
			ctaFor.setTipo("A");
			lista.add(ctaFor);

			CompletableFuture<String> respuesta = this.ctaBancariaService.agregarAsincrono2(ctaFor);

			listaRespuestas.add(respuesta);

		}
		
		//Sentencia que espera que terminen de procesarse 
 		//todos los hilos para obtener la respuesta
		CompletableFuture.allOf(
				listaRespuestas.get(0), 
				listaRespuestas.get(1),
				listaRespuestas.get(2),
				listaRespuestas.get(3),
				listaRespuestas.get(4),
				listaRespuestas.get(5),
				listaRespuestas.get(6),
				listaRespuestas.get(7),
				listaRespuestas.get(8),
				listaRespuestas.get(9)
				);
		
		LOG.info("Respuesta 0: " + listaRespuestas.get(0).get());

		// Final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido en seg: " + tiempoTranscurrido);

		LOG.info("C  termino todo ☺ : ");

	}
}
