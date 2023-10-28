package com.krakedev.evaluacion.test;

import java.util.Date;

import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.utils.Convertidor;

public class TestConvertidor {

	public static void main(String[] args) {
		try {
			Date fecha = Convertidor.convertirFecha("2000/12/23");
			Date hora = Convertidor.convertirHora("09:23");
			Date fechaCom = Convertidor.convertirFechaCompleta("22-01-2000 21:23:00");
			System.out.println(fecha);
			System.out.println(hora);
			System.out.println(fechaCom);
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
		

	}

}