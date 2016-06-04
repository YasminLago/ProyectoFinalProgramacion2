package com.yasmin.ventanas;

import com.yasmin.clases.Empleados;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Yasmín
 */
public class Usuarios extends javax.swing.JFrame {
    Empleados e = new Empleados();
    public Usuarios() throws SQLException, IOException {
        initComponents();
        e.listaUsuarios();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUsuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaU = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        dniU = new javax.swing.JTextField();
        momU = new javax.swing.JTextField();
        apeU = new javax.swing.JTextField();
        dirU = new javax.swing.JTextField();
        telU = new javax.swing.JTextField();
        claveU = new javax.swing.JTextField();
        bAñadir = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(tablaU);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Registrar nuevo usuario:");

        jLabel2.setText("DNI:");

        label.setText("Nombre:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Dirección:");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("Tipo de Usuario:");

        jLabel9.setText("Clave de Acceso:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo Usuario" }));

        dniU.setText("jTextField1");

        momU.setText("jTextField1");

        apeU.setText("jTextField2");

        dirU.setText("jTextField3");

        telU.setText("jTextField4");

        claveU.setText("jTextField1");

        bAñadir.setText("Añadir");

        bEliminar.setText("Eliminar");

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dirU, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel2))
                                    .addComponent(label, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(momU, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(apeU)
                                    .addComponent(dniU))))
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(34, 34, 34)
                                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 115, Short.MAX_VALUE)
                                    .addComponent(telU)
                                    .addComponent(claveU)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bAñadir)
                                .addGap(31, 31, 31)
                                .addComponent(bEliminar)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(dniU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(momU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(apeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(claveU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dirU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAñadir)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField apeU;
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bEliminar;
    public static javax.swing.JTextField claveU;
    public static javax.swing.JTextField dirU;
    public static javax.swing.JTextField dniU;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    public static javax.swing.JTextField momU;
    private javax.swing.JPanel panelUsuarios;
    public static javax.swing.JTable tablaU;
    public static javax.swing.JTextField telU;
    // End of variables declaration//GEN-END:variables
}
