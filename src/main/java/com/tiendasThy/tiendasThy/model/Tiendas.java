package com.tiendasThy.tiendasThy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tiendas")
public class Tiendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Column(name = "zona", nullable = false, length = 50)
	private String zona;
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	@Column(name = "telefono", nullable = false, length = 12)
	private String telefono;
	
	public Tiendas()
	{
		super();
	}

	public Tiendas(String nombre, String zona, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.zona = zona;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Tiendas(Long id, String nombre, String zona, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.zona = zona;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Tiendas [id=" + id + ", nombre=" + nombre + ", zona=" + zona + ", direccion=" + direccion
				+ ", telefono=" + telefono + "]";
	}
}
