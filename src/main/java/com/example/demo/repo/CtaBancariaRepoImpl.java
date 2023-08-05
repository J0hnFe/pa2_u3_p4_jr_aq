package com.example.demo.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.Pa2U3P4JrAqApplication;
import com.example.demo.repo.modelo.CtaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CtaBancariaRepoImpl implements ICtaBancariaRepo{
	
	private static final Logger LOG = LoggerFactory.getLogger(CtaBancariaRepoImpl.class); 
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CtaBancaria cb) {
		
		LOG.info("Hilo repo: " + Thread.currentThread().getName()); //Indicar el hilo con el que se ejecuta el prog

		
		this.entityManager.persist(cb);
	}

	@Override
	public CtaBancaria seleccionar(String numero) {
		String jpql = "SELECT cb FROM CtaBancaria cb WHERE cb.numero = :datoNumero";
		TypedQuery<CtaBancaria> query = this.entityManager.createQuery(jpql, CtaBancaria.class);
		query.setParameter("datoNumero", numero);
				
		return query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CtaBancaria cb) {
		this.entityManager.merge(cb);
	}

}
