package com.yasmin.ventanas;


import com.yasmin.clases.Empleados;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasmín
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    
    Empleados e = new Empleados();
    
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

        tipoUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jPanel1.add(bAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 100, 30));

        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/aspat.png"))); // NOI18N
        bSalir.setText("  Salir");
        jPanel1.add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 100, 30));

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
    private javax.swing.JComboBox tipoUser;
    public static javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
