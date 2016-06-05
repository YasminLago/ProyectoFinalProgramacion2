package com.yasmin.ventanas;


import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.yasmin.bd.ConexionBD;
import com.yasmin.clases.Empleados;
import static com.yasmin.ventanas.JDialog.lPreguntaDialog;
import static com.yasmin.ventanas.JDialog.lImagenJD;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author Yasmín
 */
public class Login extends javax.swing.JFrame {
    
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    Empleados e = new Empleados();
    JDialog j = new JDialog();
        
    
    public Login() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        e.llenarCBTipoUsers();
        //bAceptar.setMnemonic('');
    }
        
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lTipoUser = new javax.swing.JLabel();
        tipoUser = new javax.swing.JComboBox();
        lUser = new javax.swing.JLabel();
        lPass = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        logoTipoUser = new javax.swing.JLabel();
        logoUser = new javax.swing.JLabel();
        logoKey = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        fondoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lTipoUser.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        lTipoUser.setText("Tipo de Usuario:");
        jPanel1.add(lTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        tipoUser.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        tipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo de usuario" }));
        jPanel1.add(tipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));

        lUser.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        lUser.setText("Usuario:");
        jPanel1.add(lUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        lPass.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        lPass.setText("Contraseña:");
        jPanel1.add(lPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, -1));
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 140, -1));

        logoTipoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/tipoUser.png"))); // NOI18N
        jPanel1.add(logoTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 40));

        logoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/logoUser.png"))); // NOI18N
        jPanel1.add(logoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 40));

        logoKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/key.png"))); // NOI18N
        jPanel1.add(logoKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 20, -1));

        bAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/tickt.png"))); // NOI18N
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(bAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 110, 30));

        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/aspat.png"))); // NOI18N
        bSalir.setText("  Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        jPanel1.add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 110, 30));

        fondoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/bubble.png"))); // NOI18N
        jPanel1.add(fondoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if(e.login()==1){
          this.dispose();
          JOptionPane.showMessageDialog(null,"Login correcto");  
          Stock2 s = new Stock2();
          s.setVisible(true);
      }else{
          JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrecta");
      }
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        if(evt.getSource()==bSalir){
           lPreguntaDialog.setText("¿Está seguro de que desea salir?");
           j.setVisible(true);
        } 
    }//GEN-LAST:event_bSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel fondoLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lPass;
    private javax.swing.JLabel lTipoUser;
    private javax.swing.JLabel lUser;
    private javax.swing.JLabel logoKey;
    private javax.swing.JLabel logoTipoUser;
    private javax.swing.JLabel logoUser;
    public static javax.swing.JPasswordField pass;
    public static javax.swing.JComboBox tipoUser;
    public static javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
