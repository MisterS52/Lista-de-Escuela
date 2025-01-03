/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;

/**
 *
 * @author JOVANNI SG
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.escuela.Escuelas;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {
    public void guardarGrupo(Grupo grupo) throws SQLException {
       String sql = "INSERT INTO Grupo (grado, grupo, turno, escuela_nombre) VALUES (?, ?, ?, ?)";
try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, grupo.getGrado());
    stmt.setString(2, grupo.getGrupo());
    stmt.setString(3, grupo.getTurno());
    stmt.setString(4, grupo.getEscuela_nombre());  // Cambié "escuelaNombre" a "escuela_nombre"
    stmt.executeUpdate();
    System.out.println("Grupo guardado exitosamente");
} catch (SQLException e) {
    System.err.println("Error al guardar el grupo: " + e.getMessage());
    throw e;
}

    }
    public List<String> obtenerDetallesGruposPorEscuela(String escuelaNombre) throws SQLException {
     List<String> detallesGrupos = new ArrayList<>();
    String sql = "SELECT idGrupo, grado, grupo, turno FROM Grupo WHERE escuela_nombre = ?";  // Incluir idGrupo

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, escuelaNombre);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Crear el detalle incluyendo el IdGrupo
            String detalle = "ID: " + rs.getInt("idGrupo") + 
                             "| Grupo: " + rs.getString("grado") +
                             "-" + rs.getString("grupo") +
                             "  Turno: " + rs.getString("turno");
            detallesGrupos.add(detalle);
        }
    }
    return detallesGrupos;
}
    // Método para eliminar un grupo
    public void eliminarGrupo(int idGrupo) throws SQLException {
    String sql = "DELETE FROM Grupo WHERE idgrupo = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idGrupo);
        int rowsAffected = stmt.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("Grupo eliminado exitosamente");
        } else {
            System.out.println("No se encontró un grupo con el ID proporcionado.");
        }
    } catch (SQLException e) {
        System.err.println("Error al eliminar el grupo: " + e.getMessage());
        throw e;
    }
}
    public boolean existeGrupo(int idGrupo) throws SQLException {
    String sql = "SELECT COUNT(*) FROM Grupo WHERE idgrupo = ?";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idGrupo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) > 0;  // Si el conteo es mayor que 0, significa que el grupo existe
        }
    }
    return false;  // Si no se encuentra el grupo
}

    
    
}
