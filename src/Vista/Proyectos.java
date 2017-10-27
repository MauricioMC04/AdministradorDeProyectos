/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorInsertar;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Proyectos extends javax.swing.JFrame {

    public Proyectos() {
        Estado = "En Proceso";
        initComponents();
       
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(0);

    }

    Conexion conec = new Conexion();
    Connection c = conec.conexion();


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EstadoProyecto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnl_Proyecto = new javax.swing.JPanel();
        lbl_DepartamentoProyecto = new javax.swing.JLabel();
        cmb_DepartamentoProyecto = new javax.swing.JComboBox<>();
        lbl_FechaEntrega = new javax.swing.JLabel();
        lbl_NombreProyecto = new javax.swing.JLabel();
        txt_NombreProyecto = new javax.swing.JTextField();
        lbl_UsuarioProyecto = new javax.swing.JLabel();
        cmb_UsuarioProyecto = new javax.swing.JComboBox<>();
        lbl_PTareas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sp_Iteraciones = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btn_AgregarTareas = new javax.swing.JButton();
        cmb_TareasProyecto = new javax.swing.JComboBox<>();
        btn_MenuProyecto = new javax.swing.JButton();
        btn_CrearProyecto = new javax.swing.JButton();
        lbl_ErrorFaltaInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_Proyecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));
        pnl_Proyecto.setName(""); // NOI18N

        lbl_DepartamentoProyecto.setText("Departamento:");

        lbl_FechaEntrega.setText("Fecha entrega:");

        lbl_NombreProyecto.setText("Nombre Proyecto:");

        txt_NombreProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreProyectoActionPerformed(evt);
            }
        });

        lbl_UsuarioProyecto.setText("Creado por:");

        cmb_UsuarioProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_UsuarioProyectoActionPerformed(evt);
            }
        });

        lbl_PTareas.setText("Tareas:");

        jLabel1.setText("Fecha final:");

        jLabel2.setText("Iteraciones:");

        btn_AgregarTareas.setText("Agregar ");
        btn_AgregarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarTareasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_ProyectoLayout = new javax.swing.GroupLayout(pnl_Proyecto);
        pnl_Proyecto.setLayout(pnl_ProyectoLayout);
        pnl_ProyectoLayout.setHorizontalGroup(
            pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_ProyectoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbl_PTareas)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_TareasProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                                .addComponent(lbl_NombreProyecto)
                                .addGap(18, 18, 18)
                                .addComponent(txt_NombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(lbl_UsuarioProyecto))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_UsuarioProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sp_Iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createSequentialGroup()
                        .addComponent(lbl_DepartamentoProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_DepartamentoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createSequentialGroup()
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_FechaEntrega)
                            .addComponent(jLabel1)
                            .addComponent(btn_AgregarTareas))
                        .addGap(117, 117, 117)))
                .addGap(0, 76, Short.MAX_VALUE))
        );
        pnl_ProyectoLayout.setVerticalGroup(
            pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NombreProyecto)
                    .addComponent(txt_NombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_DepartamentoProyecto)
                    .addComponent(cmb_DepartamentoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_FechaEntrega)
                    .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_UsuarioProyecto)
                                    .addComponent(cmb_UsuarioProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(sp_Iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PTareas)
                    .addComponent(cmb_TareasProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_AgregarTareas))
                .addGap(141, 141, 141))
        );

        btn_MenuProyecto.setText("Menú");
        btn_MenuProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuProyectoActionPerformed(evt);
            }
        });

        btn_CrearProyecto.setText("Crear Proyecto");
        btn_CrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearProyectoActionPerformed(evt);
            }
        });

        lbl_ErrorFaltaInfo.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorFaltaInfo.setText("Falta información");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_MenuProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_ErrorFaltaInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_CrearProyecto))
                    .addComponent(pnl_Proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnl_Proyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MenuProyecto)
                    .addComponent(btn_CrearProyecto)
                    .addComponent(lbl_ErrorFaltaInfo))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MenuProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuProyectoActionPerformed

    }//GEN-LAST:event_btn_MenuProyectoActionPerformed

    private void btn_AgregarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarTareasActionPerformed
        Tareas Tr = new Tareas();
        Tr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_AgregarTareasActionPerformed

    private void btn_CrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearProyectoActionPerformed
//        String nombre = txt_NombreProyecto.getText();
//        int Adm = 207710091;
//        String Fechainicio = String.valueOf(jdc_FechaEntrega.getDate());
//        String FechaFinal =String.valueOf(jdc_FechaFinal.getDate());
//        int iteracion = 2;
//        String Estado = "En Proceso";
//        String Departamento = String.valueOf(cmb_DepartamentoProyecto.getSelectedItem());
//        CP.InsertarProyecto(nombre, Fechainicio, Departamento, Estado,iteracion , FechaFinal, Adm);
    }//GEN-LAST:event_btn_CrearProyectoActionPerformed

    private void cmb_UsuarioProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_UsuarioProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_UsuarioProyectoActionPerformed

    private void txt_NombreProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreProyectoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup EstadoProyecto;
    private javax.swing.JButton btn_AgregarTareas;
    private javax.swing.JButton btn_CrearProyecto;
    private javax.swing.JButton btn_MenuProyecto;
    public static javax.swing.JComboBox<String> cmb_DepartamentoProyecto;
    public static javax.swing.JComboBox<String> cmb_TareasProyecto;
    public static javax.swing.JComboBox<String> cmb_UsuarioProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_DepartamentoProyecto;
    private javax.swing.JLabel lbl_ErrorFaltaInfo;
    private javax.swing.JLabel lbl_FechaEntrega;
    private javax.swing.JLabel lbl_NombreProyecto;
    private javax.swing.JLabel lbl_PTareas;
    private javax.swing.JLabel lbl_UsuarioProyecto;
    private javax.swing.JPanel pnl_Proyecto;
    private javax.swing.JSpinner sp_Iteraciones;
    private javax.swing.JTextField txt_NombreProyecto;
    // End of variables declaration//GEN-END:variables
 private String Estado;
}
