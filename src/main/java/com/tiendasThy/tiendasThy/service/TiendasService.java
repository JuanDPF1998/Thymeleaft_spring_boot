package com.tiendasThy.tiendasThy.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tiendasThy.tiendasThy.model.Tiendas;

public interface TiendasService {

	public List<Tiendas> listar();
	public Tiendas agregar(@RequestBody Tiendas tiendas);
	public Tiendas actualizar(@RequestBody Tiendas tiendas);
	public Tiendas obtenerPorId(@PathVariable Long id);
	public void eliminarPorId(@PathVariable Long id);
}
