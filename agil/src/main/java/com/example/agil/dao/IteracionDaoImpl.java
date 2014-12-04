package com.example.agil.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.agil.exception.AgilException;
import com.example.agil.model.Iteracion;

public class IteracionDaoImpl extends BaseDao implements IteracionDao {

	public void agregar(Iteracion i) {
		String sql = "INSERT INTO iteracion(nombre, descripcion, "
				+ "fecha_inicio, fecha_fin) VALUES(?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, i.getNombre());
			pstmt.setString(2, i.getDescripcion());
			pstmt.setDate(3, new java.sql.Date(i.getFechaInicio().getTime()));
			pstmt.setDate(4, new java.sql.Date(i.getFechaFin().getTime()));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new AgilException(e);
		}
	}

	public void modificar(Iteracion i) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Iteracion obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Iteracion> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
