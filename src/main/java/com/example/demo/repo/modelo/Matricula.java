package com.example.demo.repo.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@Column(name = "matr_id")
	
	
	private Integer id;
	@Column(name = "matr_numero")
	private String numero;
	@Column(name = "matr_fecha")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_estudiante")
	private Estudiante estudiante;
	
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", numero=" + numero + ", fecha=" + fecha + "]";
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public Materia getMateria() {
		return materia;
	}



	public void setMateria(Materia materia) {
		this.materia = materia;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}



	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
	
	
}
