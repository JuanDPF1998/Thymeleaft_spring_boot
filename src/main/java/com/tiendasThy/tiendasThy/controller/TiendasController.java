package com.tiendasThy.tiendasThy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendasThy.tiendasThy.model.Tiendas;
import com.tiendasThy.tiendasThy.service.TiendasService;

@Controller
@RequestMapping("/api/tiendas")
public class TiendasController {

	@Autowired
	private TiendasService service;
	
	//METODO ACCION LISTAR TODOS 
	@GetMapping("/listar")
	public String listarTodos(Model model)
	{
		model.addAttribute("tiendas", service.listar());
		return "Listar_Tiendas";
	}
	//FORMULARIO AGREGAR NUEVO REGISTRO 
	@GetMapping("/registrar")
	public String formularioRegistrar(Model model)
	{
		model.addAttribute("tienda", new Tiendas());
		return "Agregar_Tiendas";
	}
	@PostMapping("/registrarNuevo")
	public String guardarRegistro(@ModelAttribute Tiendas tienda)
	{
		service.agregar(tienda);
		return "redirect:/api/tiendas/listar";
	}
	//FORMULARIO EDITAR / ACTUALIZAR
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable Long id, Model model)
	{
		model.addAttribute("tienda", service.obtenerPorId(id));
		return "redirect:/Editar_Tiendas";
	}
}
