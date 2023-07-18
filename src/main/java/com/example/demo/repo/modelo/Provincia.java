package com.example.demo.repo.modelo;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "provincia")
public class Provincia {

	@Id
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	@Column(name = "prov_nombre")
	private String nombre;
	@Column(name = "prov_capital")
	private String capital;
	
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante> estudiantes;
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCapital() {
		return capital;
	}



	public void setCapital(String capital) {
		this.capital = capital;
	}



	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}



	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}



	public Integer getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", capital=" + capital + "]";
	}
	
	
	
	
}
