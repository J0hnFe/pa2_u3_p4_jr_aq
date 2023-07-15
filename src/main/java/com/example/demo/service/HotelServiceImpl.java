package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IHotelRepo;
import com.example.demo.repo.modelo.Habitacion;
import com.example.demo.repo.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepo hotelRepo;

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		return this.hotelRepo.seleccionarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		return this.hotelRepo.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		return this.hotelRepo.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		return this.hotelRepo.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		return this.hotelRepo.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		return this.hotelRepo.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarFetchJoin() {
		return this.hotelRepo.seleccionarFetchJoin();
	}

	@Override
	public void agregar(Hotel h) {

		h.getHabitaciones().forEach(a -> {
			BigDecimal valorIva = a.getValor().multiply(new BigDecimal(1.12));
			a.setValorIncluidoIVA(valorIva.add(a.getValor()));
		});
		this.hotelRepo.insertar(h);
	}

}
