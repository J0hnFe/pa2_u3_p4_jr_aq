package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repo.modelo.Propietario;
import com.example.demo.service.ICtaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4JrAqApplication implements CommandLineRunner{

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

		
		System.out.println("Main: " + TransactionSynchronizationManager.isActualTransactionActive());
		
		Propietario propietario1 = new Propietario();
		propietario1.setNombre("Juan");
		propietario1.setApellido("Perez");
		propietario1.setCedula("003");
		
		this.propietarioService.agregar(propietario1);
	}
}
