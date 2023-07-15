package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Habitacion;
import com.example.demo.repo.modelo.Hotel;

public interface IHotelService {

	public void agregar(Hotel h);

	public List<Hotel> buscarHotelInnerJoin();

	public List<Hotel> buscarOuterRightJoin();

	public List<Hotel> buscarOuterLeftJoin();

	public List<Habitacion> buscarHabitacionOuterLeftJoin();

	public List<Hotel> buscarOuterFullJoin();

	public List<Hotel> buscarWhereJoin();

	public List<Hotel> buscarFetchJoin();

}
