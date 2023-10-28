package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestBuscarCategoria {

	public static void main(String[] args) {
		try {
			Categoria c = ServiciosCategoria.buscarPorId("C005");
			if(c.getId() != null) {
				System.out.println(c);
			}else {
				System.out.println("No existe la cateogoría buscada");
			}
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
