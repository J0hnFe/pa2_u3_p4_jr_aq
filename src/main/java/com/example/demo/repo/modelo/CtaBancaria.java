package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.util.List;

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
@Table(name = "cuenta_bancaria")
public class CtaBancaria {
	
	@Id
	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@GeneratedValue(generator = "seq_cuenta_bancaria", strategy = GenerationType.SEQUENCE)
	@Column(name = "cta_id")
	private Integer id;
	@Column(name = "cta_numero")
	private String numero;
	@Column(name = "cta_saldo")
	private BigDecimal saldo;
	@Column(name = "cta_tipo")
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "cta_id_propietario")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "ctaBancariaOrigen")
	private List<Transferencia> transferenciasO;
	
	@OneToMany(mappedBy = "ctaBancariaDestino")
	private List<Transferencia> transferenciasD;

	//Setters y Getters
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Transferencia> getTransferenciasO() {
		return transferenciasO;
	}

	public void setTransferenciasO(List<Transferencia> transferenciasO) {
		this.transferenciasO = transferenciasO;
	}

	public List<Transferencia> getTransferenciasD() {
		return transferenciasD;
	}

	public void setTransferenciasD(List<Transferencia> transferenciasD) {
		this.transferenciasD = transferenciasD;
	}

	public Integer getId() {
		return id;
	}

	//toString
	@Override
	public String toString() {
		return "CtaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + ", propietario="
				+ propietario + "]";
	}
		
}
