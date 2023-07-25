package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.CtaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CtaBancariaRepoImpl implements ICtaBancariaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CtaBancaria cb) {
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
	public void actualizar(CtaBancaria cb) {
		this.entityManager.merge(cb);
	}

}
