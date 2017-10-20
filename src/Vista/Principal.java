/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.InsertarControlador;
import Controlador.PrincipalControlador;
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






public class Principal extends javax.swing.JFrame {


    
    public Principal() {
        
        initComponents();
        cargarcbxUsuario();
                
                
    }

Conexion conec = new Conexion();
  Connection c = conec.conexion();
  
        
    
    Controlador.PrincipalControlador CP = new PrincipalControlador();
    
    public void cargarcbxUsuario() {
        
        String sql = "SELECT * FROM Usuario";
        String sql1 = "SELECT * FROM Tareas";
        String sql2 = "SELECT * FROM Proyecto";
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
         Statement st;
            
        String datos = "";
        String datos2= "";
        String datos3= "";
        try {
            Statement ejecutor = c.createStatement();
            ResultSet rs = ejecutor.executeQuery(sql);
//            ResultSet rs1 = ejecutor.executeQuery(sql1);
//            ResultSet rs2 = ejecutor.executeQuery(sql1);
            
            while (rs.next()) {
            
               datos= rs.getString("Nombre");    
 
                cmb_UsuarioProyecto.addItem(datos);
            }
               
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error");
        }



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        EstadoProyecto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnl_Proyecto = new javax.swing.JPanel();
        jdc_FechaEntrega = new com.toedter.calendar.JDateChooser();
        lbl_DepartamentoProyecto = new javax.swing.JLabel();
        cmb_DepartamentoProyecto = new javax.swing.JComboBox<>();
        lbl_FechaEntrega = new javax.swing.JLabel();
        lbl_NombreProyecto = new javax.swing.JLabel();
        txt_NombreProyecto = new javax.swing.JTextField();
        lbl_UsuarioProyecto = new javax.swing.JLabel();
        cmb_UsuarioProyecto = new javax.swing.JComboBox<>();
        lbl_PTareas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jdc_FechaFinal = new com.toedter.calendar.JDateChooser();
        sp_Iteraciones = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        lbl_ErrorFaltaInfo = new javax.swing.JLabel();
        btn_AgregarTareas = new javax.swing.JButton();
        pln_MEstado = new javax.swing.JPanel();
        rdbtn_PEnProceso = new javax.swing.JRadioButton();
        rdbtn_PFinalizado = new javax.swing.JRadioButton();
        cmb_TareasProyecto = new javax.swing.JComboBox<>();
        btn_MenuProyecto = new javax.swing.JButton();
        btn_CrearProyecto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_Proyecto.setBorder(javax.swing.BorderFactory.createTitledBorder("Proyecto"));
        pnl_Proyecto.setName(""); // NOI18N

        lbl_DepartamentoProyecto.setText("Departamento:");

        lbl_FechaEntrega.setText("Fecha entrega:");

        lbl_NombreProyecto.setText("Nombre Proyecto:");

        lbl_UsuarioProyecto.setText("Usuario:");

        cmb_UsuarioProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_UsuarioProyectoActionPerformed(evt);
            }
        });

        lbl_PTareas.setText("Tareas:");

        jLabel1.setText("Fecha final:");

        jLabel2.setText("Iteraciones:");

        lbl_ErrorFaltaInfo.setForeground(new java.awt.Color(255, 0, 0));
        lbl_ErrorFaltaInfo.setText("Falta información");

        btn_AgregarTareas.setText("Agregar ");
        btn_AgregarTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarTareasActionPerformed(evt);
            }
        });

        pln_MEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        EstadoProyecto.add(rdbtn_PEnProceso);
        rdbtn_PEnProceso.setText("En proceso");
        rdbtn_PEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_PEnProcesoActionPerformed(evt);
            }
        });

        EstadoProyecto.add(rdbtn_PFinalizado);
        rdbtn_PFinalizado.setText("Finalizado");
        rdbtn_PFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_PFinalizadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pln_MEstadoLayout = new javax.swing.GroupLayout(pln_MEstado);
        pln_MEstado.setLayout(pln_MEstadoLayout);
        pln_MEstadoLayout.setHorizontalGroup(
            pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstadoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtn_PFinalizado)
                    .addComponent(rdbtn_PEnProceso))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pln_MEstadoLayout.setVerticalGroup(
            pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstadoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rdbtn_PEnProceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbtn_PFinalizado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_ProyectoLayout = new javax.swing.GroupLayout(pnl_Proyecto);
        pnl_Proyecto.setLayout(pnl_ProyectoLayout);
        pnl_ProyectoLayout.setHorizontalGroup(
            pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                        .addComponent(lbl_NombreProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(txt_NombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pln_MEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                            .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(lbl_UsuarioProyecto))
                            .addGap(18, 18, 18)
                            .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmb_UsuarioProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sp_Iteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createSequentialGroup()
                        .addComponent(lbl_DepartamentoProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_DepartamentoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createSequentialGroup()
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_FechaEntrega)
                            .addComponent(jLabel1)
                            .addComponent(lbl_PTareas))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdc_FechaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jdc_FechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmb_TareasProyecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_AgregarTareas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProyectoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_ErrorFaltaInfo)
                .addGap(67, 67, 67))
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
                    .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_FechaEntrega)
                            .addComponent(jdc_FechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jdc_FechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ProyectoLayout.createSequentialGroup()
                        .addGroup(pnl_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_PTareas)
                            .addComponent(cmb_TareasProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_AgregarTareas))
                    .addComponent(pln_MEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(lbl_ErrorFaltaInfo)
                .addContainerGap())
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
                    .addComponent(btn_CrearProyecto))
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
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MenuProyectoActionPerformed

    private void rdbtn_PEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_PEnProcesoActionPerformed

        Estado="En proceso";
    }//GEN-LAST:event_rdbtn_PEnProcesoActionPerformed

    private void rdbtn_PFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_PFinalizadoActionPerformed
        
        Estado="Finalizado";        
    }//GEN-LAST:event_rdbtn_PFinalizadoActionPerformed

    private void btn_AgregarTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarTareasActionPerformed
        Tareas Tr = new Tareas();
        Tr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_AgregarTareasActionPerformed

    private void btn_CrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearProyectoActionPerformed
