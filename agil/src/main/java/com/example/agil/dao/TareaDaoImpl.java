package com.example.agil.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.agil.exception.AgilException;
import com.example.agil.model.Iteracion;
import com.example.agil.model.Tarea;

public class TareaDaoImpl extends BaseDao implements TareaDao {

	public Tarea agregar(Tarea t) {
		String sql = "INSERT INTO tarea(nombre, descripcion, "
				+ "prioridad, esfuerzo, release, "
				+ "fecha, valor, estado, iteracion_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, t.getNombre());
			pstmt.setString(2, t.getDescripcion());
			pstmt.setInt(3, t.getPrioridad());
			pstmt.setInt(4, t.getEsfuerzo());
			pstmt.setString(5, t.getRelease());
			pstmt.setDate(6, new java.sql.Date(t.getFecha().getTime()));
			pstmt.setInt(7, t.getValor());
			pstmt.setString(8, t.getEstado().name());
			pstmt.setInt(9, t.getIteracion().getId());

			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next())
				t.setId(rs.getInt(1));
		} catch (SQLException e) {
			throw new AgilException(e);
		}
		
		return t;
	}

	public void modificar(Tarea t) {
		String sql = "UPDATE tarea SET nombre = ?, descripcion = ?, "
				+ "prioridad = ?, esfuerzo = ?, release = ?, "
				+ "fecha = ?, valor = ?, estado = ?, iteracion_id = ? "
				+ "WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getNombre());
			pstmt.setString(2, t.getDescripcion());
			pstmt.setInt(3, t.getPrioridad());
			pstmt.setInt(4, t.getEsfuerzo());
			pstmt.setString(5, t.getRelease());
			pstmt.setDate(6, new java.sql.Date(t.getFecha().getTime()));
			pstmt.setInt(7, t.getValor());
			pstmt.setString(8, t.getEstado().name());
			pstmt.setInt(9, t.getIteracion().getId());
			pstmt.setInt(10, t.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new AgilException(e);
		}
	}
	
	public void modificarEsfuerzo(Tarea t) {
		String sql = "UPDATE tarea SET esfuerzo = ? "
				+ "WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getEsfuerzo());
			pstmt.setInt(2, t.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new AgilException(e);
		}
	}

	public void eliminar(Integer id) {
		String sql = "DELETE FROM tarea WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new AgilException(e);
		}
	}

	public Tarea obtener(Integer id) {
		String sql = "SELECT * FROM tarea WHERE id = ?";
		Tarea t = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setNombre(rs.getString("nombre"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setPrioridad(rs.getInt("prioridad"));
				t.setEsfuerzo(rs.getInt("esfuerzo"));
				t.setRelease(rs.getString("release"));
				t.setValor(rs.getInt("valor"));
				t.setEstado(Tarea.Estado.valueOf(rs.getString("estado")));
				t.setFecha(rs.getDate("fecha"));
				Iteracion i = new Iteracion();
				i.setId(rs.getInt("iteracion_id"));
				t.setIteracion(i);
			}
		} catch (SQLException e) {
			throw new AgilException(e);
		}
		
		return t;
	}

	public List<Tarea> obtenerTodos() {
		String sql = "SELECT * FROM tarea";
		List<Tarea> tareas = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (tareas == null) 
					tareas = new ArrayList<Tarea>();
				
				Tarea t = new Tarea();
				t.setId(rs.getInt("id"));
				t.setNombre(rs.getString("nombre"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setPrioridad(rs.getInt("prioridad"));
				t.setEsfuerzo(rs.getInt("esfuerzo"));
				t.setRelease(rs.getString("release"));
				t.setValor(rs.getInt("valor"));
				t.setEstado(Tarea.Estado.valueOf(rs.getString("estado")));
				t.setFecha(rs.getDate("fecha"));
				Iteracion i = new Iteracion();
				i.setId(rs.getInt("iteracion_id"));
				t.setIteracion(i);
				
				tareas.add(t);
			}
		} catch (SQLException e) {
			throw new AgilException(e);
		}
		
		return tareas;
	}

}
