package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaConsumer <T> {

	public void accept(T arg);
	
}
