package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaUnary <T>{

	public T aplicar(T arg);
	
}
