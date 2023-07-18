package com.example.demo.repo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "semestre")
public class Semestre {


	@Id
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@Column(name = "seme_id")
	
	private Integer id;
	@Column(name = "seme_numero")
	private String numero;
	
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia>materias;
	
	
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", numero=" + numero + "]";
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


	public List<Materia> getMaterias() {
		return materias;
	}


	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	
	
}
