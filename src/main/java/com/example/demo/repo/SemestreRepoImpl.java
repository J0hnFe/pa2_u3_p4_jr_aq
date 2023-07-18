package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Semestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SemestreRepoImpl implements ISemestreRepo{

	@PersistenceContext 
	private EntityManager entityManager;
	
	@Override
	public Semestre encontrarPorNumero(String numero) {
	TypedQuery<Semestre>query=this.entityManager.createQuery("SELECT e FROM Semestre e WHERE e.numero = :datoNumero",Semestre.class);
	query.setParameter("datoNumero", numero);
	return query.getSingleResult();
	}

}
