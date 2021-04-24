package com.proyecto.springboot.form.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.springboot.form.model.Cliente;
import com.proyecto.springboot.form.model.Factura;

@RestController
public class FacturaController {
	
	
	ArrayList <Factura> facturas = new ArrayList();
	
	
	@RequestMapping(value = "/create/{cedula}/{address}/{name}", method = RequestMethod.POST)
	public @ResponseBody String registrarFactura(@RequestBody Factura f, @PathVariable int cedula,  
												 @PathVariable String address,  @PathVariable String name) {
		Random rand = new Random();
		//c = new Cliente(name, cedula, address);							
		f.setId(rand.nextInt(10000));
		f.setFecha(new Date());
		f.setCedula(cedula);
		f.calcular_total();
		
		
		if (f.getTotal() <= 70000) {
			return "Para crear una factura, el total debe ser mayor a 70000, la factura actual suma "+f.getTotal();
		}
		else {
			facturas.add(f);
			return "Factura creada con numero: "+f.getId()+", para el cliente con cédula: "+f.getCedula()+", \n"
					+"En la fecha: "+f.getFecha().getDate()+", con el valor total (incluye iva): "+f.getTotal_iva()+", \n"
					+ " y domicilio "+f.getTotal_domicilio()+" y la dirección: "+address+", del cliente: "+name+".";			
		}		
		
	}
	
	@RequestMapping (value = "/edit/{cedula}", method = RequestMethod.POST)
	public @ResponseBody String editar (@RequestBody Factura f, @PathVariable int cedula) {
		Date nueva = new Date();
		Factura actual = null;
		for (int i = 0; i < this.facturas.size(); i++) {
			if (facturas.get(i).getCedula() == cedula) {
				actual = facturas.get(i);
				break;
			}
		}
		if (actual == null) {
			return "no se encontró la factura para la cédula ingresada";
			
		}else {
			if ((nueva.getTime() - actual.getFecha().getTime()) < 18000000) {
				f.calcular_total();
				
				if (f.getTotal() >= actual.getTotal()) {					
					for (int i = 0; i < this.facturas.size(); i++) {
						if (facturas.get(i).getCedula() == cedula) {
							facturas.get(i).setProductos(f.getProductos());
							facturas.get(i).calcular_total();
							break;
						}						
					}
					return "Cambios efectuados, y valor actual de: (iva incluido)"+f.getTotal_iva()+" y domicilio: "+f.getTotal_domicilio();
				}
				else {
					return "no se pueden efectuar los cambios ya que el valor de la factura nueva es menor al actual";
				}				
			}						
			else {
				return "no se pueden efectuar los cambios ya que la orden se realizó hace 5 horas o más";
			}
		}
				
	}
	
	 
	@RequestMapping(value = "/delete/{cedula}", method = RequestMethod.POST)
	public @ResponseBody String eliminar (@PathVariable int cedula) {
		
		Date el = new Date();
		
		for (int i = 0; i < this.facturas.size(); i++) {
			if (facturas.get(i).getCedula() == cedula) {
				Factura actual = facturas.get(i);				
				if (actual.isCancelado()) {
					return "no se puede cancelar una orden ya cancelada";
				}else {
					if (el.getTime() - actual.getFecha().getTime() < 43200000) {						
						actual.setCancelado(true);						
						return "factura cancelada, debe pagar un total de "+actual.getTotal();
					}					
				}											
				break;
			}
		}
		
		return "no se encontró una factura para cancelar";
	}

}
