package com.yasmin.ventanas;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.yasmin.bd.ConexionBD;
import com.yasmin.clases.Productos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yasmín
 */
public final class Caja extends javax.swing.JFrame {
    
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    TextAutoCompleter textAutoAcompleter;
    Productos p = new Productos();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public Caja() {
        initComponents();
        this.setLocationRelativeTo(null);//Ventana centrada
        //itemsAutocompletar();
        cargarDatos();
    }
    
        
        public void cargarDatos(){    
        ResultSet rs=null;

        /**
         * Método para la selección de un item
         */
        textAutoAcompleter = new TextAutoCompleter(autoCompletar, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem){          
                
                try {
                    System.out.println("El usuario seleccionó: " + selectedItem);
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT codp,nomp,precio FROM productos WHERE nomp='"+selectedItem+"'");
                    
                    Object[] datos = new Object[3];
                    while (rs.next()) {
                        datos[0] = rs.getString(1);
                        datos[1] = selectedItem; //Se recoge el item seleccionado y se guarda en la tabla
                        datos[2] = rs.getString(3);
                        modelo.addRow(datos);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });                            
        try {

            rs= p.getListaProductos(); // Recibe los datos del select de método getListaProductos()         
            while(rs.next()){               
                textAutoAcompleter.addItem(rs.getString(2)); // Se llena autocompletar   
            }             
            
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
      
            tarticulosCaja.setModel(modelo);                    
        } 
        catch (Exception ex){       
        } 
        finally 
        {
            /*
                CERRAMOS el resultset ya no lo necesitamos 
            */
          if (rs != null) 
             try { rs.close(); } 
             catch(Exception e) {}   
        }
    }
        
        /**
         * Calcula el precio total de los articulos seleccionados como compra
         */
        int sum=0;
        int sum1=0;
        public void sumarPrecios(){
            int totalPrecios = tarticulosCaja.getRowCount();
            totalPrecios -=1;
            for(int i=0;i<=totalPrecios;i++){
                sum=Integer.parseInt(String.valueOf(tarticulosCaja.getValueAt(i, 2)));
               sum1 +=sum;
            }
            System.out.println(sum1);
            
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarticulosCaja = new javax.swing.JTable();
        autoCompletar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        totalPrecios = new javax.swing.JLabel();
        bCalcularPrecioTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        tarticulosCaja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tarticulosCaja);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Buscar:");

        totalPrecios.setText("jLabel2");

        bCalcularPrecioTotal.setText("jButton1");
        bCalcularPrecioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularPrecioTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(autoCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bCalcularPrecioTotal)
                            .addComponent(totalPrecios))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(autoCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCalcularPrecioTotal)
                        .addGap(33, 33, 33)
                        .addComponent(totalPrecios))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(360, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCalcularPrecioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularPrecioTotalActionPerformed
        sumarPrecios();
    }//GEN-LAST:event_bCalcularPrecioTotalActionPerformed

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField autoCompletar;
    private javax.swing.JButton bCalcularPrecioTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tarticulosCaja;
    private javax.swing.JLabel totalPrecios;
    // End of variables declaration//GEN-END:variables
}
