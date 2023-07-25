package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICtaBancariaRepo;
import com.example.demo.repo.modelo.CtaBancaria;

@Service
public class CtaBancariaServiceImpl implements ICtaBancariaService{
	
	@Autowired
	private ICtaBancariaRepo ctaBancariaRepo;

	@Override
	public void agregar(CtaBancaria cb) {
		this.ctaBancariaRepo.insertar(cb);
	}

	@Override
	public CtaBancaria buscar(String numero) {
		return this.ctaBancariaRepo.seleccionar(numero);
	}

	@Override
	public void actualizar(CtaBancaria cb) {
		this.ctaBancariaRepo.actualizar(cb);
	}

}
