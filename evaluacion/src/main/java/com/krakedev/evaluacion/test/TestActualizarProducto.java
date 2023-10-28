package com.krakedev.evaluacion.test;
import java.math.BigDecimal;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.servicios.ServiciosProducto;
public class TestActualizarProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Categoria cat =new Categoria("C001","xxxx");
		Producto c = new Producto("P0002", "Cerveza", new BigDecimal(1230.45), new BigDecimal(1230.45) ,cat);
		try {
			ServiciosProducto.actualizar(c);
		} catch (KrakedepException e) {
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
