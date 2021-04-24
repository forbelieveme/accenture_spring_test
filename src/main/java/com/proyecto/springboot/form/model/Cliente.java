package com.proyecto.springboot.form.model;

public class Cliente {
	
	String nombre;
	int cedula;
	String direccion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente(String nombre, int cedula, String direccion) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.direccion = direccion;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	
	
	

}
