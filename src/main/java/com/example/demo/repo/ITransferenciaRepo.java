package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Transferencia;

public interface ITransferenciaRepo {
	
	public void insertar(Transferencia t);
	public List<Transferencia> seleccionarTodos();

}
