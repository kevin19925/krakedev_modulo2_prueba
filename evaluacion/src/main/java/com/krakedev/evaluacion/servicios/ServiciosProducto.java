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

	

	
	public static  void insertar(Producto p) throws KrakedepException {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("producto a insertar>>>> "+p);
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into productos (id,nombre,precio_venta,precio_compra,id_categoria,activo)"
					+ "values(?,?,?,?,?,?)");
			ps.setString(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setBigDecimal(3, p.getPrecio_venta());
			ps.setBigDecimal(4, p.getPrecio_compra());
			ps.setString(5, p.getId_categoria().getId());
			ps.setBoolean(6, p.isActivo());
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
	
	public static  void actualizar(Producto producto) throws KrakedepException {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("productoa actualizar>>>> "+producto);
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("UPDATE productos"
					+ "	SET nombre=?, precio_venta=?, precio_compra=?, id_categoria=?"
					+ "	WHERE id=?");

			ps.setString(1, producto.getNombre());
			ps.setBigDecimal(2, producto.getPrecio_venta());
			ps.setBigDecimal(3, producto.getPrecio_compra());
			ps.setString(4,producto.getId_categoria().getId());
			ps.setString(5,producto.getId());
			
			
			ps.executeUpdate();
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al actualizar",e);
			throw  new KrakedepException("Error al actualizar");
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
	

	public static  void Eliminar(String id) throws KrakedepException {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("producto  a eliminar >>>> "+id);
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("UPDATE productos "
					+ "SET activo=?	WHERE id=?");

			ps.setBoolean(1, false);
			ps.setString(2, id);
			
			
			ps.executeUpdate();
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al eliminar",e);
			throw  new KrakedepException("Error al eliominar");
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
	

	public static ArrayList<Producto> recuperarTodos() throws KrakedepException {
		ArrayList<Producto> productos = new ArrayList<Producto>() ;
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			//abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from productos where activo=true");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Producto c = new Producto();
				c.setId(rs.getString("id"));
				c.setNombre(rs.getString("nombre"));
				//c.setPrecio_venta(rs.getBigDecimal("precio_venta"));
				//c.setPrecio_compra(rs.getBigDecimal("precio_compra"));
				Categoria cat= new Categoria(rs.getString("id_categoria"), "");
				c.setId_categoria(cat);
				c.setActivo(true);
				productos.add(c);
			}
		}catch( KrakedepException e){
			throw  e;
		}catch( Exception e){
			LOGGER.error("Error al recuperar Productos",e);
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
		return productos;
		
	}
}
