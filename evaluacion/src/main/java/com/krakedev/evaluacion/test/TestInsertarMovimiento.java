package com.krakedev.evaluacion.test;

import java.util.Date;

import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServicioMovimientos;
import com.krakedev.evaluacion.utils.Convertidor;
import com.krakedev.evaluacion.utils.TipoMovimientos;

public class TestInsertarMovimiento {

	public static void main(String[] args) {
		Producto p = new Producto();
		Date fechaIngreso,fechaEgreso;
		try {
			p.setId("P0001");
			fechaIngreso = Convertidor.convertirFechaCompleta("22-01-2000 21:23:54");
			fechaEgreso = Convertidor.convertirFechaCompleta("28-01-2000 21:23:20");
			System.out.println(fechaIngreso);
			ServicioMov imientos.registrarMovimiento(TipoMovimientos.INGRESO ,100, fechaIngreso, p); 
			ServicioMovimientos.registrarMovimiento(TipoMovimientos.SALIDA ,20, fechaEgreso, p); 
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
