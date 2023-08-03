package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IMateriaRepo;
import com.example.demo.repo.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo iMateriaRepo;

	@Override
	public void agregar(Materia materia) {
		// TODO Auto-generated method stub

		this.iMateriaRepo.insertar(materia);

	}

	@Override
	public List<Materia> buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepo.encontrarTodos();
	}

	@Override
	public Materia buscarPorcodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepo.encontrarPorcodigo(codigo);
	}

}
