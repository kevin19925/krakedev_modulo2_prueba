package com.krakedev.evaluacion.test;

import java.math.BigDecimal;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosProducto;

public class TestInsertarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Categoria c = new Categoria("C001","Frutas");
		
		try {
			//ServiciosCategoria.insertar(c);
			ServiciosProducto.insertar(new Producto("P0008","ppp", new BigDecimal(20), new BigDecimal(20),  c));
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
