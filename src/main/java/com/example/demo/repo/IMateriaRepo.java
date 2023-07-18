package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Materia;

public interface IMateriaRepo {

	public void insertar(Materia materia);
	public Materia encontrarPorCodigo(String codigo);
	
}
