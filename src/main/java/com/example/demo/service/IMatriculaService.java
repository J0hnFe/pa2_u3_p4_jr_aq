package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;

public interface IMatriculaService {

	public void agregar(String cedula, List<Materia>materias);
	public List<Matricula> buscarTodos();
	
}
