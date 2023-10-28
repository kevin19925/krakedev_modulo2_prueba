package com.krakedev.evaluacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakedepException;

public class ConexionBDD {
	private final static String DRIVER = "org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/prueba";
	private final static String USUARIO = "postgres";
	private final static String CLAVE = "postgres";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);

	public static Connection conectar() throws KrakedepException {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			LOGGER.debug("Opteniendo Conexion");
			connection = DriverManager.getConnection(URL,USUARIO,CLAVE);
			LOGGER.debug("Conexion exitosa");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error en la infraestructura",e);
			throw new KrakedepException("Error en la infraestructura");
		}catch (SQLException e) {
			LOGGER.error("Error al conectarse, revise usuario y clave",e);
			throw new KrakedepException("Error al conectarse, revise usuario y clave");
		}
		return connection;
	}
}
