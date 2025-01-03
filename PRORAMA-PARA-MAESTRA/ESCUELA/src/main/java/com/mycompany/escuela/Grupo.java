/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escuela;

/**
 *
 * @author JOVANNI SG
 */
public class Grupo {
    private int idGrupo;
    private String grado;
    private String grupo;
    private String turno;
    private String escuela_nombre;

    public Grupo(int idGrupo, String grado, String grupo, String turno, String escuelaNombre) {
        this.idGrupo = idGrupo;
        this.grado = grado;
        this.grupo = grupo;
        this.turno = turno;
        this.escuela_nombre = escuelaNombre;
    }
    // Getters y Setters
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEscuela_nombre() {
        return escuela_nombre;
    }

    public void setEscuela_nombre(String escuelaNombre) {
        this.escuela_nombre = escuelaNombre;
    }
    
    public String toString() {
        return "ID: " + idGrupo + " | Grado: " + grado + "-" + grupo + " | Turno: " + turno;
    }
}
