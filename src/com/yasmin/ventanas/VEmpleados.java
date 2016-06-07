package com.yasmin.ventanas;

import com.yasmin.clases.Empleados;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Yasmín
 */
public class VEmpleados extends javax.swing.JFrame {

    Empleados e = new Empleados();

    public VEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);//Ventana centrada
        e.listaTablaEmpleados();
        e.llenarCBTpE();

        bEliminarEmpl.setEnabled(false);
        bModificarE.setEnabled(false);
        bGuardarEmpl.setEnabled(false);
        bAñadirEmpl.setEnabled(false);

        dniE.setEditable(false);
        nomE.setEditable(false);
        apeE.setEditable(false);
        dirE.setEditable(false);
        telE.setEditable(false);
        tpE.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuarios = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bAñadirEmpl = new javax.swing.JButton();
        bEliminarEmpl = new javax.swing.JButton();
        bSalirVE = new javax.swing.JButton();
        bNuevoEmpl = new javax.swing.JButton();
        panelDatosE = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dniE = new javax.swing.JTextField();
        nomE = new javax.swing.JTextField();
        apeE = new javax.swing.JTextField();
        dirE = new javax.swing.JTextField();
        tpE = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        telE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bModificarE = new javax.swing.JButton();
        bGuardarEmpl = new javax.swing.JButton();
        panelTablaU = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaE = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Administrar Empleados");

        bAñadirEmpl.setText("Añadir Empleado");
        bAñadirEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirEmplActionPerformed(evt);
            }
        });

        bEliminarEmpl.setText("Eliminar");
        bEliminarEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarEmplActionPerformed(evt);
            }
        });

        bSalirVE.setText("Salir");
        bSalirVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirVEActionPerformed(evt);
            }
        });

        bNuevoEmpl.setText("Nuevo Empleado");
        bNuevoEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoEmplActionPerformed(evt);
            }
        });

        panelDatosE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DNI:");

        label.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección:");

        tpE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Empleado" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Teléfono:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tipo de Empleado:");

        bModificarE.setText("Modificar");
        bModificarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarEActionPerformed(evt);
            }
        });

        bGuardarEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/diskette_save_saveas_1514.png"))); // NOI18N
        bGuardarEmpl.setText("Guardar Modificación");
        bGuardarEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarEmplActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosELayout = new javax.swing.GroupLayout(panelDatosE);
        panelDatosE.setLayout(panelDatosELayout);
        panelDatosELayout.setHorizontalGroup(
            panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosELayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(label))
                .addGap(30, 30, 30)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dirE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apeE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosELayout.createSequentialGroup()
                        .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telE, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tpE, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosELayout.createSequentialGroup()
                        .addComponent(bModificarE)
                        .addGap(37, 37, 37)
                        .addComponent(bGuardarEmpl)))
                .addGap(86, 86, 86))
        );
        panelDatosELayout.setVerticalGroup(
            panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosELayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(telE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tpE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label))
                .addGap(18, 18, 18)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(apeE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(panelDatosELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dirE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(bModificarE, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGuardarEmpl))
                .addGap(18, 18, 18))
        );

        panelTablaU.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        tablaE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        tablaE.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaE);

        javax.swing.GroupLayout panelTablaULayout = new javax.swing.GroupLayout(panelTablaU);
        panelTablaU.setLayout(panelTablaULayout);
        panelTablaULayout.setHorizontalGroup(
            panelTablaULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTablaULayout.setVerticalGroup(
            panelTablaULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaULayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelDatosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addComponent(bNuevoEmpl)
                                .addGap(18, 18, 18)
                                .addComponent(bAñadirEmpl)
                                .addGap(18, 18, 18)
                                .addComponent(bEliminarEmpl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bSalirVE, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTablaU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(panelDatosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNuevoEmpl)
                    .addComponent(bAñadirEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminarEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalirVE))
                .addGap(29, 29, 29)
                .addComponent(panelTablaU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAñadirEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirEmplActionPerformed
        try {
            e.insertEmpleados();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        bAñadirEmpl.setEnabled(false);

        dniE.setEditable(false);
        nomE.setEditable(false);
        apeE.setEditable(false);
        dirE.setEditable(false);
        telE.setEditable(false);
        tpE.setEnabled(false);

        bNuevoEmpl.setEnabled(true);
    }//GEN-LAST:event_bAñadirEmplActionPerformed

    private void bEliminarEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarEmplActionPerformed
        try {
            e.eliminarEmpleados();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }
        bEliminarEmpl.setEnabled(false);
        bModificarE.setEnabled(false);

        dniE.setText("");
        nomE.setText("");
        apeE.setText("");
        dirE.setText("");
        telE.setText("");
        tpE.setSelectedIndex(0);
    }//GEN-LAST:event_bEliminarEmplActionPerformed

    private void bSalirVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirVEActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirVEActionPerformed

    private void bNuevoEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoEmplActionPerformed
        dniE.setEditable(true);
        nomE.setEditable(true);
        apeE.setEditable(true);
        dirE.setEditable(true);
        telE.setEditable(true);
        tpE.setEnabled(true);

        dniE.setText("");
        nomE.setText("");
        apeE.setText("");
        dirE.setText("");
        telE.setText("");
        tpE.setSelectedIndex(0);

        bNuevoEmpl.setEnabled(false);
        bAñadirEmpl.setEnabled(true);
        bModificarE.setEnabled(false);
        bGuardarEmpl.setEnabled(false);
        bEliminarEmpl.setEnabled(false);
    }//GEN-LAST:event_bNuevoEmplActionPerformed

    private void bModificarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarEActionPerformed
        dniE.setEditable(true);
        nomE.setEditable(true);
        apeE.setEditable(true);
        dirE.setEditable(true);
        telE.setEditable(true);
        tpE.setEnabled(true);

        bEliminarEmpl.setEnabled(false);
        bModificarE.setEnabled(false);
        bGuardarEmpl.setEnabled(true);
    }//GEN-LAST:event_bModificarEActionPerformed

    private void bGuardarEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarEmplActionPerformed
        try {
            e.modificarEmpleados();
        } catch (SQLException ex) {
        } catch (IOException ex) {
        }

        bModificarE.setEnabled(true);
        bGuardarEmpl.setEnabled(false);
        dniE.setEditable(false);
        nomE.setEditable(false);
        apeE.setEditable(false);
        dirE.setEditable(false);
        telE.setEditable(false);
        tpE.setEnabled(false);


    }//GEN-LAST:event_bGuardarEmplActionPerformed

    private void tablaEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEMouseClicked
        int row = tablaE.rowAtPoint(evt.getPoint());
        dniE.setText(tablaE.getModel().getValueAt(row, 0).toString());
        nomE.setText(tablaE.getModel().getValueAt(row, 1).toString());
        apeE.setText(tablaE.getModel().getValueAt(row, 2).toString());
        dirE.setText(tablaE.getModel().getValueAt(row, 3).toString());
        telE.setText(tablaE.getModel().getValueAt(row, 4).toString());
        tpE.setSelectedItem(tablaE.getModel().getValueAt(row, 5).toString());

        bModificarE.setEnabled(true);
        bEliminarEmpl.setEnabled(true);
    }//GEN-LAST:event_tablaEMouseClicked

    private void dirUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirUActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField apeE;
    private javax.swing.JButton bAñadirEmpl;
    private javax.swing.JButton bEliminarEmpl;
    private javax.swing.JButton bGuardarEmpl;
    private javax.swing.JButton bModificarE;
    private javax.swing.JButton bNuevoEmpl;
    private javax.swing.JButton bSalirVE;
    public static javax.swing.JTextField dirE;
    public static javax.swing.JTextField dniE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    public static javax.swing.JTextField nomE;
    public static javax.swing.JPanel panelDatosE;
    private javax.swing.JPanel panelTablaU;
    private javax.swing.JPanel panelUsuarios;
    public static javax.swing.JTable tablaE;
    public static javax.swing.JTextField telE;
    public static javax.swing.JComboBox tpE;
    // End of variables declaration//GEN-END:variables
}
