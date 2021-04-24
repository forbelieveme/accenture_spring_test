package com.proyecto.springboot.form.model;


import java.util.Arrays;
import java.util.Date;


public class Factura {
	
	int id;
	int cedula;
	Date fecha;
	Producto [] Productos;
	double total;	
	double total_iva;	
	double total_domicilio;
	boolean cancelado;
	
		
	
	
	
	public boolean isCancelado() {
		return cancelado;
	}




	public void setCancelado(boolean cancelado) {
		this.total_domicilio = 0;
		this.total_iva = 0;
		this.total = this.total*0.1;
		this.cancelado = cancelado;
	}




	public Factura(int id, Date fecha, Producto [] productos, int cedula){
		this.id = id;
		this.fecha = fecha;
		Productos = productos;		
		this.cedula = cedula; 
	}
	



	public void calcular_total () {
		this.total = 0;
		for (int i = 0; i < this.Productos.length; i++) {
			Productos[i].setFactura_id(id);
			this.total = this.total + Productos[i].getValor();
		}
		
		this.total_iva = this.total + this.total*0.19;
		
		if (this.total > 70000 && this.total <= 100000) {
			this.total_domicilio = 5000;
		}else if (this.total >100000) {
			this.total_domicilio = 0;
		}
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Date getFecha() {
		return fecha;
	}




	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}




	public Producto[] getProductos() {
		return Productos;
	}




	public void setProductos(Producto[] productos) {
		Productos = productos;
	}




	public double getTotal() {
		return total;
	}




	public void setTotal(double total) {
		this.total = total;
	}




	public double getTotal_iva() {
		return total_iva;
	}




	public void setTotal_iva(double total_iva) {
		this.total_iva = total_iva;
	}




	public double getTotal_domicilio() {
		return total_domicilio;
	}




	public void setTotal_domicilio(double total_domicilio) {
		this.total_domicilio = total_domicilio;
	}




	public int getCedula() {
		return cedula;
	}




	public void setCedula(int cedula) {
		this.cedula = cedula;
	}




	@Override
	public String toString() {
		return "Factura [id=" + id + ", cedula=" + cedula + ", fecha=" + fecha + ", Productos="
				+ Arrays.toString(Productos) + ", total=" + total + ", total_iva=" + total_iva + ", total_domicilio="
				+ total_domicilio + "]";
	}	
	
	
	

}
