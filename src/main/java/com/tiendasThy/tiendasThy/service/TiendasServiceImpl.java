package com.tiendasThy.tiendasThy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendasThy.tiendasThy.model.Tiendas;
import com.tiendasThy.tiendasThy.repository.TiendasRepository;

@Service
public class TiendasServiceImpl implements TiendasService{

	@Autowired
	private TiendasRepository repository;

	@Override
	public List<Tiendas> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Tiendas agregar(Tiendas tiendas) {
		// TODO Auto-generated method stub
		return repository.save(tiendas);
	}

	@Override
	public Tiendas obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Tiendas actualizar(Tiendas tiendas) {
		// TODO Auto-generated method stub
		return repository.save(tiendas);
	}

	@Override
	public void eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}	
}
