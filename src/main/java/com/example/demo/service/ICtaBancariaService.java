package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repo.modelo.CtaBancaria;

public interface ICtaBancariaService {

	public void agregar(CtaBancaria cb);

	public CtaBancaria buscar(String numero);

	public void actualizar(CtaBancaria cb);

	public String agregar2(CtaBancaria bancaria);

	public void agregarAsincrono(CtaBancaria bancaria);
	
	public  CompletableFuture<String> agregarAsincrono2(CtaBancaria bancaria);
	
	
	
	
	
}
