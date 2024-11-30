package com.tiendasThy.tiendasThy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiendasThy.tiendasThy.model.Tiendas;
import com.tiendasThy.tiendasThy.service.TiendasService;

@Controller
@RequestMapping("/api/tiendas")
public class TiendasController {

	@Autowired
	private TiendasService service;
	
	//ACCION METODO LISTAR
	@GetMapping("/listar")
	public String listarTodos(Model model)
	{
		model.addAttribute("tiendas", service.listar());
		return "Listar_Tiendas";
	}
	//MUESTRA FORMULARIO DE LA VISTA INSERTAR 
	@GetMapping("/registrar")
	public String formularioRegistrar(Model model)
	{
		model.addAttribute("tienda", new Tiendas());
		return "Agregar_Tiendas";
	}
	//METODO ACCION INSERTAR
	@PostMapping("/registrarNuevo")
	public String guardarRegistro(@ModelAttribute Tiendas tienda)
	{
		service.agregar(tienda);
		return "redirect:/api/tiendas/listar";
	}
	//MUESTRA FORMULARIO REGISTRO POR ID
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable Long id, Model model)
	{
		model.addAttribute("tienda", service.obtenerPorId(id));
		return "Editar_Tiendas";
	}
	//ACCION METODO ACTUALIZAR POR ID
	@PostMapping("/actualizar/{id}")
	public String actualizarRegistro(@PathVariable Long id, @ModelAttribute("tienda") Tiendas tiendas, Model model)
	{
		Tiendas existe = service.obtenerPorId(id);
		existe.setId(id);
		existe.setNombre(tiendas.getNombre());
		existe.setZona(tiendas.getZona());
		existe.setDireccion(tiendas.getDireccion());
		existe.setTelefono(tiendas.getTelefono());
		
		service.agregar(existe);
		return "redirect:/api/tiendas/listar";
	}
	//ACCION METODO ELIMINAR POD ID
	@GetMapping("/eliminar/{id}")
	public String eliminarPorId(@PathVariable Long id)
	{
		service.eliminarPorId(id);
		return "redirect:/api/tiendas/listar";
	}
}
