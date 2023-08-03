package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepo iEstudianteRepo;

	@Override
	public void agregar(Estudiante estudiante) {
		this.iEstudianteRepo.insertar(estudiante);
		
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		return this.iEstudianteRepo.encontrarPorCedula(cedula);
	}

}
