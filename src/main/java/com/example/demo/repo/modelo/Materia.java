package com.example.demo.repo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@Table(name = "materia")
public class Materia {


	@Id
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@Column(name = "mate_id")
	
	private Integer id;
	@Column(name = "mate_codigo")
	private String codigo;
	@Column(name = "mate_nombre")
	private String nombre;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mate_id_semestre")
	private Semestre semestre;
	
	@OneToMany(mappedBy = "materia")
	private List<Matricula>matriculas;
	
	@Override
	public String toString() {
		return "Materia [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Semestre getSemestre() {
		return semestre;
	}


	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}


	public List<Matricula> getMatriculas() {
		return matriculas;
	}


	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	
	
	
}