//       CP.InsertarProyecto(txt_NombreProyecto.getText(), jdc_FechaEntrega.getDate(),
//               cmb_DepartamentoProyecto.getSelectedItem(), Estado, sp_Iteraciones.getValue(), 
//               jdc_FechaFinal.getDate(), cmb_UsuarioProyecto);
        
    }//GEN-LAST:event_btn_CrearProyectoActionPerformed

    private void cmb_UsuarioProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_UsuarioProyectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_UsuarioProyectoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup EstadoProyecto;
    private javax.swing.JButton btn_AgregarTareas;
    private javax.swing.JButton btn_CrearProyecto;
    private javax.swing.JButton btn_MenuProyecto;
    private javax.swing.JComboBox<String> cmb_DepartamentoProyecto;
    private javax.swing.JComboBox<String> cmb_TareasProyecto;
    private javax.swing.JComboBox<String> cmb_UsuarioProyecto;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdc_FechaEntrega;
    private com.toedter.calendar.JDateChooser jdc_FechaFinal;
    private javax.swing.JLabel lbl_DepartamentoProyecto;
    private javax.swing.JLabel lbl_ErrorFaltaInfo;
    private javax.swing.JLabel lbl_FechaEntrega;
    private javax.swing.JLabel lbl_NombreProyecto;
    private javax.swing.JLabel lbl_PTareas;
    private javax.swing.JLabel lbl_UsuarioProyecto;
    private javax.swing.JPanel pln_MEstado;
    private javax.swing.JPanel pnl_Proyecto;
    private javax.swing.JRadioButton rdbtn_PEnProceso;
    private javax.swing.JRadioButton rdbtn_PFinalizado;
    private javax.swing.JSpinner sp_Iteraciones;
    private javax.swing.JTextField txt_NombreProyecto;
    // End of variables declaration//GEN-END:variables
    private String Estado;
}
