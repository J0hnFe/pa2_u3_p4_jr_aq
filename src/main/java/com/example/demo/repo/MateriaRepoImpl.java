package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}






	@Override
	public List<Materia> encontrarTodos() {
		TypedQuery<Materia>query=this.entityManager.createQuery("SELECT e FROM Materia e ",Materia.class);
		
		return query.getResultList();
	}






	@Override
	public Materia encontrarPorcodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia>query=this.entityManager.createQuery("SELECT e FROM Materia e WHERE e.codigo = :datoCodigo",Materia.class);
		query.setParameter("datoCodigo", codigo);
		
		return query.getSingleResult();
	}





}
