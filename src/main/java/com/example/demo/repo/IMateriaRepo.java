package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Materia;

public interface IMateriaRepo {

	public void insertar(Materia materia);
	public List<Materia> encontrarTodos();
	public Materia encontrarPorcodigo(String codigo);
	
}
