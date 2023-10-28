package com.krakedev.evaluacion.test;

import java.util.ArrayList;



import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;
import com.krakedev.evaluacion.servicios.ServiciosProducto;


public class TestRecuperarProductos {

	public static void main(String[] args) {
		try {
			ArrayList<Producto> P = ServiciosProducto.recuperarTodos() ;
			for (Producto producto : P) {
				System.out.println(producto);
			}
			
		} catch (KrakedepException e) {
			System.out.println(e.getMessage());
		}
	}

}
