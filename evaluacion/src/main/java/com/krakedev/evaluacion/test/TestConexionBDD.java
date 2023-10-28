package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		ConexionBDD con = new ConexionBDD();
		try {
			con.conectar();
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}

	}

}
