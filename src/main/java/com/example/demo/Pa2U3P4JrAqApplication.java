package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Estudiante;
import com.example.demo.repo.modelo.Materia;
import com.example.demo.repo.modelo.Provincia;
import com.example.demo.repo.modelo.Semestre;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U3P4JrAqApplication implements CommandLineRunner {

	@Autowired
	private IMateriaService iMateriaService;

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JrAqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Semestre semestre = new Semestre();
		semestre.setNumero("3");

		Materia materia = new Materia();
		materia.setCodigo("1236");
		materia.setNombre("Matematicas");
		materia.setSemestre(semestre);

		// this.iMateriaService.agregar(materia);

		Semestre semestre2 = new Semestre();
		semestre2.setNumero("4");

		Materia materia2 = new Materia();
		materia2.setCodigo("111");
		materia2.setNombre("Progra");
		materia2.setSemestre(semestre2);

		// this.iMateriaService.agregar(materia2);

		Semestre semestre3 = new Semestre();
		semestre3.setNumero("5");

		Materia materia3 = new Materia();
		materia3.setCodigo("5555");
		materia3.setNombre("Redes");
		materia3.setSemestre(semestre3);

//		this.iMateriaService.agregar(materia3);

		Provincia provincia = new Provincia();
		provincia.setNombre("Azuay");
		provincia.setCapital("Cuenca");

		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Jimmy");
		estudiante.setApellido("Ortega");
		estudiante.setCedula("123");
		estudiante.setProvincia(provincia);
		// this.estudianteService.agregar(estudiante);

		List<String> codigosMatriculas = new ArrayList<>();
		String codigoM = "1236";
		String codigoM2 = "5555";
		codigosMatriculas.add(codigoM);
		codigosMatriculas.add(codigoM2);

//		this.iMatriculaService.agregar("123", codigosMatriculas);

		this.iMatriculaService.buscarTodos().stream().forEach(System.out::println);

	}

}
