package com.example.demo.repo;

import com.example.demo.repo.modelo.Propietario;

public interface IPropietarioRepo {
	
	public void insertar(Propietario p);
	public Propietario seleccionar(String cedula);

}
