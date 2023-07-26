package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Transferencia t) {
		this.entityManager.persist(t);
//		throw new RuntimeException();
	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		String jpql = "SELECT t FROM Transferencia t";
		TypedQuery<Transferencia> query = this.entityManager.createQuery(jpql, Transferencia.class);
		
		return query.getResultList();
	}

}
