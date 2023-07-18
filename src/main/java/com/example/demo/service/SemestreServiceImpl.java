package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ISemestreRepo;
import com.example.demo.repo.modelo.Semestre;
@Service
public class SemestreServiceImpl implements ISemestreService {

	@Autowired
	private ISemestreRepo iSemestreRepo;
	
	@Override
	public Semestre encontrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iSemestreRepo.encontrarPorNumero(numero);
	}

}
