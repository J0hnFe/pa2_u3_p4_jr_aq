package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Hotel;

public interface IHotelRepo {
	
//	public void insertar(Hotel h)

	public List<Hotel> seleccionarHotelInnerJoin();
	
}
