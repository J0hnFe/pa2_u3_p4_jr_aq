package com.example.demo.funcional;

import java.math.BigDecimal;

public class PersonaUnaryImpl implements IPersonaUnary<BigDecimal>{

	@Override
	public BigDecimal aplicar(BigDecimal arg) {
		BigDecimal iva = arg.multiply(new BigDecimal(0.12));
		return iva;
	}
}
