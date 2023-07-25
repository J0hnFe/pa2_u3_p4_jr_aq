package com.example.demo.repo;

import com.example.demo.repo.modelo.CtaBancaria;

public interface ICtaBancariaRepo {
	
	public void insertar(CtaBancaria cb);
	public CtaBancaria seleccionar(String numero);
	public void actualizar(CtaBancaria cb);

}
