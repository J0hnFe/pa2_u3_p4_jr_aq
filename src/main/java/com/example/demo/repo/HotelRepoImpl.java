package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> seleccionarHotelInnerJoin() {
		
		//SELECT * from hotel h innner join habitacion ha on  h.hotel_id = ha.habi_id_hotel
		//
		
		String queryString = "SELECT h from Hotel h JOIN h.habitaciones ha";
		
		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);		
		return query.getResultList();
	}

}
