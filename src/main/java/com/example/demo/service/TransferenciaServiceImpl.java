package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICtaBancariaRepo;
import com.example.demo.repo.ITransferenciaRepo;
import com.example.demo.repo.modelo.CtaBancaria;
import com.example.demo.repo.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ITransferenciaRepo transferenciaRepo;
	@Autowired
	private ICtaBancariaRepo ctaBancariaRepo;

	@Override
	public void realizarTransf(String nOrigen, String nDestino, BigDecimal monto) {
		CtaBancaria ctaBancariaOrigen = this.ctaBancariaRepo.seleccionar(nOrigen);
		CtaBancaria ctaBancariaDestino = this.ctaBancariaRepo.seleccionar(nDestino);
		
		Transferencia transferencia = new Transferencia();
		transferencia.setCtaBancariaDestino(ctaBancariaDestino);
		transferencia.setCtaBancariaOrigen(ctaBancariaOrigen);
		transferencia.setFecha(LocalDate.now());
		transferencia.setMonto(monto);
		
		BigDecimal saldoOrigen = ctaBancariaOrigen.getSaldo();
		BigDecimal saldoDestino = ctaBancariaDestino.getSaldo();
		
		if(saldoOrigen.compareTo(monto) >= 0) {
			ctaBancariaOrigen.setSaldo(saldoOrigen.subtract(monto));			
			ctaBancariaDestino.setSaldo(saldoDestino.add(monto));
			
			this.ctaBancariaRepo.actualizar(ctaBancariaOrigen);
			this.ctaBancariaRepo.actualizar(ctaBancariaDestino);
			this.transferenciaRepo.insertar(transferencia);
			
		} else {
			System.out.println("Error al realizar la transferencia");
		}
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		return this.transferenciaRepo.seleccionarTodos();
	}

}
