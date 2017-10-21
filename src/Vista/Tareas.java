/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Tareas extends javax.swing.JFrame {

    /**
     * Creates new form Tareas
     */
    public Tareas() {
        initComponents();
        mostrartabla();
        cargarcbxTareas();
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(0);
    }  
    Conexion conec = new Conexion();
    Connection c = conec.conexion();

    
    public void mostrartabla(){
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID Usuario");
    modelo.addColumn("Nombres");
    tbl_TIntegrantes.setModel(modelo);
    
    String sql = "SELECT * FROM Usuario";
    
    String datos[] = new String [2];
    Statement st;
    
        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            datos[0] = rs.getString(1);
            datos[1] = rs.getString(2);
            modelo.addRow(datos);
            }
            tbl_TIntegrantes.setModel(modelo);
        } catch (SQLException ex) {
            
        }
   
    
    }
    
   
    
    public void cargarcbxTareas() {
        String sql = "SELECT * FROM Tareas";
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String datos = "";
        try {
            Statement ejecutor = c.createStatement();
            ResultSet rs = ejecutor.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString("Nombre");
                cmb_PTareas.addItem(datos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnl_TIntegrantes = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_TIntegrantes = new javax.swing.JTable();
        lbl_MInteSeleccionados = new javax.swing.JLabel();
        txt_TIntegrante = new javax.swing.JTextField();
        lbl_TEmpleadosDisponibles = new javax.swing.JLabel();
        cmb_PTareas = new javax.swing.JComboBox<>();
        lbl_PTareas = new javax.swing.JLabel();
        btn_TAgregar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_TIntegrantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Integrantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        tbl_TIntegrantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbl_TIntegrantes);

        lbl_MInteSeleccionados.setText("Integrante seleccionado");

        txt_TIntegrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TIntegranteActionPerformed(evt);
            }
        });

        lbl_TEmpleadosDisponibles.setText("Empleados disponibles:");

        javax.swing.GroupLayout pnl_TIntegrantesLayout = new javax.swing.GroupLayout(pnl_TIntegrantes);
        pnl_TIntegrantes.setLayout(pnl_TIntegrantesLayout);
        pnl_TIntegrantesLayout.setHorizontalGroup(
            pnl_TIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TIntegrantesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_TIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TEmpleadosDisponibles)
                    .addGroup(pnl_TIntegrantesLayout.createSequentialGroup()
                        .addComponent(lbl_MInteSeleccionados)
                        .addGap(33, 33, 33)
                        .addComponent(txt_TIntegrante, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnl_TIntegrantesLayout.setVerticalGroup(
            pnl_TIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TIntegrantesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbl_TEmpleadosDisponibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(pnl_TIntegrantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MInteSeleccionados)
                    .addComponent(txt_TIntegrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lbl_PTareas.setText("Tareas:");

        btn_TAgregar.setText("Agregar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_PTareas)
                            .addGap(18, 18, 18)
                            .addComponent(cmb_PTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(pnl_TIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_TAgregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PTareas)
                    .addComponent(cmb_PTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnl_TIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btn_TAgregar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_TIntegranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TIntegranteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TIntegranteActionPerformed

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
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tareas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TAgregar;
    private javax.swing.JComboBox<String> cmb_PTareas;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_MInteSeleccionados;
    private javax.swing.JLabel lbl_PTareas;
    private javax.swing.JLabel lbl_TEmpleadosDisponibles;
    private javax.swing.JPanel pnl_TIntegrantes;
    private javax.swing.JTable tbl_TIntegrantes;
    private javax.swing.JTextField txt_TIntegrante;
    // End of variables declaration//GEN-END:variables
}
