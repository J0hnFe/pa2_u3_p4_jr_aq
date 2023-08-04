package com.example.demo.funcional;

public class PersonaFunctionImpl implements IPersonaFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg) {
		String valorTransformado = "clase - valor convertido a string: ".concat(arg.toString());
		return valorTransformado;
	}
}
