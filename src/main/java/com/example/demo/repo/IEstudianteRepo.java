package com.example.demo.repo;

import com.example.demo.repo.modelo.Estudiante;

public interface IEstudianteRepo {

	public void insertar(Estudiante estudiante);
	public Estudiante encontrarPorCedula(String cedula);
	
}
