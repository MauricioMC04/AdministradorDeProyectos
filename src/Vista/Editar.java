/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import java.sql.*;
import javax.swing.JOptionPane;



public class Editar extends javax.swing.JFrame {

   
    
    public Editar() {
        initComponents();
        rdbtn_MEnProceso.setSelected(true);
        lbl_MErrorLetras.setVisible(false);
        lbl_MErrorNombre.setVisible(false);
        lbl_MErrorNombreIntegrantes.setVisible(false);
        lbl_MErrorNombreIntegrantesLetras.setVisible(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(0);

    }
    
    
    
        
        
        
        
        
        
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoEstado = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        pln_MCargar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_MTareas = new javax.swing.JTable();
        pln_MEditar = new javax.swing.JPanel();
        pln_MEstado = new javax.swing.JPanel();
        rdbtn_MEnProceso = new javax.swing.JRadioButton();
        rdbtn_MImplementada = new javax.swing.JRadioButton();
        rdbtn_MNoImplementada = new javax.swing.JRadioButton();
        lbl_MNombreTarea = new javax.swing.JLabel();
        txt_MNombreTarea = new javax.swing.JTextField();
        pln_MObservacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_MObservaciones = new javax.swing.JTextArea();
        lbl_MErrorLetras = new javax.swing.JLabel();
        lbl_MErrorNombre = new javax.swing.JLabel();
        btn_MMenu = new javax.swing.JButton();
        btn_MActualizar = new javax.swing.JButton();
        btn_MEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_Usuarios = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();
        txt_Buscador = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_MActualizarDepartamentos = new javax.swing.JButton();
        btn_MenuDepartamentos = new javax.swing.JButton();
        pln_MNombreDepartamento = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_MDepartamentos = new javax.swing.JTable();
        lbl_MNombreDepartamento = new javax.swing.JLabel();
        txt_MNombreDepartamento = new javax.swing.JTextField();
        lbl_MErrorNombreIntegrantes = new javax.swing.JLabel();
        lbl_MErrorNombreIntegrantesLetras = new javax.swing.JLabel();
        btn_EliminarDepartamentos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pln_MEstado1 = new javax.swing.JPanel();
        rdbtn_PEnProceso = new javax.swing.JRadioButton();
        rdbtn_PFinalizado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pln_MCargar.setBorder(javax.swing.BorderFactory.createTitledBorder("Cargar"));

        tbl_MTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tareas"
            }
        ));
        jScrollPane1.setViewportView(tbl_MTareas);

        javax.swing.GroupLayout pln_MCargarLayout = new javax.swing.GroupLayout(pln_MCargar);
        pln_MCargar.setLayout(pln_MCargarLayout);
        pln_MCargarLayout.setHorizontalGroup(
            pln_MCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pln_MCargarLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pln_MCargarLayout.setVerticalGroup(
            pln_MCargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MCargarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pln_MEditar.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        pln_MEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        GrupoEstado.add(rdbtn_MEnProceso);
        rdbtn_MEnProceso.setText("En proceso");
        rdbtn_MEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_MEnProcesoActionPerformed(evt);
            }
        });

        GrupoEstado.add(rdbtn_MImplementada);
        rdbtn_MImplementada.setText("Implementada");
        rdbtn_MImplementada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_MImplementadaActionPerformed(evt);
            }
        });

        GrupoEstado.add(rdbtn_MNoImplementada);
        rdbtn_MNoImplementada.setText("No Implementada");

        javax.swing.GroupLayout pln_MEstadoLayout = new javax.swing.GroupLayout(pln_MEstado);
        pln_MEstado.setLayout(pln_MEstadoLayout);
        pln_MEstadoLayout.setHorizontalGroup(
            pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstadoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtn_MImplementada)
                    .addComponent(rdbtn_MEnProceso)
                    .addComponent(rdbtn_MNoImplementada))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pln_MEstadoLayout.setVerticalGroup(
            pln_MEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstadoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rdbtn_MEnProceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbtn_MImplementada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbtn_MNoImplementada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_MNombreTarea.setText("Nombre:");

        pln_MObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        txt_MObservaciones.setColumns(20);
        txt_MObservaciones.setRows(5);
        jScrollPane2.setViewportView(txt_MObservaciones);

        javax.swing.GroupLayout pln_MObservacionLayout = new javax.swing.GroupLayout(pln_MObservacion);
        pln_MObservacion.setLayout(pln_MObservacionLayout);
        pln_MObservacionLayout.setHorizontalGroup(
            pln_MObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        pln_MObservacionLayout.setVerticalGroup(
            pln_MObservacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MObservacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        lbl_MErrorLetras.setForeground(new java.awt.Color(255, 0, 0));
        lbl_MErrorLetras.setText("Digite solamente letras");

        lbl_MErrorNombre.setForeground(new java.awt.Color(255, 51, 51));
        lbl_MErrorNombre.setText("Falta información");

        javax.swing.GroupLayout pln_MEditarLayout = new javax.swing.GroupLayout(pln_MEditar);
        pln_MEditar.setLayout(pln_MEditarLayout);
        pln_MEditarLayout.setHorizontalGroup(
            pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEditarLayout.createSequentialGroup()
                .addGroup(pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pln_MEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pln_MEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_MNombreTarea)
                        .addGap(18, 18, 18)
                        .addGroup(pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MErrorLetras)
                            .addComponent(txt_MNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_MErrorNombre))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pln_MObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pln_MEditarLayout.setVerticalGroup(
            pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEditarLayout.createSequentialGroup()
                .addComponent(lbl_MErrorNombre)
                .addGap(3, 3, 3)
                .addGroup(pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pln_MEditarLayout.createSequentialGroup()
                        .addComponent(pln_MObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pln_MEditarLayout.createSequentialGroup()
                        .addGroup(pln_MEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_MNombreTarea)
                            .addComponent(txt_MNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_MErrorLetras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pln_MEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        btn_MMenu.setText("Menú");
        btn_MMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MMenuActionPerformed(evt);
            }
        });

        btn_MActualizar.setText("Actualizar");

        btn_MEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_MMenu)
                        .addGap(160, 160, 160)
                        .addComponent(btn_MEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_MActualizar))
                    .addComponent(pln_MEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pln_MCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pln_MCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pln_MEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MMenu)
                    .addComponent(btn_MActualizar)
                    .addComponent(btn_MEliminar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tareas", jPanel1);

        lbl_Usuarios.setText("Lista de usuarios");

        tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbl_Usuarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(lbl_Usuarios))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(txt_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txt_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(lbl_Usuarios)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel2);

        btn_MActualizarDepartamentos.setText("Actualizar");

        btn_MenuDepartamentos.setText("Menú");
        btn_MenuDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MenuDepartamentosActionPerformed(evt);
            }
        });

        pln_MNombreDepartamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre departamento"));

        tbl_MDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Departamentos"
            }
        ));
        jScrollPane3.setViewportView(tbl_MDepartamentos);

        javax.swing.GroupLayout pln_MNombreDepartamentoLayout = new javax.swing.GroupLayout(pln_MNombreDepartamento);
        pln_MNombreDepartamento.setLayout(pln_MNombreDepartamentoLayout);
        pln_MNombreDepartamentoLayout.setHorizontalGroup(
            pln_MNombreDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MNombreDepartamentoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pln_MNombreDepartamentoLayout.setVerticalGroup(
            pln_MNombreDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pln_MNombreDepartamentoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
        );

        lbl_MNombreDepartamento.setText("Nombre:");

        lbl_MErrorNombreIntegrantes.setForeground(new java.awt.Color(255, 0, 0));
        lbl_MErrorNombreIntegrantes.setText("Falta información");

        lbl_MErrorNombreIntegrantesLetras.setForeground(new java.awt.Color(255, 0, 0));
        lbl_MErrorNombreIntegrantesLetras.setText("Digite solamente letras");

        btn_EliminarDepartamentos.setText("Eliminar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_MNombreDepartamento)
                                .addGap(18, 18, 18)
                                .addComponent(txt_MNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_MErrorNombreIntegrantes)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_MErrorNombreIntegrantesLetras)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_MenuDepartamentos)
                                .addGap(167, 167, 167)
                                .addComponent(btn_EliminarDepartamentos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_MActualizarDepartamentos))))
                    .addComponent(pln_MNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(pln_MNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MNombreDepartamento)
                    .addComponent(txt_MNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_MErrorNombreIntegrantes)
                    .addComponent(lbl_MErrorNombreIntegrantesLetras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_MenuDepartamentos)
                    .addComponent(btn_EliminarDepartamentos)
                    .addComponent(btn_MActualizarDepartamentos))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Departamentos", jPanel3);

        pln_MEstado1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        rdbtn_PEnProceso.setText("En proceso");
        rdbtn_PEnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_PEnProcesoActionPerformed(evt);
            }
        });

        rdbtn_PFinalizado.setText("Finalizado");
        rdbtn_PFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtn_PFinalizadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pln_MEstado1Layout = new javax.swing.GroupLayout(pln_MEstado1);
        pln_MEstado1.setLayout(pln_MEstado1Layout);
        pln_MEstado1Layout.setHorizontalGroup(
            pln_MEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstado1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pln_MEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtn_PFinalizado)
                    .addComponent(rdbtn_PEnProceso))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pln_MEstado1Layout.setVerticalGroup(
            pln_MEstado1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pln_MEstado1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rdbtn_PEnProceso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbtn_PFinalizado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(213, 213, 213)
                    .addComponent(pln_MEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(214, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(232, 232, 232)
                    .addComponent(pln_MEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(232, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Proyectos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbtn_MEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_MEnProcesoActionPerformed

    }//GEN-LAST:event_rdbtn_MEnProcesoActionPerformed

    private void rdbtn_MImplementadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_MImplementadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtn_MImplementadaActionPerformed

    private void btn_MMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MMenuActionPerformed
        
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MMenuActionPerformed

    private void btn_MenuDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MenuDepartamentosActionPerformed
        Menu M = new Menu();
        M.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_MenuDepartamentosActionPerformed

    private void rdbtn_PEnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_PEnProcesoActionPerformed

        Estado = "En proceso";
    }//GEN-LAST:event_rdbtn_PEnProcesoActionPerformed

    private void rdbtn_PFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtn_PFinalizadoActionPerformed

        Estado = "Finalizado";
    }//GEN-LAST:event_rdbtn_PFinalizadoActionPerformed

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
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoEstado;
    private javax.swing.JButton btn_EliminarDepartamentos;
    private javax.swing.JButton btn_MActualizar;
    private javax.swing.JButton btn_MActualizarDepartamentos;
    private javax.swing.JButton btn_MEliminar;
    private javax.swing.JButton btn_MMenu;
    private javax.swing.JButton btn_MenuDepartamentos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_MErrorLetras;
    private javax.swing.JLabel lbl_MErrorNombre;
    private javax.swing.JLabel lbl_MErrorNombreIntegrantes;
    private javax.swing.JLabel lbl_MErrorNombreIntegrantesLetras;
    private javax.swing.JLabel lbl_MNombreDepartamento;
    private javax.swing.JLabel lbl_MNombreTarea;
    private javax.swing.JLabel lbl_Usuarios;
    private javax.swing.JPanel pln_MCargar;
    private javax.swing.JPanel pln_MEditar;
    private javax.swing.JPanel pln_MEstado;
    private javax.swing.JPanel pln_MEstado1;
    private javax.swing.JPanel pln_MNombreDepartamento;
    private javax.swing.JPanel pln_MObservacion;
    private javax.swing.JRadioButton rdbtn_MEnProceso;
    private javax.swing.JRadioButton rdbtn_MImplementada;
    private javax.swing.JRadioButton rdbtn_MNoImplementada;
    private javax.swing.JRadioButton rdbtn_PEnProceso;
    private javax.swing.JRadioButton rdbtn_PFinalizado;
    private javax.swing.JTable tbl_MDepartamentos;
    private javax.swing.JTable tbl_MTareas;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_Buscador;
    private javax.swing.JTextField txt_MNombreDepartamento;
    private javax.swing.JTextField txt_MNombreTarea;
    private javax.swing.JTextArea txt_MObservaciones;
    // End of variables declaration//GEN-END:variables
private String Estado;
}
