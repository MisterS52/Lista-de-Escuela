/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO  {

    private FechaDAO fechaDAO; // Dependencia a FechaDAO
    private String fecha;
    private int idAlumno;
    private int asistencia;

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Alumno ID: " + idAlumno + ", Asistencia: " + (asistencia == 1 ? "Presente" : "Ausente");
    }

    public AsistenciaDAO() throws SQLException{
        this.fechaDAO = new FechaDAO(); // Inicializamos FechaDAO
        connection = DatabaseConnection.getConnection(); // Asegúrate de tener tu método de conexión.
    }

    /**
     * Registra la asistencia de un alumno para un grupo específico.
     *
     * @param idGrupo   El ID del grupo al que pertenece el alumno.
     * @param idAlumno  El ID del alumno cuya asistencia se registrará.
     * @param asistencia El valor de asistencia (1 = presente, 0 = ausente).
     * @return true si se registra correctamente, false en caso contrario.
     * @throws SQLException Si ocurre un error con la base de datos.
     */
    public boolean registrarAsistencia(int idGrupo, int idAlumno, int asistencia) throws SQLException {
        String sql = "INSERT INTO Asistencia (idFecha, idAlumno, asistencia) VALUES (?, ?, ?)";

        // Obtener el idFecha automáticamente usando FechaDAO
        int idFecha = fechaDAO.obtenerIdFechaActual(idGrupo);
        if (idFecha == -1) {
            throw new SQLException("No se pudo obtener o crear la fecha para el grupo: " + idGrupo);
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFecha); // Establecemos idFecha
            stmt.setInt(2, idAlumno); // Establecemos idAlumno
            stmt.setInt(3, asistencia); // Establecemos asistencia

            // Ejecutamos la consulta
            return stmt.executeUpdate() > 0;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    private Connection connection;

   

    // Nueva función para obtener fechas, ID de alumnos y asistencia por grupo
   public List<AsistenciaInfo> obtenerAsistenciasPorGrupo(int idGrupo) throws SQLException {
    List<AsistenciaInfo> asistencias = new ArrayList<>();

    String sql = """
        SELECT 
            fechas_asistencia.fecha, 
            asistencia.idalumno, 
            asistencia.asistencia
        FROM 
            asistencia
        JOIN 
            fechas_asistencia 
        ON 
            asistencia.idfecha = fechas_asistencia.idfecha
        WHERE 
            fechas_asistencia.id_grupo = ?;
    """;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idGrupo);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                AsistenciaInfo info = new AsistenciaInfo();
                info.setFecha(rs.getString("fecha")); // Ajusta el tipo si es Date
                info.setIdAlumno(rs.getInt("idalumno"));
                info.setAsistencia(rs.getInt("asistencia"));
                asistencias.add(info);
            }
        }
    }

    return asistencias;
}


    // Clase auxiliar para almacenar la información
   public class AsistenciaInfo {
    private String fecha;
    private int idAlumno;
    private int asistencia;

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Alumno ID: " + idAlumno + ", Asistencia: " + (asistencia == 1 ? "Presente" : "Ausente");
    }
}

}
