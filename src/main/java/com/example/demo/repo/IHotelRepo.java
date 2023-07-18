package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Habitacion;
import com.example.demo.repo.modelo.Hotel;

public interface IHotelRepo {
	
//	public void insertar(Hotel h)

	public List<Hotel> seleccionarHotelInnerJoin();
	public List<Hotel> seleccionarOuterRightJoin();
	public List<Hotel> seleccionarOuterLeftJoin();
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	public List<Hotel> seleccionarOuterFullJoin();
	
	public List<Hotel> seleccionarWhereJoin();
	
	public List<Hotel> seleccionarFetchJoin();
	
	
	public void ingresar(Hotel hotel);
	
	
	
	
}
