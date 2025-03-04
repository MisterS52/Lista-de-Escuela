/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.mycompany.escuela.EscuelaDAO;
import com.mycompany.escuela.GrupoDAO;
import com.mycompany.escuela.AlumnoDAO;
import com.mycompany.escuela.ActividadDAO;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author JOVANNI SG
 */
public class Clalificar extends javax.swing.JFrame {

    /**
     * Creates new form Clalificar
     */
    Clase pantallaPrincipale; // Referencia a la Pantalla principal
    private int idGrupo; // ID del grupo seleccionado
    public Clalificar(int idGrupo) {
       this.idGrupo = idGrupo;
        initComponents();
        setTitle("Asistencia");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cargarDatos();
    }

     private void cargarDatos() {
        try {
            // Llenar lista de actividades
            ActividadDAO actividadDAO = new ActividadDAO();
            List<String> actividades = actividadDAO.obtenerActividadesPorGrupo(idGrupo);
            DefaultListModel<String> modeloActividades = new DefaultListModel<>();
            for (String actividad : actividades) {
                modeloActividades.addElement(actividad);
            }
            ListadeActividades.setModel(modeloActividades);

            // Llenar lista de alumnos
            AlumnoDAO alumnoDAO = new AlumnoDAO();
            List<String> alumnos = alumnoDAO.obtenerDetallesAlumnosPorGrupo(idGrupo);
            DefaultListModel<String> modeloAlumnos = new DefaultListModel<>();
            for (String alumno : alumnos) {
                modeloAlumnos.addElement(alumno);
            }
            ListadeAlumnos.setModel(modeloAlumnos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListadeAlumnos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadeActividades = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        Calificasion = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        Calificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Calificar Actividad");

        ListadeAlumnos.setBackground(new java.awt.Color(204, 204, 204));
        ListadeAlumnos.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        ListadeAlumnos.setForeground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(ListadeAlumnos);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre de actividad:");

        ListadeActividades.setBackground(new java.awt.Color(204, 204, 204));
        ListadeActividades.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jScrollPane3.setViewportView(ListadeActividades);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumno:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Calificasion:");

        Calificar.setBackground(new java.awt.Color(153, 153, 153));
        Calificar.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        Calificar.setForeground(new java.awt.Color(255, 255, 255));
        Calificar.setText("Calificar");
        Calificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(317, 317, 317)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Calificasion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Calificar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Calificar)
                            .addComponent(Calificasion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(17, 17, 17))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalificarActionPerformed
        // TODO add your handling code here:
        try {
        // Obtener actividad seleccionada
        String actividadSeleccionada = ListadeActividades.getSelectedValue();
        if (actividadSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una actividad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener alumno seleccionado
        String alumnoSeleccionado = ListadeAlumnos.getSelectedValue();
        if (alumnoSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extraer el ID de la actividad (formato: ID:1,Actividad:Actividad 1)
        int idActividad = Integer.parseInt(actividadSeleccionada.split(",")[0].split(":")[1].trim());

        // Extraer el ID del alumno (formato: ID: 8| Nombre: Manuel Peres Torres)
        int idAlumno = Integer.parseInt(alumnoSeleccionado.split("\\|")[0].split(":")[1].trim());

        // Obtener calificación del spinner
        int calificacion = (Integer) Calificasion.getValue();

        // Llamar a agregarEvaluacion
        ActividadDAO actividadDAO = new ActividadDAO();
        actividadDAO.agregarEvaluacion(idActividad, idAlumno, calificacion);

        JOptionPane.showMessageDialog(this, "Calificación agregada correctamente.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error al procesar datos seleccionados.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la calificación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_CalificarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Calificar;
    private javax.swing.JSpinner Calificasion;
    private javax.swing.JList<String> ListadeActividades;
    private javax.swing.JList<String> ListadeAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
