package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaPredicate <T>{

	public boolean evaluar(T arg);
	
}
