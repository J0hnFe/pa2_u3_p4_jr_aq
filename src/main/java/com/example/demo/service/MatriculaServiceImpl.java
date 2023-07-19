package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
	public void agregar(String cedula, List<String> codigoMateria) {

		Estudiante estudiante = this.estudianteRepo.encontrarPorCedula(cedula);

		codigoMateria.stream().forEach(a -> {
			Materia materiaE = this.iMateriaRepo.encontrarPorcodigo(a);
			Matricula matricula = new Matricula();
			matricula.setFecha(LocalDate.now());
			matricula.setEstudiante(estudiante);
			matricula.setMateria(materiaE);
			Random random = new Random();
			Integer rd = random.nextInt(101);
			matricula.setNumero(rd.toString());
			
			this.iMatriculaRepo.insertar(matricula);
		});

	}

	@Override
	public List<Matricula> buscarTodos() {
		return this.iMatriculaRepo.seleccionarTodos();
	}

}
