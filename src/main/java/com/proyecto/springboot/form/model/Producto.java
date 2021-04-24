package com.proyecto.springboot.form.model;

public class Producto {
	
	int id;
	String nombre;
	double valor;	
	int factura_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getFactura_id() {
		return factura_id;
	}
	public void setFactura_id(int factura_id) {
		this.factura_id = factura_id;
	}
	public Producto(int id, String nombre, double valor, int factura_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.factura_id = factura_id;
	}
	
	

}
