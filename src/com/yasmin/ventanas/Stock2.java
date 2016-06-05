package com.yasmin.ventanas;

import com.yasmin.bd.ConexionBD;
import com.yasmin.clases.Productos;
import static com.yasmin.ventanas.BuscarImagen.cargarImagen;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public final class Stock2 extends javax.swing.JFrame implements Runnable{
    
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    Caja c = new Caja();
    ArqueoCaja ac = new ArqueoCaja();
    Usuarios u = new Usuarios();
    
    Thread hilo;
    int numDia = 0;
    int numMes = 0;
    String date,year,dia,mes,hora,minutos,segundos;
    File fichero;
    public String ruta;
    
    String [] day = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado"     
    };
    
    String [] month = {
        "Enero",
        "Febrero",
        "Marzo", 
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };
    
    public Stock2(){
        initComponents();
        
            hilo = new Thread(this);
            hilo.start();
            this.setLocationRelativeTo(null);//Ventana centrada
            bReparar.setToolTipText("Equipos para reparar");
            bSalir.setToolTipText("Salir");
            bAdminUsers.setToolTipText("Administrar usuarios");
            bEmpleados.setToolTipText("Información empleados");
            bPresupuesto.setToolTipText("Presupuestos");
            bTiendaOn.setToolTipText("Ir a tienda Online");
            bCobrar.setToolTipText("Cobrar");
            bArqueo.setToolTipText("Arqueo de caja");
            //opcProd.setVisible(false); 
            lConectUser.setText(user.getText());
            lTipoCUser.setText((String) tipoUser.getSelectedItem());
            
            privilegios();
                
    }
    
    /**
     * Marca o desmarca botones en función del tipo de 
     * usuario conectado y cambia la imagen de fondo
     */
    public void privilegios(){
        if(tipoUser.getSelectedItem().equals("Empleado")) {
                bEmpleados.setEnabled(false);
                bAdminUsers.setEnabled(false);
                fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/verde.jpg")));
        }else if(tipoUser.getSelectedItem().equals("Administrador")) {
                bEmpleados.setEnabled(true);
                bAdminUsers.setEnabled(true);
                fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/azul.jpg")));
        } else {
                fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/invitado.jpg")));
            
        }
    }
    
    @Override
    public void run() {  
        Thread ct = Thread.currentThread();
        while(ct == hilo) {
        fecha();
        lDate.setText(day[numDia-1]+", "+date+" de "+month[numMes]+" de "+year+" "+hora + ":" + minutos + ":" + segundos);
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e) {}
        }
    }
    /**
     * Fecha y hora actuales
     */
    public void fecha() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();  
        calendario.setTime(fechaHoraActual);
        Date dias = new Date();
        Date meses = new Date();
            numDia=0;
            Calendar cal = Calendar.getInstance();
            numDia = cal.get(Calendar.DAY_OF_WEEK);
        
            Calendar c = Calendar.getInstance();
            numMes = c.get(Calendar.MONTH);
        
            date = calendario.get(Calendar.DAY_OF_MONTH)>9?""+calendario.get(Calendar.DAY_OF_MONTH):"0"+ calendario.get(Calendar.DAY_OF_MONTH);
            year = calendario.get(Calendar.YEAR)>9?""+calendario.get(Calendar.YEAR):"0"+calendario.get(Calendar.YEAR);
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
            minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        toolBarDate = new javax.swing.JToolBar();
        lDate = new javax.swing.JLabel();
        lUsuario = new javax.swing.JLabel();
        lConectUser = new javax.swing.JLabel();
        lTipo = new javax.swing.JLabel();
        lTipoCUser = new javax.swing.JLabel();
        bArqueo = new javax.swing.JButton();
        bCobrar = new javax.swing.JButton();
        bAdminUsers = new javax.swing.JButton();
        bEmpleados = new javax.swing.JButton();
        bTiendaOn = new javax.swing.JButton();
        bReparar = new javax.swing.JButton();
        bPresupuesto = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        fondoStock2 = new javax.swing.JLabel();
        menubarOpc = new javax.swing.JMenuBar();
        menuVer = new javax.swing.JMenu();
        itemProd = new javax.swing.JMenuItem();
        menuItemCat = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPanel.setPreferredSize(new java.awt.Dimension(800, 635));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toolBarDate.setRollover(true);

        lDate.setText("date");
        toolBarDate.add(lDate);

        lUsuario.setText("                                                                   Usuario: ");
        toolBarDate.add(lUsuario);

        lConectUser.setText(" user");
        toolBarDate.add(lConectUser);

        lTipo.setText("        Tipo: ");
        toolBarDate.add(lTipo);

        lTipoCUser.setText(" type");
        toolBarDate.add(lTipoCUser);

        JPanel.add(toolBarDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 605, 720, 30));

        bArqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/arqueoCaja.png"))); // NOI18N
        bArqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bArqueoActionPerformed(evt);
            }
        });
        JPanel.add(bArqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 90, 70));

        bCobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/cobrar.png"))); // NOI18N
        bCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCobrarActionPerformed(evt);
            }
        });
        JPanel.add(bCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        bAdminUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/usuarios.png"))); // NOI18N
        bAdminUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdminUsersActionPerformed(evt);
            }
        });
        JPanel.add(bAdminUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 90, 70));

        bEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/verEmpleado.png"))); // NOI18N
        bEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmpleadosActionPerformed(evt);
            }
        });
        JPanel.add(bEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 90, 70));

        bTiendaOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/tiendaOnline.png"))); // NOI18N
        JPanel.add(bTiendaOn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 90, 70));

        bReparar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/reparar.png"))); // NOI18N
        JPanel.add(bReparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 90, 70));

        bPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/presupuesto.png"))); // NOI18N
        JPanel.add(bPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 90, 70));

        bSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/salir.png"))); // NOI18N
        JPanel.add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 90, 70));
        JPanel.add(fondoStock2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 630));

        menuVer.setText("Ver");

        itemProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/productop.png"))); // NOI18N
        itemProd.setText("Productos");
        itemProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProdActionPerformed(evt);
            }
        });
        menuVer.add(itemProd);

        menuItemCat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuItemCat.setText("Categorías");
        menuVer.add(menuItemCat);

        menubarOpc.add(menuVer);

        jMenu3.setText("Edit");
        menubarOpc.add(jMenu3);

        setJMenuBar(menubarOpc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProdActionPerformed
       // opcProd.setVisible(true);        
    }//GEN-LAST:event_itemProdActionPerformed

    private void bEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmpleadosActionPerformed
      
    }//GEN-LAST:event_bEmpleadosActionPerformed

    private void bArqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bArqueoActionPerformed
        ac.setVisible(true);
    }//GEN-LAST:event_bArqueoActionPerformed

    private void bAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdminUsersActionPerformed
        u.setVisible(true);
    }//GEN-LAST:event_bAdminUsersActionPerformed

    private void bCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCobrarActionPerformed
        c.setVisible(true);
    }//GEN-LAST:event_bCobrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton bAdminUsers;
    private javax.swing.JButton bArqueo;
    private javax.swing.JButton bCobrar;
    private javax.swing.JButton bEmpleados;
    private javax.swing.JButton bPresupuesto;
    private javax.swing.JButton bReparar;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bTiendaOn;
    public static javax.swing.JLabel fondoStock2;
    private javax.swing.JMenuItem itemProd;
    private javax.swing.JMenu jMenu3;
    public static javax.swing.JLabel lConectUser;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lTipo;
    public static javax.swing.JLabel lTipoCUser;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JMenuItem menuItemCat;
    private javax.swing.JMenu menuVer;
    private javax.swing.JMenuBar menubarOpc;
    private javax.swing.JToolBar toolBarDate;
    // End of variables declaration//GEN-END:variables

    
}
