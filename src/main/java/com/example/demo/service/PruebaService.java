package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaService implements IPruebaService{

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba");
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba 2");
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba supports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		System.out.println("Metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba not supported");
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		System.out.println("Metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba required");
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		System.out.println("Metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba requires new");
	}

}
