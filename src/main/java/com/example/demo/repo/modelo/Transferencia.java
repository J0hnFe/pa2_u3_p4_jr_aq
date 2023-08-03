package com.example.demo.repo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {
	
	@Id
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
	@Column(name = "tran_id")
	private Integer id;
	@Column(name = "tran_fecha")
	private LocalDate fecha;
	@Column(name = "tran_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_cuenta_bancaria_origen")
	private CtaBancaria ctaBancariaOrigen;
	@ManyToOne
	@JoinColumn(name = "tran_id_cuenta_bancaria_destino")
	private CtaBancaria ctaBancariaDestino;
	
	//Getters y Setters
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public CtaBancaria getCtaBancariaOrigen() {
		return ctaBancariaOrigen;
	}
	public void setCtaBancariaOrigen(CtaBancaria ctaBancariaOrigen) {
		this.ctaBancariaOrigen = ctaBancariaOrigen;
	}
	public CtaBancaria getCtaBancariaDestino() {
		return ctaBancariaDestino;
	}
	public void setCtaBancariaDestino(CtaBancaria ctaBancariaDestino) {
		this.ctaBancariaDestino = ctaBancariaDestino;
	}
	public Integer getId() {
		return id;
	}
	
	//toString
	@Override
	public String toString() {
		return "Transferencia " + id + "\nFecha: " + fecha + ", monto: " + monto + ", ctaBancariaOrigen: "
				+ ctaBancariaOrigen + ", ctaBancariaDestino: " + ctaBancariaDestino;
	}
	
}
