package com.example.demo.service;

import java.util.List;


import com.example.demo.repo.modelo.Matricula;

public interface IMatriculaService {

	public void agregar(String cedula, List<String>materias);
	public List<Matricula> buscarTodos();
	
}
