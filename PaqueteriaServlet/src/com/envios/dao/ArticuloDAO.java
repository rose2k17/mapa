package com.envios.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.envios.model.Articulo;
import com.envios.model.Conexion;

/*
 * @autor: Elivar Largo
 * @web: www.ecodeup.com
 */

public class ArticuloDAO {
	private Conexion con;
	private Connection connection;
	
	// Takes date from java.util.date and converts it to java.sql.date
	private java.sql.Date mySqlDate;

	public ArticuloDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar art�culo
	@SuppressWarnings("null")
	public boolean insertar(Articulo articulo) throws SQLException {
		String sql = "INSERT INTO articulos VALUES (NULL, ?, ?,?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		mySqlDate = new java.sql.Date(articulo.getFecha().getTime());
		statement.setString(1, articulo.getOrigen());
		statement.setString(2, articulo.getDestino());
		statement.setString(3, articulo.getPaquete());
		statement.setDate(4, mySqlDate);
		statement.setString(5, articulo.getRemitente());
		statement.setString(6, articulo.getTransportista());
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		System.out.println("prueba4");
		return rowInserted;
	}

	// listar todos los productos
	public List<Articulo> listarArticulos() throws SQLException {

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String origen = resulSet.getString("origen");
			String destino = resulSet.getString("destino");
			String paquete = resulSet.getString("paquete");
			Date fecha = resulSet.getDate("fecha");
			String remitente = resulSet.getString("remitente");
			String transportista = resulSet.getString("transportista");
			Articulo articulo = new Articulo(id, origen, destino, paquete, fecha, remitente, transportista);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	// listar todos los productos
	public List<Articulo> listarArticulosOD(String or,String dest) throws SQLException {
		System.out.println(dest);
		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		String sql = "SELECT * FROM articulos WHERE origen='"+or+"' or destino = '"+dest+"'";
		System.out.println(sql);
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resulSet = statement.executeQuery();
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String origen = resulSet.getString("origen");
			String destino = resulSet.getString("destino");
			String paquete = resulSet.getString("paquete");
			Date fecha = resulSet.getDate("fecha");
			String remitente = resulSet.getString("remitente");
			String transportista = resulSet.getString("transportista");
			Articulo articulo = new Articulo(id, origen, destino, paquete, fecha, remitente, transportista);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}

	// obtener por id
	public Articulo obtenerPorId(int id) throws SQLException {
		Articulo articulo = null;

		String sql = "SELECT * FROM articulos WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			articulo = new Articulo(res.getInt("id"), res.getString("origen"), res.getString("destino"),
					res.getString("paquete"), res.getDate("fecha"),res.getString("remitente"),
					res.getString("transportista"));
		}
		res.close();
		con.desconectar();

		return articulo;
	}

	// actualizar
	public boolean actualizar(Articulo articulo) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE articulos SET codigo=?,nombre=?,descripcion=?,existencia=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, articulo.getOrigen());
		statement.setString(2, articulo.getDestino());
		statement.setString(3, articulo.getPaquete());
		statement.setInt(6, articulo.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	//eliminar
	public boolean eliminar(Articulo articulo) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM articulos WHERE ID=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, articulo.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}