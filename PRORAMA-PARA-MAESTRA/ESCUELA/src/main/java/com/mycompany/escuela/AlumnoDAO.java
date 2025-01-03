/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.escuela.Alumno;

/**
 *
 * @author JOVANNI SG
 */
public class AlumnoDAO {
    public void agregarAlumno(Alumno alumno) throws SQLException {
    String sql = "INSERT INTO Alumno (nombre, apellido_paterno, apellido_materno, id_grupo) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement statement = conn.prepareStatement(sql)) {
        // Asignación de valores al PreparedStatement
        statement.setString(1, alumno.getNombre());
        statement.setString(2, alumno.getApellidoPaterno());
        statement.setString(3, alumno.getApellidoMaterno());
        statement.setInt(4, alumno.getIdGrupo());
        
        // Ejecución de la consulta
        statement.executeUpdate();
    } catch (SQLException e) {
        // Aquí puedes manejar el error de SQL o lanzarlo según lo necesites
        throw new SQLException("Error al agregar alumno: " + e.getMessage());
    }
}

    public List<String> obtenerDetallesAlumnosPorGrupo(int idGrupo) throws SQLException {
    List<String> detallesAlumnos = new ArrayList<>();
    String sql = "SELECT idalumno,nombre, apellido_paterno, apellido_materno FROM Alumno WHERE id_grupo = ?";  // Consulta con id_grupo

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idGrupo);  // Establecer el id del grupo
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Crear el detalle del alumno en formato "Nombre: Juan Pérez"
            String detalle = "ID: " + rs.getInt("idalumno") + 
                             "| "+"Nombre: " + rs.getString("nombre") + " " + 
                             rs.getString("apellido_paterno") + " " + 
                             rs.getString("apellido_materno");
            detallesAlumnos.add(detalle);
        }
    }
    return detallesAlumnos;
}
public boolean eliminarAlumnoPorId(int idAlumno) throws SQLException {
    String sql = "DELETE FROM Alumno WHERE idalumno = ?";  // Consulta SQL para eliminar un alumno

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idAlumno);  // Establecer el id del alumno

        int rowsAffected = stmt.executeUpdate();  // Ejecutar la consulta
        return rowsAffected > 0;  // Si afecta al menos una fila, significa que la eliminación fue exitosa
    }
}

    
}
