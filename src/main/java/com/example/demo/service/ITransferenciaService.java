package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repo.modelo.Transferencia;

public interface ITransferenciaService {

	public void realizarTransf(String nOrigen, String nDestino, BigDecimal monto);
	public List<Transferencia> buscarTodos();

}
