
package Vista;

import Controlador.ControladorPersonasConsultas;
import javax.swing.table.DefaultTableModel;

public class Personas extends javax.swing.JFrame {

    private ControladorPersonasConsultas controlador;
    private String cedula;

    public ControladorPersonasConsultas getControlador() {
        return controlador;
    }

    public void setControlador(ControladorPersonasConsultas controlador) {
        this.controlador = controlador;
    }
    
    public Personas() {
        initComponents();
        setTitle("Personas" );
                this.setLocationRelativeTo(null);
                setDefaultCloseOperation(0);

    }

    /*
    Nombre de metodo: MostrarDatosAgregar
    Parametros: DafaultTableModel
    Retorno: Sin retorno
    Descripcion: Carga el modelo con los datos sobre la tabla tblDatosAgregar
    */
    public void MostrarDatosAgregar(DefaultTableModel modelo){
        this.tblDatosAgregar.setModel(modelo);
    }
    
    /*
    Nombre de metodo: MostrarDatosEliminar
    Parametros: DafaultTableModel
    Retorno: Sin retorno
    Descripcion: Carga el modelo con los datos sobre la tabla tblDatosEliminar
    */
    public void MostrarDatosEliminar(DefaultTableModel modelo){
        this.tblDatosEliminar.setModel(modelo);
    }
    
    /*
    Nombre de metodo: MostrarDatosEditar
    Parametros: DafaultTableModel
    Retorno: Sin retorno
    Descripcion: Carga el modelo con los datos sobre la tabla tblDatosEditar
    */
    public void MostrarDatosEditar(DefaultTableModel modelo){
        this.tblDatosEditar.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtngRoles = new javax.swing.ButtonGroup();
        rbtngRolesEditar = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlAgregar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosAgregar = new javax.swing.JTable();
        lblCedula = new javax.swing.JLabel();
        lblRoles = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        rbtnAdministrador = new javax.swing.JRadioButton();
        rbtnSupervisor = new javax.swing.JRadioButton();
        rbtnEmpleado = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        pnlEliminar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatosEliminar = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnMenuEliminar = new javax.swing.JButton();
        pnlEditar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatosEditar = new javax.swing.JTable();
        btnMenuEditar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lblNombreEditar = new javax.swing.JLabel();
        lblApellidoEditar = new javax.swing.JLabel();
        txtNombreEditar = new javax.swing.JTextField();
        txtApellidoEditar = new javax.swing.JTextField();
        rbtnAdministradorEditar = new javax.swing.JRadioButton();
        rbtnSupervisorEditar = new javax.swing.JRadioButton();
        rbtnEmpleadoEditar = new javax.swing.JRadioButton();
        lblRolesEditar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDatosAgregar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatosAgregar);
        if (tblDatosAgregar.getColumnModel().getColumnCount() > 0) {
            tblDatosAgregar.getColumnModel().getColumn(0).setResizable(false);
            tblDatosAgregar.getColumnModel().getColumn(1).setResizable(false);
            tblDatosAgregar.getColumnModel().getColumn(2).setResizable(false);
            tblDatosAgregar.getColumnModel().getColumn(3).setResizable(false);
        }

        lblCedula.setText("Cedula:");

        lblRoles.setText("Roles:");

        btnAgregar.setText("Agregar Persona");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnMenu.setText("Menu");

        rbtngRoles.add(rbtnAdministrador);
        rbtnAdministrador.setText("Administrador");

        rbtngRoles.add(rbtnSupervisor);
        rbtnSupervisor.setText("Supervisor");

        rbtngRoles.add(rbtnEmpleado);
        rbtnEmpleado.setText("Empleado");

        lblNombre.setText("Nombre:");

