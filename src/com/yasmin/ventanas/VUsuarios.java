package com.yasmin.ventanas;

import com.yasmin.clases.Empleados;
import com.yasmin.clases.Usuarios;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yasmín
 */
public class VUsuarios extends javax.swing.JFrame {
    
    Usuarios u = new Usuarios();
    
    public VUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);//Ventana centrada
        u.listaTablaUsuarios();
        u.llenarCBTpU();
        
        bEliminar.setEnabled(false);
        bModificarU.setEnabled(false);
        bGuardar.setEnabled(false);
        bAñadir.setEnabled(false);
        
        nomU.setEditable(false);
        tpU.setEnabled(false);
        claveU.setEditable(false);
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuarios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bAñadir = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        panelDatos = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        nomU = new javax.swing.JTextField();
        tpU = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        claveU = new javax.swing.JTextField();
        bModificarU = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelTablaU = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaU = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Administrar Usuarios");

        bAñadir.setText("Añadir Usuario");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bNuevo.setText("Nuevo Usuario");
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });

        panelDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label.setText("Nombre:");

        tpU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Usuario" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tipo de Usuario:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Clave de Acceso:");

        bModificarU.setText("Modificar");
        bModificarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarUActionPerformed(evt);
            }
        });

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/diskette_save_saveas_1514.png"))); // NOI18N
        bGuardar.setText("Guardar Modificación");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Datos de acceso");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label)
                        .addGap(77, 77, 77)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tpU, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomU, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(claveU, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel8))
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bModificarU)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(bGuardar)
                        .addContainerGap())))
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(nomU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tpU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bModificarU, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        panelTablaU.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        tablaU.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        tablaU.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaU);

        javax.swing.GroupLayout panelTablaULayout = new javax.swing.GroupLayout(panelTablaU);
        panelTablaU.setLayout(panelTablaULayout);
        panelTablaULayout.setHorizontalGroup(
            panelTablaULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaULayout.setVerticalGroup(
            panelTablaULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelUsuariosLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(bNuevo)
                        .addGap(31, 31, 31)
                        .addComponent(bAñadir)))
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(bEliminar)
                        .addGap(26, 26, 26)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(panelTablaU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(236, 236, 236))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSalir)))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bNuevo)
                            .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUMouseClicked
        int row = tablaU.rowAtPoint(evt.getPoint());   
        nomU.setText(tablaU.getModel().getValueAt(row, 0).toString()); 
        tpU.setSelectedItem(tablaU.getModel().getValueAt(row, 1).toString());
        claveU.setText(tablaU.getModel().getValueAt(row, 2).toString());
        
        
        bModificarU.setEnabled(true);
        bGuardar.setEnabled(false);    
        bAñadir.setEnabled(false);
        bEliminar.setEnabled(true);
    }//GEN-LAST:event_tablaUMouseClicked

    private void bModificarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarUActionPerformed
        nomU.setEditable(true);
        tpU.setEnabled(true);
        claveU.setEditable(true);
        bEliminar.setEnabled(false);
        bModificarU.setEnabled(false);
        bGuardar.setEnabled(true);   
    }//GEN-LAST:event_bModificarUActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        try {
            u.modificarUsuarios();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        bGuardar.setEnabled(false);
        nomU.setEditable(false);
        tpU.setEnabled(false);
        claveU.setEditable(false);
        bModificarU.setEnabled(true);
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        try {
            u.insertUsuarios();
        } catch (SQLException ex) {       
        } catch (IOException ex) {   
        }
        bAñadir.setEnabled(false);
        bNuevo.setEnabled(true);
        nomU.setEditable(false);
        tpU.setEnabled(false);
        claveU.setEditable(false);
    }//GEN-LAST:event_bAñadirActionPerformed

    private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed
        nomU.setEditable(true);
        tpU.setEnabled(true);
        claveU.setEditable(true);
        
        
        nomU.setText("");
        tpU.setSelectedIndex(0);
        claveU.setText("");
        
        bAñadir.setEnabled(true);
        bModificarU.setEnabled(false);
        bGuardar.setEnabled(false);
        bEliminar.setEnabled(false);
        bNuevo.setEnabled(false);
    }//GEN-LAST:event_bNuevoActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        try {
            u.eliminarUsuarios();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        bEliminar.setEnabled(false);
        bModificarU.setEnabled(false);
        
        nomU.setText(""); 
        tpU.setSelectedIndex(0);
        claveU.setText("");
    }//GEN-LAST:event_bEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bModificarU;
    private javax.swing.JButton bNuevo;
    private javax.swing.JButton bSalir;
    public static javax.swing.JTextField claveU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    public static javax.swing.JTextField nomU;
    public static javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelTablaU;
    private javax.swing.JPanel panelUsuarios;
    public static javax.swing.JTable tablaU;
    public static javax.swing.JComboBox tpU;
    // End of variables declaration//GEN-END:variables
}
