package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.entidades.Producto;
import com.krakedev.evaluacion.excepciones.KrakedepException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class ServiciosProducto {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosProducto.class);

	public static ArrayList<Categoria> recuperarTodos() throws KrakedepException {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>() ;
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from categorias");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getString("id"));
				c.setNombre(rs.getString("nombre"));
		
				categorias.add(c);
			}
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al recuperar categorias",e);
			throw  new KrakedepException("Error al recuperar categorias");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new KrakedepException("Error con la base de datos");
			}
		}
		return categorias;
		
	}
	public static Categoria buscarPorId(String Idbuscado) throws KrakedepException {
		Categoria c = new Categoria();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from categorias where id = ?");
			
			ps.setString(1, Idbuscado);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				c.setId(rs.getString("id"));
				c.setNombre(rs.getString("nombre"));
			}
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al consultar por Id",e);
			throw  new KrakedepException("Error al consultar por Id");
		}finally {
			//cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos",e);
				throw new KrakedepException("Error con la base de datos");
			}
		}
		return c;
	}

	public static  void insertar(Producto p) throws KrakedepException {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Categoria a insertar>>>> "+p);
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into productos (id,nombre,precio_venta,precio_compra,id_categoria)"
					+ "values(?,?,?,?,?)");
			ps.setString(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setBigDecimal(3, p.getPrecio_venta());
			ps.setBigDecimal(4, p.getPrecio_compra());
			ps.setString(5, p.getId_categoria().getId());
			
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
	
}
