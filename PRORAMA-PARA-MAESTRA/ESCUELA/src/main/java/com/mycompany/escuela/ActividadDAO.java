/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class ActividadDAO {

    /**
     * Método para agregar una nueva actividad.
     * @param idGrupo El ID del grupo al que pertenece la actividad.
     * @param nombreActividad El nombre de la actividad.
     * @throws SQLException En caso de errores con la base de datos.
     */
    public void agregarActividad(int idGrupo, String nombreActividad) throws SQLException {
        String sql = """
            INSERT INTO Actividad (fecha, id_grupo, NombreActividad)
            VALUES (?, ?, ?);
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Obtiene la fecha actual del sistema
            LocalDate fechaActual = LocalDate.now();

            // Configura los parámetros de la consulta
            stmt.setDate(1, Date.valueOf(fechaActual)); // Convierte LocalDate a Date para SQL
            stmt.setInt(2, idGrupo);
            stmt.setString(3, nombreActividad);

            // Ejecuta la consulta
            stmt.executeUpdate();
        }
    }
     /**
     * Método para obtener todas las actividades de un grupo.
     * @param idGrupo El ID del grupo.
     * @return Una lista de actividades que contiene ID y Nombre de cada actividad.
     * @throws SQLException En caso de errores con la base de datos.
     */
    public List<String> obtenerActividadesPorGrupo(int idGrupo) throws SQLException {
        String sql = """
            SELECT idActividad, NombreActividad
            FROM Actividad
            WHERE id_grupo = ?;
        """;

        List<String> actividades = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura el parámetro de la consulta
            stmt.setInt(1, idGrupo);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idActividad = rs.getInt("idActividad");
                    String nombreActividad = rs.getString("NombreActividad");
                    // Formateamos la actividad como una cadena
                    actividades.add("ID: " + idActividad + ", Actividad: " + nombreActividad);
                }
            }
        }

        return actividades;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
     /**
     * Método para agregar una evaluación.
     * @param idActividad El ID de la actividad a la que pertenece la evaluación.
     * @param idAlumno El ID del alumno que recibe la evaluación.
     * @param calificacion La calificación que se asignará.
     * @throws SQLException En caso de errores con la base de datos.
     */
    public void agregarEvaluacion(int idActividad, int idAlumno, int calificacion) throws SQLException {
        String insertarEvaluacionSQL = """
            INSERT INTO Evaluacion (idAlumno, idActividad, calificacion)
            VALUES (?, ?, ?);
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertarEvaluacionSQL)) {

            // Configura los parámetros de la consulta
            stmt.setInt(1, idAlumno);
            stmt.setInt(2, idActividad);
            stmt.setInt(3, calificacion);

            // Ejecuta la consulta
            stmt.executeUpdate();
        }
    }
   /**
 * Método para obtener las evaluaciones de un grupo con nombre de la actividad, nombre del alumno y calificación.
 * @param idGrupo El ID del grupo.
 * @return Lista con las evaluaciones.
 * @throws SQLException 
 */
public List<String> obtenerEvaluacionesPorGrupo(int idGrupo) throws SQLException {
    String sql = """
        SELECT a.NombreActividad, al.Nombre, e.calificacion
        FROM Evaluacion e
        JOIN Actividad a ON e.idActividad = a.idActividad
        JOIN Alumno al ON e.idAlumno = al.idAlumno
        WHERE a.id_grupo = ?;
    """;

    List<String> evaluaciones = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idGrupo);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String actividad = rs.getString("NombreActividad");
                String alumno = rs.getString("Nombre");
                int calificacion = rs.getInt("calificacion");
                evaluaciones.add("Actividad: " + actividad + " | Alumno: " + alumno + " | Calificación: " + calificacion);
            }
        }
    }
    return evaluaciones;
}
}
