package com.yasmin.ventanas;

import com.mxrck.autocompleter.AutoCompleterCallback;
import com.mxrck.autocompleter.TextAutoCompleter;
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
    VUsuarios u = new VUsuarios();
    VEmpleados v = new VEmpleados();
    TextAutoCompleter textAutoAcompleter;
    Productos p = new Productos();
    DefaultTableModel modelo = new DefaultTableModel();
    
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
            opcProd.setVisible(false); 
            opcCat.setVisible(false);
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
                fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/empleado.jpg")));
        }else if(tipoUser.getSelectedItem().equals("Administrador")) {
                bEmpleados.setEnabled(true);
                bAdminUsers.setEnabled(true);
                fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/administrador.jpg")));
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
    
    
    /**
     * Carga los datos de la BD en el JTextField 
     */
   /* public void cargarDatos() {
        ResultSet rs = null;

        /**
         * Método para la selección de un item
         */
       /* textAutoAcompleter = new TextAutoCompleter(buscardelete, new AutoCompleterCallback() {
            @Override
            public void callback(Object selectedItem) {

                try {
                    System.out.println("El usuario seleccionó: " + selectedItem);
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT codp,nomp,precio,stock,codc FROM productos WHERE nomp='" + selectedItem + "'");

                    Object[] datos = new Object[5];
                    while (rs.next()) {
                        datos[0] = rs.getString(1);
                        datos[1] = selectedItem; //Se recoge el item seleccionado y se guarda en la tabla
                        datos[2] = rs.getString(3);
                        datos[3] = rs.getString(4);
                        datos[4] = rs.getString(5);
                        modelo.addRow(datos);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        try {

            rs = p.getListaProductos(); // Recibe los datos del select del método getListaProductos()         
            while (rs.next()) {
                textAutoAcompleter.addItem(rs.getString(2)); // Se llena autocompletar   
            }

            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Stock");
            modelo.addColumn("Categoría");

            tablaDelete.setModel(modelo);
        } catch (Exception ex) {
        } finally {
            /*
             CERRAMOS el resultset
             */
            /*if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
        }
    }*/
    
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
        opcCat = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        opcProd = new javax.swing.JTabbedPane();
        buscarProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        busquedaCod = new javax.swing.JTextField();
        busquedaNom = new javax.swing.JTextField();
        busquedaCat = new javax.swing.JTextField();
        busquedaPre = new javax.swing.JTextField();
        busquedaStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        busCod = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        insertarProd = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        anadirCod = new javax.swing.JTextField();
        anadirNom = new javax.swing.JTextField();
        anadirCat = new javax.swing.JTextField();
        anadirPre = new javax.swing.JTextField();
        anadirStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tInsert = new javax.swing.JTable();
        anadir = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        cargaImagen = new javax.swing.JLabel();
        buscarImagen = new javax.swing.JButton();
        eliminarProd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDelete = new javax.swing.JTable();
        eliminar = new javax.swing.JButton();
        todos = new javax.swing.JButton();
        buscardelete = new javax.swing.JTextField();
        buscarDelete = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        fondoStock2 = new javax.swing.JLabel();
        menubarOpc = new javax.swing.JMenuBar();
        menuVer = new javax.swing.JMenu();
        itemProd = new javax.swing.JMenuItem();
        menuItemCat = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
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
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        JPanel.add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 90, 70));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        opcCat.addTab("tab1", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        opcCat.addTab("tab2", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        opcCat.addTab("tab3", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        opcCat.addTab("tab4", jPanel4);

        JPanel.add(opcCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 720, 540));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Categoría:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("CARACTERÍSTICAS:");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("€");

        jLabel10.setText("ud/s");

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buscarProdLayout = new javax.swing.GroupLayout(buscarProd);
        buscarProd.setLayout(buscarProdLayout);
        buscarProdLayout.setHorizontalGroup(
            buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarProdLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busquedaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busquedaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busquedaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(254, 254, 254)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(buscarProdLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(busCod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modificar)
                                    .addComponent(bBuscar))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        buscarProdLayout.setVerticalGroup(
            buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarProdLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(busquedaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(busquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(busquedaCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(busquedaPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buscarProdLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(buscarProdLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(imagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(busCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(27, 27, 27)
                .addComponent(modificar)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        opcProd.addTab("Buscar", buscarProd);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Código:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Categoría:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Precio:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Stock:");

        tInsert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoría"
            }
        ));
        jScrollPane1.setViewportView(tInsert);

        anadir.setText("Añadir");
        anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        buscarImagen.setText("Examinar");
        buscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insertarProdLayout = new javax.swing.GroupLayout(insertarProd);
        insertarProd.setLayout(insertarProdLayout);
        insertarProdLayout.setHorizontalGroup(
            insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(insertarProdLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(31, 31, 31)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(anadirCod, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(anadirNom)
                            .addComponent(anadirCat)
                            .addComponent(anadirPre)
                            .addComponent(anadirStock)))
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addComponent(anadir)
                        .addGap(18, 18, 18)
                        .addComponent(borrar)))
                .addGap(92, 92, 92)
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarImagen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        insertarProdLayout.setVerticalGroup(
            insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertarProdLayout.createSequentialGroup()
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertarProdLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cargaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(anadirCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(anadirNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(anadirCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anadirPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(anadirStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anadir)
                    .addComponent(borrar)
                    .addComponent(buscarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        opcProd.addTab("Nuevo Registro", insertarProd);

        tablaDelete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoría"
            }
        ));
        jScrollPane2.setViewportView(tablaDelete);

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        todos.setText("Todos los productos");
        todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosActionPerformed(evt);
            }
        });

        buscarDelete.setText("Buscar");
        buscarDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDeleteActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Introduce el código:");

        javax.swing.GroupLayout eliminarProdLayout = new javax.swing.GroupLayout(eliminarProd);
        eliminarProd.setLayout(eliminarProdLayout);
        eliminarProdLayout.setHorizontalGroup(
            eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarProdLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(todos)
                    .addComponent(buscardelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );
        eliminarProdLayout.setVerticalGroup(
            eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarProdLayout.createSequentialGroup()
                .addGroup(eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarProdLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(todos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscardelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buscarDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar))
                    .addGroup(eliminarProdLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        opcProd.addTab("Eliminar", eliminarProd);

        JPanel.add(opcProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 720, 540));
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
        menuItemCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/cat2.png"))); // NOI18N
        menuItemCat.setText("Categorías");
        menuItemCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCatActionPerformed(evt);
            }
        });
        menuVer.add(menuItemCat);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/cliente.png"))); // NOI18N
        jMenu1.setText("Clientes");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/nuevoCli.png"))); // NOI18N
        jMenuItem1.setText("Nuevo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/verCli.png"))); // NOI18N
        jMenuItem2.setText("Ver");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/modificarCli.png"))); // NOI18N
        jMenuItem3.setText("Modificar");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/eliminarCli2.png"))); // NOI18N
        jMenuItem4.setText("Eliminar");
        jMenu1.add(jMenuItem4);

        menuVer.add(jMenu1);

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
        opcProd.setVisible(true); 
        opcCat.setVisible(false);
    }//GEN-LAST:event_itemProdActionPerformed

    private void bEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmpleadosActionPerformed
        v.setVisible(true);
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

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        p.visualizarTablaDeletes();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        p.modificarProductos();
    }//GEN-LAST:event_modificarActionPerformed

    private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
        try {
            p.insertarProductos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anadirActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        anadirCod.setText("");
        anadirNom.setText("");
        anadirCat.setText("");
        anadirPre.setText("");
        anadirStock.setText("");
    }//GEN-LAST:event_borrarActionPerformed

    private void buscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarImagenActionPerformed

        //ruta = cargarImagen.getSelectedFile().getAbsolutePath();

        int resultado;

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        cargarImagen.setFileFilter(filter);
        resultado = cargarImagen.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            File fichero = cargarImagen.getSelectedFile();
        }
        try{
            ImageIcon icon = new ImageIcon(fichero.toString());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(cargaImagen.getWidth(),cargaImagen.getHeight(),Image.SCALE_DEFAULT));
            cargaImagen.setText(null);
            cargaImagen.setIcon(icono);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
        }
    }//GEN-LAST:event_buscarImagenActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        p.eliminarProductos();
    }//GEN-LAST:event_eliminarActionPerformed

    private void todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosActionPerformed
        p.visualizarTablaDeletes();
    }//GEN-LAST:event_todosActionPerformed

    private void buscarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDeleteActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        tablaDelete.setModel(modelo);
        String cod = buscardelete.getText();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo WHERE idarticulo= '" + cod + "'");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            tablaDelete.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }
    }//GEN-LAST:event_buscarDeleteActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_bSalirActionPerformed

    private void menuItemCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCatActionPerformed
        opcCat.setVisible(true);
        opcProd.setVisible(false); 
    }//GEN-LAST:event_menuItemCatActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton anadir;
    public static javax.swing.JTextField anadirCat;
    public static javax.swing.JTextField anadirCod;
    public static javax.swing.JTextField anadirNom;
    public static javax.swing.JTextField anadirPre;
    public static javax.swing.JTextField anadirStock;
    private javax.swing.JButton bAdminUsers;
    private javax.swing.JButton bArqueo;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCobrar;
    private javax.swing.JButton bEmpleados;
    private javax.swing.JButton bPresupuesto;
    private javax.swing.JButton bReparar;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bTiendaOn;
    private javax.swing.JButton borrar;
    public static javax.swing.JTextField busCod;
    private javax.swing.JButton buscarDelete;
    private javax.swing.JButton buscarImagen;
    private javax.swing.JPanel buscarProd;
    private javax.swing.JTextField buscardelete;
    public static javax.swing.JTextField busquedaCat;
    public static javax.swing.JTextField busquedaCod;
    public static javax.swing.JTextField busquedaNom;
    public static javax.swing.JTextField busquedaPre;
    public static javax.swing.JTextField busquedaStock;
    public static javax.swing.JLabel cargaImagen;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel eliminarProd;
    public static javax.swing.JLabel fondoStock2;
    public static javax.swing.JLabel imagen;
    private javax.swing.JPanel insertarProd;
    private javax.swing.JMenuItem itemProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lConectUser;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lTipo;
    public static javax.swing.JLabel lTipoCUser;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JMenuItem menuItemCat;
    private javax.swing.JMenu menuVer;
    private javax.swing.JMenuBar menubarOpc;
    private javax.swing.JButton modificar;
    private javax.swing.JTabbedPane opcCat;
    private javax.swing.JTabbedPane opcProd;
    public static javax.swing.JTable tInsert;
    public static javax.swing.JTable tablaDelete;
    private javax.swing.JButton todos;
    private javax.swing.JToolBar toolBarDate;
    // End of variables declaration//GEN-END:variables

    
}
