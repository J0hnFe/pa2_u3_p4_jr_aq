package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IEstudianteRepo;
import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.IMatriculaRepo;
import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Matricula;
@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepo iMatriculaRepo;

	@Autowired
	private IEstudianteRepo estudianteRepo;
	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Override
	public void agregar(String cedula, List<Materia>codigoMateria) {
		
		Estudiante estudiante=this.estudianteRepo.encontrarPorCedula(cedula);
		
		
	}

	@Override
	public List<Matricula> buscarTodos() {
		return this.iMatriculaRepo.seleccionarTodos();
	}
	

}
