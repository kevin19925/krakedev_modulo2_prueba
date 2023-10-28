package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.HistorialMovimiento;
import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class ServicioMovimientos {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosCategoria.class);

	public static void insertar(HistorialMovimiento movimiento) throws KrakedepException {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Movimiento a insertar>>>> "+movimiento);
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into historial_movimientos(id_producto,cantidad,fecha_movimiento)"
					+ "values(?,?,?)");
			ps.setString(1, movimiento.getId_producto().getId());
			ps.setInt(2, movimiento.getCantidad());
			ps.setDate(3,new java.sql.Date(movimiento.getFecha_movimiento().getTime()));
			
			ps.executeUpdate();
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al insertar",e);
			throw  new KrakedepException("Error al insertar");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new KrakedepException("Error con la base de datos");
			}
		}
		
	}
	public static void registrarMovimiento(String tipoMovimiento,int cantidad,Date fecha,Producto idProducto) throws KrakedepException {
		try {
			HistorialMovimiento movimiento = new HistorialMovimiento();
			movimiento.setFecha_movimiento(fecha);
			movimiento.setId_producto(idProducto);
			if(tipoMovimiento == "I") {
				movimiento.setCantidad(cantidad);
			}else if(tipoMovimiento == "S") {
				movimiento.setCantidad((cantidad*-1));
			}
			ServicioMovimientos.insertar(movimiento);
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al insertar",e);
			throw  new KrakedepException("Error al insertar");
		}
	}
}
