package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestActualizarCategoria {

	public static void main(String[] args) {
		Categoria c = new Categoria("C004","Vegetales");
		try {
			ServiciosCategoria.actualizar(c);
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
