package com.example.agil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.agil.exception.AgilException;

public abstract class BaseDao {
	private static final String URL = "jdbc:derby://localhost/agildb";
	private static final String USUARIO = "user";
	private static final String CLAVE = "123";
	
	protected Connection con;
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public BaseDao() {
		try {
			con = DriverManager.getConnection(URL, USUARIO, CLAVE);
		} catch (SQLException e) {
			throw new AgilException(e);
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		if (con != null)
			con.close();
	}
}
