package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.excepciones.KrakedepException;
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
