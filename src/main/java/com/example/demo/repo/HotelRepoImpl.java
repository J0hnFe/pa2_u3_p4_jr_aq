package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Habitacion;
import com.example.demo.repo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> seleccionarHotelInnerJoin() {

		// SELECT * from hotel h innner join habitacion ha on h.hotel_id =
		// ha.habi_id_hotel
		//

		String queryString = "SELECT h from Hotel h INNER JOIN h.habitaciones ha";

		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);

		List<Hotel> listaHoteles = query.getResultList();
		for (Hotel h : listaHoteles) {
			h.getHabitaciones().size();
		}

		return listaHoteles;
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		String queryString = "SELECT h from Hotel h RIGHT JOIN h.habitaciones ha";

		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		String queryString = "SELECT h from Hotel h LEFT JOIN h.habitaciones ha";

		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		String queryString = "SELECT ha from Hotel h LEFT JOIN h.habitaciones ha";

		TypedQuery<Habitacion> query = this.entityManager.createQuery(queryString, Habitacion.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		String queryString = "SELECT h from Hotel h FULL JOIN h.habitaciones ha";

		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// SELECT h.* from hotel h, habitacion ha WHERE h.hotel_id = ha.habi_id_hotel

		String queryString = "SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel";

		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		String queryString = "SELECT h from Hotel h JOIN FETCH h.habitaciones ha";
		TypedQuery<Hotel> query = this.entityManager.createQuery(queryString, Hotel.class);
		return query.getResultList();
	}

	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);
	}

}
