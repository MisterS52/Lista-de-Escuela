/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class FechaDAO {

    // Método para agregar una nueva fecha de asistencia
    public boolean agregarFecha(int idGrupo) throws SQLException {
        String sql = "INSERT INTO Fechas_asistencia (fecha, id_grupo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Obtener la fecha actual del sistema
            Date fechaActual = new Date(System.currentTimeMillis());

            // Asignar los parámetros a la consulta
            stmt.setDate(1, fechaActual);
            stmt.setInt(2, idGrupo);

            // Ejecutar la consulta
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se insertó correctamente
        }
    }
     // Método para obtener el ID de la fecha actual
    public int obtenerIdFechaActual(int idGrupo) throws SQLException {
        String fechaHoy = java.time.LocalDate.now().toString(); // Obtener la fecha actual como String
        int idFecha = -1;

        String consultaFecha = "SELECT idFecha FROM Fechas_asistencia WHERE fecha = ? AND id_grupo = ?";
        String insertarFecha = "INSERT INTO Fechas_asistencia (fecha, id_grupo) VALUES (?, ?) RETURNING idFecha";

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Primero verifica si la fecha ya existe
            try (PreparedStatement stmt = conn.prepareStatement(consultaFecha)) {
                stmt.setDate(1, Date.valueOf(fechaHoy));
                stmt.setInt(2, idGrupo);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    idFecha = rs.getInt("idFecha"); // La fecha ya existe, devolver el idFecha
                }
            }

            // Si la fecha no existe, insértala
            if (idFecha == -1) {
                try (PreparedStatement stmt = conn.prepareStatement(insertarFecha)) {
                    stmt.setDate(1, Date.valueOf(fechaHoy));
                    stmt.setInt(2, idGrupo);

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        idFecha = rs.getInt("idFecha"); // Obtener el idFecha recién insertado
                    }
                }
            }
        }

        return idFecha; // Devolver el ID de la fecha actual
    }
}

