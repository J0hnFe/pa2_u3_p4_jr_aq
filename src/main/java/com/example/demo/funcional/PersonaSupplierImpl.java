package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String>{

	@Override
	public String getId() {
		
		String cedula = "1234";
		cedula = cedula + "zzz";
		
		return cedula;
		
	}

}