        lblApellido.setText("Apellido:");

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCedula)
                            .addComponent(lblNombre)
                            .addComponent(lblApellido))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido))
                                .addGap(324, 324, 324)
                                .addComponent(lblRoles)
                                .addGap(89, 89, 89)
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnAdministrador)
                                    .addComponent(rbtnSupervisor)
                                    .addComponent(rbtnEmpleado))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(67, 67, 67))
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addComponent(rbtnAdministrador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnSupervisor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnEmpleado)
                        .addGap(5, 5, 5))
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblRoles)))
                        .addGap(11, 11, 11)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnAgregar)))
                .addComponent(btnMenu)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))))
        );

        jTabbedPane1.addTab("Agregar Persona", pnlAgregar);

        tblDatosEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDatosEliminar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMenuEliminar.setText("Menu");

        javax.swing.GroupLayout pnlEliminarLayout = new javax.swing.GroupLayout(pnlEliminar);
        pnlEliminar.setLayout(pnlEliminarLayout);
        pnlEliminarLayout.setHorizontalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEliminarLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(btnEliminar)
                        .addGap(123, 123, 123)
                        .addComponent(btnMenuEliminar))
                    .addGroup(pnlEliminarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlEliminarLayout.setVerticalGroup(
            pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEliminarLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(pnlEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnMenuEliminar))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Eliminar Persona", pnlEliminar);

        tblDatosEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblDatosEditar);

        btnMenuEditar.setText("Menu");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblNombreEditar.setText("Nombre:");

        lblApellidoEditar.setText("Apellido:");

        rbtngRolesEditar.add(rbtnAdministradorEditar);
        rbtnAdministradorEditar.setText("Administrador");

        rbtngRolesEditar.add(rbtnSupervisorEditar);
        rbtnSupervisorEditar.setText("Supervisor");

        rbtngRolesEditar.add(rbtnEmpleadoEditar);
        rbtnEmpleadoEditar.setText("Empleado");

        lblRolesEditar.setText("Roles:");

        javax.swing.GroupLayout pnlEditarLayout = new javax.swing.GroupLayout(pnlEditar);
        pnlEditar.setLayout(pnlEditarLayout);
        pnlEditarLayout.setHorizontalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(121, 121, 121)
                .addComponent(btnEditar)
                .addGap(215, 215, 215)
                .addComponent(btnMenuEditar)
                .addGap(358, 358, 358))
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditarLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreEditar)
                            .addComponent(lblApellidoEditar))
                        .addGap(41, 41, 41)
                        .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtApellidoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(txtNombreEditar))
                        .addGap(135, 135, 135)
                        .addComponent(lblRolesEditar)
                        .addGap(87, 87, 87)
                        .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnEmpleadoEditar)
                            .addComponent(rbtnSupervisorEditar)
                            .addComponent(rbtnAdministradorEditar)))
                    .addGroup(pnlEditarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEditarLayout.setVerticalGroup(
            pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEditar)
                    .addComponent(txtNombreEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAdministradorEditar)
                    .addComponent(lblRolesEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellidoEditar)
                        .addComponent(txtApellidoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbtnSupervisorEditar))
                .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditarLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnMenuEditar))
                    .addGroup(pnlEditarLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(rbtnEmpleadoEditar)
                        .addGap(43, 43, 43)
                        .addGroup(pnlEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSeleccionar)
                            .addComponent(btnEditar))))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Editar Persona", pnlEditar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Agregar Persona\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(rbtnAdministrador.isSelected()){
            controlador.InsertarPersona(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText());
        }else if(rbtnSupervisor.isSelected()){
            controlador.InsertarPersona(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText());
        }else{
            controlador.InsertarPersona(txtCedula.getText(), txtNombre.getText(), txtApellido.getText(), rbtnAdministrador.getText());
        }
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        rbtngRoles.setSelected(rbtnAdministrador.getModel(),false);
        rbtngRoles.setSelected(rbtnSupervisor.getModel(),false);
        rbtngRoles.setSelected(rbtnEmpleado.getModel(),false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String cedula = tblDatosEliminar.getValueAt(tblDatosEliminar.getSelectedRow(), 0).toString();
        if(cedula != null){
            controlador.EliminarPersona(cedula);
            controlador.Personas();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(rbtnAdministradorEditar.isSelected()){
            controlador.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnAdministradorEditar.getText());
            controlador.Personas();
        }else if(rbtnSupervisorEditar.isSelected()){
            controlador.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnSupervisorEditar.getText());
            controlador.Personas();
        }else{
            controlador.EditarPersona(cedula, txtNombreEditar.getText(), txtApellidoEditar.getText(), rbtnEmpleadoEditar.getText());
            controlador.Personas();
        }
        txtNombreEditar.setText("");
        txtApellidoEditar.setText("");
        rbtnAdministradorEditar.setSelected(false);
        rbtnSupervisorEditar.setSelected(false);
        rbtnEmpleadoEditar.setSelected(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int fila = tblDatosEditar.getSelectedRow();
        if(fila != -1){
            cedula = tblDatosEditar.getValueAt(fila, 0).toString();
            txtNombreEditar.setText(tblDatosEditar.getValueAt(fila, 1).toString());
            txtApellidoEditar.setText(tblDatosEditar.getValueAt(fila, 2).toString());
            if(tblDatosEditar.getValueAt(fila, 3).toString().equals("Administrador")){
                rbtnAdministradorEditar.setSelected(true);
            }else if(tblDatosEditar.getValueAt(fila, 3).toString().equals("Supervisor")){
                rbtnSupervisorEditar.setSelected(true);
            }else{
                rbtnEmpleadoEditar.setSelected(true);
            }
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Personas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Personas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMenuEditar;
    private javax.swing.JButton btnMenuEliminar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblApellidoEditar;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreEditar;
    private javax.swing.JLabel lblRoles;
    private javax.swing.JLabel lblRolesEditar;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlEditar;
    private javax.swing.JPanel pnlEliminar;
    private javax.swing.JRadioButton rbtnAdministrador;
    private javax.swing.JRadioButton rbtnAdministradorEditar;
    private javax.swing.JRadioButton rbtnEmpleado;
    private javax.swing.JRadioButton rbtnEmpleadoEditar;
    private javax.swing.JRadioButton rbtnSupervisor;
    private javax.swing.JRadioButton rbtnSupervisorEditar;
    private javax.swing.ButtonGroup rbtngRoles;
    private javax.swing.ButtonGroup rbtngRolesEditar;
    private javax.swing.JTable tblDatosAgregar;
    private javax.swing.JTable tblDatosEditar;
    private javax.swing.JTable tblDatosEliminar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoEditar;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreEditar;
    // End of variables declaration//GEN-END:variables
}
