/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;

/**
 *
 * @author JOVANNI SG
 */
public class Escuelas {
    private String nombre;
    private String direccion;
    private String clave;
    private String tipoEscuela;

    public Escuelas(String nombre, String direccion, String clave,String tipoEscuela) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.clave = clave;
        this.tipoEscuela = tipoEscuela;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getTipoEscuela() {
        return tipoEscuela;
    }

    public void setTipoEscuela(String tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }
}
