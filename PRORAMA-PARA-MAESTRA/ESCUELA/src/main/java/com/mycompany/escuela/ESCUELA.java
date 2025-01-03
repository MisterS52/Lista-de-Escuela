/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.escuela;
import Interfas.PantallaDeIncio;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author JOVANNI SG
 */
public class ESCUELA {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException  {
  String url = "jdbc:postgresql://localhost:5432/Escuela";
    String usuario = "postgres";
    String contrasena = "36379025";

    try (Connection connection = DriverManager.getConnection(url, usuario, contrasena)) {
        System.out.println("Conexión exitosa a la base de datos");
        // Inicializar la pantalla de inicio
        PantallaDeIncio panta = new PantallaDeIncio();
        panta.setVisible(true);
        panta.setLocationRelativeTo(null);
    } catch (SQLException e) {
        System.err.println("Error al conectar a la base de datos: " + e.getMessage());
    }

    }
}
