package com.krakedev.evaluacion.entidades;

import java.math.BigDecimal;

public class Producto {
	private String id;
	private String nombre;
	private BigDecimal precio_venta;
	private BigDecimal precio_compra;
	private Categoria id_categoria;
	private boolean activo;
	
	
	public Producto() {}
	public Producto(String id, String nombre, BigDecimal precio_venta, BigDecimal precio_compra,
			Categoria id_categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio_venta = precio_venta;
		this.precio_compra = precio_compra;
		this.id_categoria = id_categoria;
		this.activo=true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}
	public BigDecimal getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(BigDecimal precio_compra) {
		this.precio_compra = precio_compra;
	}
	public Categoria getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	
}
