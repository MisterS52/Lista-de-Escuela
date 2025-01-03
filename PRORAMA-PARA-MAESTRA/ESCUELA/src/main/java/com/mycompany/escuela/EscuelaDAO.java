/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.escuela.Escuelas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author JOVANNI SG
 */
public class EscuelaDAO {
     public void agregarEscuela(Escuelas escuela) throws SQLException {
        String sql = "INSERT INTO Escuela (nombre, direccion, clave) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, escuela.getNombre());
            stmt.setString(2, escuela.getDireccion());
            stmt.setString(3, escuela.getClave());
            stmt.executeUpdate();
            System.out.println("Escuela guardada exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al guardar la escuela: " + e.getMessage());
            throw e;
        }
    }
    // Método para eliminar una escuela
    public void eliminarEscuela(String nombreEscuela) throws SQLException {
        String sql = "DELETE FROM Escuela WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreEscuela);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                // Si no se eliminó ninguna fila (escuela no encontrada), lanzar excepción
                throw new SQLException("No se encontró una escuela con ese nombre.");
            }
        }
    }
     public List<String> obtenerNombresEscuelas() throws SQLException {
        List<String> nombresEscuelas = new ArrayList<>();
        String sql = "SELECT nombre FROM Escuela";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                nombresEscuelas.add(rs.getString("nombre"));
            }
        }
        
        return nombresEscuelas;
    }
    
}
