package com.krakedev.evaluacion.test;

import java.math.BigDecimal;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;
import com.krakedev.evaluacion.servicios.ServiciosProducto;

public class TestEliminarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//ServiciosCategoria.insertar(c);
			ServiciosProducto.Eliminar(  "P0008");
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
