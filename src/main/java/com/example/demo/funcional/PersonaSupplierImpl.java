package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		String cedula = "Clase";
		cedula = cedula + " texto id";
		return cedula;	
	}
}
