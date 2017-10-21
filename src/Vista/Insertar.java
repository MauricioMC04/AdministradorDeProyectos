/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorInsertar;
import Modelo.Conexion;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *

 */
public class Insertar extends javax.swing.JFrame {

    
    Controlador.ControladorInsertar CI = new ControladorInsertar();
    
    
   
    public Insertar() {
        initComponents();
               this.setLocationRelativeTo(null);
                setDefaultCloseOperation(0);

        lbl_ErrorNombreTarea.setVisible(false);
        lbl_ErrorNombreDepartamentos.setVisible(false);
        lbl_ErrorLetras.setVisible(false);
        lbl_ErrorNombreLetras.setVisible(false);
        
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        GrupoEstado = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_NombreTarea = new javax.swing.JLabel();
        txt_NombreTarea = new javax.swing.JTextField();
        btn_AceptarTareas = new javax.swing.JButton();
        pln_Observacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtA_Descripcion = new javax.swing.JTextArea();
        btn_MenuTareas = new javax.swing.JButton();
        lbl_ErrorNombreTarea = new javax.swing.JLabel();
        lbl_ErrorLetras = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_NombreDepartamento = new javax.swing.JTextField();
        btn_AceptarDepartamentos = new javax.swing.JButton();
        lbl_ErrorNombreDepartamentos = new javax.swing.JLabel();
        btn_MenuDepartamentos = new javax.swing.JButton();
        lbl_ErrorNombreLetras = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setName("Tabb_Insertar"); // NOI18N

        lbl_NombreTarea.setText("Nombre: ");

        btn_AceptarTareas.setText("Aceptar");
        btn_AceptarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarTareasActionPerformed(evt);
            }
        });

        pln_Observacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));

        txtA_Descripcion.setColumns(20);
        txtA_Descripcion.setRows(5);
        jScrollPane2.setViewportView(txtA_Descripcion);

        javax.swing.GroupLayout pln_ObservacionLayout = new javax.swing.GroupLayout(pln_Observacion);
        pln_Observacion.setLayout(pln_ObservacionLayout);
        pln_ObservacionLayout.setHorizontalGroup(
            pln_ObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_ObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        pln_ObservacionLayout.setVerticalGroup(
            pln_ObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_ObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_MenuTareas.setText("Menú");
        btn_MenuTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuTareasActionPerformed(evt);
            }
        });

        lbl_ErrorNombreTarea.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorNombreTarea.setText("Falta información");

        lbl_ErrorLetras.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorLetras.setText("Digite solamente letras");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_MenuTareas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_AceptarTareas)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pln_Observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_ErrorLetras)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_ErrorNombreTarea))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_NombreTarea)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_NombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NombreTarea)
                    .addComponent(txt_NombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ErrorLetras)
                    .addComponent(lbl_ErrorNombreTarea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(pln_Observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MenuTareas)
                    .addComponent(btn_AceptarTareas))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Tareas Asignadas", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Usuarios", jPanel2);

        jLabel1.setText("Nombre departamento:");

        btn_AceptarDepartamentos.setText("Aceptar");
        btn_AceptarDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarDepartamentosActionPerformed(evt);
            }
        });

        lbl_ErrorNombreDepartamentos.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorNombreDepartamentos.setText("Falta información");

        btn_MenuDepartamentos.setText("Menú");
        btn_MenuDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuDepartamentosActionPerformed(evt);
            }
        });

        lbl_ErrorNombreLetras.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorNombreLetras.setText("Digite solamente letras");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_ErrorNombreLetras)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addComponent(btn_MenuDepartamentos))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_NombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ErrorNombreDepartamentos)
                    .addComponent(btn_AceptarDepartamentos))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_NombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ErrorNombreLetras)
                    .addComponent(lbl_ErrorNombreDepartamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_AceptarDepartamentos)
                    .addComponent(btn_MenuDepartamentos))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Departamentos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_MenuTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuTareasActionPerformed
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MenuTareasActionPerformed

    private void btn_MenuDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuDepartamentosActionPerformed
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MenuDepartamentosActionPerformed

    private void btn_AceptarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarTareasActionPerformed
        CI.InsertarTareas(txt_NombreTarea.getText(), txtA_Descripcion.getText());
    }//GEN-LAST:event_btn_AceptarTareasActionPerformed

    private void btn_AceptarDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarDepartamentosActionPerformed
        CI.InsertarDepartamento(txt_NombreDepartamento.getText());
    }//GEN-LAST:event_btn_AceptarDepartamentosActionPerformed

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
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insertar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoEstado;
    private javax.swing.JButton btn_AceptarDepartamentos;
    private javax.swing.JButton btn_AceptarTareas;
    private javax.swing.JButton btn_MenuDepartamentos;
    private javax.swing.JButton btn_MenuTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lbl_ErrorLetras;
    private javax.swing.JLabel lbl_ErrorNombreDepartamentos;
    private javax.swing.JLabel lbl_ErrorNombreLetras;
    private javax.swing.JLabel lbl_ErrorNombreTarea;
    private javax.swing.JLabel lbl_NombreTarea;
    private javax.swing.JPanel pln_Observacion;
    private javax.swing.JTextArea txtA_Descripcion;
    private javax.swing.JTextField txt_NombreDepartamento;
    private javax.swing.JTextField txt_NombreTarea;
    // End of variables declaration//GEN-END:variables
}
