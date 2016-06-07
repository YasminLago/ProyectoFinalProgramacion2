package com.yasmin.ventanas;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.yasmin.bd.ConexionBD;
import com.yasmin.clases.Categorias;
import com.yasmin.clases.Productos;
import static com.yasmin.ventanas.BuscarImagen.cargarImagen;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public final class Stock2 extends javax.swing.JFrame implements Runnable {
    
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    Caja c = new Caja();
    ArqueoCaja ac = new ArqueoCaja();
    VUsuarios u = new VUsuarios();
    VEmpleados v = new VEmpleados();
    TextAutoCompleter textAutoAcompleter;
    Productos p = new Productos();
    DefaultTableModel modelo = new DefaultTableModel();
    BuscarImagen b = new BuscarImagen();
    Categorias cat = new Categorias();
    
    Thread hilo;
    int numDia = 0;
    int numMes = 0;
    String date, year, dia, mes, hora, minutos, segundos;
    
    public String ruta;
    
    String[] day = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miércoles",
        "Jueves",
        "Viernes",
        "Sábado"
    };
    
    String[] month = {
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
    
    public Stock2() {
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
        
        tablaDelete.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaDelete.getColumnModel().getColumn(2).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(3).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        busquedaCod.setEditable(false);
        busquedaNom.setEditable(false);
        busquedaPre.setEditable(false);
        busquedaStock.setEditable(false);
        busquedaCat.setEditable(false);
        
        bExaminar.setEnabled(false);
        bGuardar.setEnabled(false);
        
        p.llenarAñadirCat();
        p.visualizaTablaInsercion();
        
        cat.visualizaTablaCategorias();
        
        bEliminarCat.setEnabled(false);
        bModificarCat.setEnabled(false);
        bGuardarAñadirCat.setEnabled(false);
        bAñadirCat.setEnabled(true);
        bGuardarModCat.setEnabled(false);
        
        nomCat.setEditable(false);
        codCat.setEditable(false);
        
        bPresupuesto.setEnabled(false);
        bReparar.setEnabled(false);
        bTiendaOn.setEnabled(false);
        menuClientes.setEnabled(false);
        
    }

    /**
     * Marca o desmarca botones en función del tipo de usuario conectado y
     * cambia la imagen de fondo
     */
    public void privilegios() {
        if (tipoUser.getSelectedItem().equals("Empleado")) {
            bEmpleados.setEnabled(false);
            bAdminUsers.setEnabled(false);
            fondoStock2.setIcon(new ImageIcon(getClass().getResource("/com/yasmin/imagenes/empleado.jpg")));
        } else if (tipoUser.getSelectedItem().equals("Administrador")) {
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
        while (ct == hilo) {
            fecha();
            lDate.setText(day[numDia - 1] + ", " + date + " de " + month[numMes] + " de " + year + " " + hora + ":" + minutos + ":" + segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
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
        numDia = 0;
        Calendar cal = Calendar.getInstance();
        numDia = cal.get(Calendar.DAY_OF_WEEK);
        
        Calendar c = Calendar.getInstance();
        numMes = c.get(Calendar.MONTH);
        
        date = calendario.get(Calendar.DAY_OF_MONTH) > 9 ? "" + calendario.get(Calendar.DAY_OF_MONTH) : "0" + calendario.get(Calendar.DAY_OF_MONTH);
        year = calendario.get(Calendar.YEAR) > 9 ? "" + calendario.get(Calendar.YEAR) : "0" + calendario.get(Calendar.YEAR);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
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
        opcCat = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tCategorias = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        codCat = new javax.swing.JTextField();
        nomCat = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        bAñadirCat = new javax.swing.JButton();
        bGuardarAñadirCat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bModificarCat = new javax.swing.JButton();
        bEliminarCat = new javax.swing.JButton();
        bGuardarModCat = new javax.swing.JButton();
        bCerrarOpcCat = new javax.swing.JButton();
        opcProd = new javax.swing.JTabbedPane();
        buscarProd = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        busCod = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        busquedaCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        busquedaNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        busquedaPre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        busquedaStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        busquedaCat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bExaminar = new javax.swing.JButton();
        imagenBuscar = new javax.swing.JTextField();
        insertarProd = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        anadirCod = new javax.swing.JTextField();
        anadirNom = new javax.swing.JTextField();
        anadirPre = new javax.swing.JTextField();
        anadirStock = new javax.swing.JTextField();
        anadir = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tInsert = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        cargaImagen = new javax.swing.JLabel();
        buscarImagen = new javax.swing.JButton();
        rutaFoto = new javax.swing.JTextField();
        anadirCat = new javax.swing.JComboBox();
        eliminarProd = new javax.swing.JPanel();
        eliminar = new javax.swing.JButton();
        todos = new javax.swing.JButton();
        buscardelete = new javax.swing.JTextField();
        buscarDelete = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDelete = new javax.swing.JTable();
        bCerrarOpcProductos = new javax.swing.JButton();
        fondoStock2 = new javax.swing.JLabel();
        menubarOpc = new javax.swing.JMenuBar();
        menuVer = new javax.swing.JMenu();
        itemProd = new javax.swing.JMenuItem();
        menuItemCat = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenu();
        nuevoCliente = new javax.swing.JMenuItem();
        verClientes = new javax.swing.JMenuItem();
        modificarClientes = new javax.swing.JMenuItem();
        eliminarClientes = new javax.swing.JMenuItem();
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

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        tCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tCategoriasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tCategorias);

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nombre:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Código:");

        bAñadirCat.setText("Añadir");
        bAñadirCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirCatActionPerformed(evt);
            }
        });

        bGuardarAñadirCat.setText("Guardar");
        bGuardarAñadirCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarAñadirCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(bAñadirCat)
                        .addGap(44, 44, 44)
                        .addComponent(bGuardarAñadirCat)
                        .addGap(46, 46, 46))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAñadirCat)
                    .addComponent(bGuardarAñadirCat))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Añadir");

        bModificarCat.setText("Modificar");
        bModificarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarCatActionPerformed(evt);
            }
        });

        bEliminarCat.setText("Eliminar");
        bEliminarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarCatActionPerformed(evt);
            }
        });

        bGuardarModCat.setText("Guardar Modificación");
        bGuardarModCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarModCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(bGuardarModCat, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(bModificarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEliminarCat, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bModificarCat)
                            .addComponent(bEliminarCat))
                        .addGap(32, 32, 32)
                        .addComponent(bGuardarModCat)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        bCerrarOpcCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/aspat.png"))); // NOI18N
        bCerrarOpcCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarOpcCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(658, 658, 658)
                        .addComponent(bCerrarOpcCat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bCerrarOpcCat)
                .addGap(27, 27, 27)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        opcCat.addTab("Administrar categorías", jPanel1);

        JPanel.add(opcCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 720, 540));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar :");

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Categoría:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Precio:");

        jLabel9.setText("€");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Stock:");

        jLabel10.setText("ud/s");

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(busquedaCod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(busquedaPre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addComponent(busquedaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(modificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bGuardar)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(busquedaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(busquedaNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(busquedaCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(busquedaPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(busquedaStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar)
                    .addComponent(bGuardar))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("CARACTERÍSTICAS");

        bExaminar.setText("Examinar");
        bExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExaminarActionPerformed(evt);
            }
        });

        imagenBuscar.setForeground(new java.awt.Color(255, 255, 255));
        imagenBuscar.setText("jTextField1");

        javax.swing.GroupLayout buscarProdLayout = new javax.swing.GroupLayout(buscarProd);
        buscarProd.setLayout(buscarProdLayout);
        buscarProdLayout.setHorizontalGroup(
            buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarProdLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bExaminar))
                        .addGap(75, 75, 75))
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBuscar)
                            .addComponent(busCod, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(buscarProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buscarProdLayout.setVerticalGroup(
            buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarProdLayout.createSequentialGroup()
                .addGroup(buscarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscarProdLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscarProdLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bExaminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(busCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(bBuscar)
                .addGap(53, 53, 53)
                .addComponent(imagenBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));

        tInsert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoría"
            }
        ));
        jScrollPane1.setViewportView(tInsert);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));

        buscarImagen.setText("Examinar");
        buscarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(buscarImagen)
                        .addGap(113, 113, 113)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cargaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(buscarImagen)
                .addContainerGap())
        );

        rutaFoto.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout insertarProdLayout = new javax.swing.GroupLayout(insertarProd);
        insertarProd.setLayout(insertarProdLayout);
        insertarProdLayout.setHorizontalGroup(
            insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertarProdLayout.createSequentialGroup()
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(insertarProdLayout.createSequentialGroup()
                                .addComponent(anadir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(borrar))
                            .addGroup(insertarProdLayout.createSequentialGroup()
                                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(31, 31, 31)
                                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(anadirPre)
                                    .addComponent(anadirStock)
                                    .addComponent(anadirCat, 0, 141, Short.MAX_VALUE)
                                    .addComponent(anadirCod)
                                    .addComponent(anadirNom))))
                        .addGap(82, 82, 82)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertarProdLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        insertarProdLayout.setVerticalGroup(
            insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertarProdLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(insertarProdLayout.createSequentialGroup()
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
                        .addGap(28, 28, 28)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(anadirStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(insertarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anadir)
                            .addComponent(borrar)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rutaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        opcProd.addTab("Nuevo Registro", insertarProd);

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

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 1, true));

        tablaDelete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio", "Stock", "Categoría"
            }
        ));
        jScrollPane2.setViewportView(tablaDelete);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        bCerrarOpcProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/aspat.png"))); // NOI18N
        bCerrarOpcProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarOpcProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eliminarProdLayout = new javax.swing.GroupLayout(eliminarProd);
        eliminarProd.setLayout(eliminarProdLayout);
        eliminarProdLayout.setHorizontalGroup(
            eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarProdLayout.createSequentialGroup()
                        .addGroup(eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(todos)
                            .addComponent(buscardelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eliminarProdLayout.createSequentialGroup()
                        .addComponent(bCerrarOpcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        eliminarProdLayout.setVerticalGroup(
            eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarProdLayout.createSequentialGroup()
                .addGroup(eliminarProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarProdLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eliminarProdLayout.createSequentialGroup()
                        .addComponent(bCerrarOpcProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(todos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscardelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(buscarDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminar)))
                .addContainerGap(59, Short.MAX_VALUE))
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

        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/cliente.png"))); // NOI18N
        menuClientes.setText("Clientes");

        nuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/nuevoCli.png"))); // NOI18N
        nuevoCliente.setText("Nuevo");
        nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoClienteActionPerformed(evt);
            }
        });
        menuClientes.add(nuevoCliente);

        verClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/verCli.png"))); // NOI18N
        verClientes.setText("Ver");
        menuClientes.add(verClientes);

        modificarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/modificarCli.png"))); // NOI18N
        modificarClientes.setText("Modificar");
        menuClientes.add(modificarClientes);

        eliminarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/eliminarCli2.png"))); // NOI18N
        eliminarClientes.setText("Eliminar");
        menuClientes.add(eliminarClientes);

        menuVer.add(menuClientes);

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
        try {
            p.listaProductos();
        } catch (SQLException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        
        busquedaCod.setEditable(true);
        busquedaNom.setEditable(true);
        busquedaPre.setEditable(true);
        busquedaStock.setEditable(true);
        busquedaCat.setEditable(true);
        
        bExaminar.setEnabled(true);
        modificar.setEnabled(false);
        bGuardar.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
        try {
            p.insertarProductos();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_anadirActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        anadirCod.setText("");
        anadirNom.setText("");
        
        anadirPre.setText("");
        anadirStock.setText("");
        cargaImagen.setIcon(null);
    }//GEN-LAST:event_borrarActionPerformed

    private void buscarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarImagenActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        cargarImagen.setFileFilter(filter);//Llama al método
        int resultado = cargarImagen.showOpenDialog(this);//Se abre la ventana del diálogo para escoger imagenes
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String selectFile = cargarImagen.getSelectedFile().getPath();//Obtiene el nombre del archivo que se ha seleccionado
            String saveFile = cargarImagen.getSelectedFile().toString();//Obtiene la dirección donde se garda la imagen
            cargaImagen.setIcon(new ImageIcon(selectFile));
            
            ImageIcon icon = new ImageIcon(selectFile);
            Image img = icon.getImage();
            ImageIcon newIcon = new ImageIcon(img);
            cargaImagen.setIcon(newIcon);
            rutaFoto.setText(selectFile);
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
            ResultSet rs = st.executeQuery("SELECT codp,nomp,precio,stock,nomc FROM productos p, categorias c WHERE p.codc=c.codc AND codp='" + cod + "'");
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

    private void nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevoClienteActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        p.modificarProductos();
        modificar.setEnabled(true);
        bGuardar.setEnabled(false);
        bExaminar.setEnabled(false);
        
        busquedaCod.setEditable(false);
        busquedaNom.setEditable(false);
        busquedaPre.setEditable(false);
        busquedaStock.setEditable(false);
        busquedaCat.setEditable(false);
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExaminarActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        cargarImagen.setFileFilter(filter);//Llama al método
        int resultado = cargarImagen.showOpenDialog(this);//Se abre la ventana del diálogo para escoger imagenes
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String selectFile = cargarImagen.getSelectedFile().getPath();//Obtiene el nombre del archivo que se ha seleccionado
            String saveFile = cargarImagen.getSelectedFile().toString();//Obtiene la dirección donde se garda la imagen
            imagen.setIcon(new ImageIcon(selectFile));
            
            ImageIcon icon = new ImageIcon(selectFile);
            Image img = icon.getImage();
            ImageIcon newIcon = new ImageIcon(img);
            imagen.setIcon(newIcon);
            imagenBuscar.setText(selectFile);
        }
    }//GEN-LAST:event_bExaminarActionPerformed

    private void bCerrarOpcProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarOpcProductosActionPerformed
        opcProd.setVisible(false);
    }//GEN-LAST:event_bCerrarOpcProductosActionPerformed

    private void bCerrarOpcCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarOpcCatActionPerformed
        opcCat.setVisible(false);
    }//GEN-LAST:event_bCerrarOpcCatActionPerformed

    private void bGuardarModCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarModCatActionPerformed
        cat.modificarCategorias();
        
        bModificarCat.setEnabled(true);
        bGuardarModCat.setEnabled(false);
        codCat.setEditable(false);
        nomCat.setEditable(false);
    }//GEN-LAST:event_bGuardarModCatActionPerformed

    private void bGuardarAñadirCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarAñadirCatActionPerformed
        try {
            cat.insertarCategorias();
        } catch (SQLException ex) {
            Logger.getLogger(Stock2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bGuardarAñadirCat.setEnabled(false);
        
        codCat.setEditable(false);
        nomCat.setEditable(false);
        
        bModificarCat.setEnabled(true);
    }//GEN-LAST:event_bGuardarAñadirCatActionPerformed

    private void bAñadirCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirCatActionPerformed
        nomCat.setEditable(true);
        codCat.setEditable(true);
        
        nomCat.setText("");
        codCat.setText("");
        
        bGuardarAñadirCat.setEnabled(true);
        bGuardarModCat.setEnabled(false);
        bAñadirCat.setEnabled(false);
        bModificarCat.setEnabled(false);
        bEliminarCat.setEnabled(false);
    }//GEN-LAST:event_bAñadirCatActionPerformed

    private void bModificarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarCatActionPerformed
        nomCat.setEditable(true);
        codCat.setEditable(true);
        
        bGuardarModCat.setEnabled(true);
        bEliminarCat.setEnabled(false);
        bModificarCat.setEnabled(false);
        bGuardarAñadirCat.setEnabled(false);        
    }//GEN-LAST:event_bModificarCatActionPerformed

    private void bEliminarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarCatActionPerformed
        cat.eliminarCategorias();
        
        bEliminarCat.setEnabled(false);
        bModificarCat.setEnabled(false);
        
        nomCat.setText("");
        codCat.setText("");
    }//GEN-LAST:event_bEliminarCatActionPerformed

    private void tCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCategoriasMouseClicked
        int row = tCategorias.rowAtPoint(evt.getPoint());
        codCat.setText(tCategorias.getModel().getValueAt(row, 0).toString());
        nomCat.setText(tCategorias.getModel().getValueAt(row, 1).toString());
        
        bModificarCat.setEnabled(true);
        bEliminarCat.setEnabled(true);
    }//GEN-LAST:event_tCategoriasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton anadir;
    public static javax.swing.JComboBox anadirCat;
    public static javax.swing.JTextField anadirCod;
    public static javax.swing.JTextField anadirNom;
    public static javax.swing.JTextField anadirPre;
    public static javax.swing.JTextField anadirStock;
    private javax.swing.JButton bAdminUsers;
    private javax.swing.JButton bArqueo;
    private javax.swing.JButton bAñadirCat;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bCerrarOpcCat;
    private javax.swing.JButton bCerrarOpcProductos;
    private javax.swing.JButton bCobrar;
    private javax.swing.JButton bEliminarCat;
    private javax.swing.JButton bEmpleados;
    private javax.swing.JButton bExaminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bGuardarAñadirCat;
    private javax.swing.JButton bGuardarModCat;
    private javax.swing.JButton bModificarCat;
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
    public static javax.swing.JTextField codCat;
    private javax.swing.JButton eliminar;
    private javax.swing.JMenuItem eliminarClientes;
    private javax.swing.JPanel eliminarProd;
    public static javax.swing.JLabel fondoStock2;
    public static javax.swing.JLabel imagen;
    public static javax.swing.JTextField imagenBuscar;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lConectUser;
    private javax.swing.JLabel lDate;
    private javax.swing.JLabel lTipo;
    public static javax.swing.JLabel lTipoCUser;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenuItem menuItemCat;
    private javax.swing.JMenu menuVer;
    private javax.swing.JMenuBar menubarOpc;
    private javax.swing.JButton modificar;
    private javax.swing.JMenuItem modificarClientes;
    public static javax.swing.JTextField nomCat;
    private javax.swing.JMenuItem nuevoCliente;
    private javax.swing.JTabbedPane opcCat;
    private javax.swing.JTabbedPane opcProd;
    public static javax.swing.JTextField rutaFoto;
    public static javax.swing.JTable tCategorias;
    public static javax.swing.JTable tInsert;
    public static javax.swing.JTable tablaDelete;
    private javax.swing.JButton todos;
    private javax.swing.JToolBar toolBarDate;
    private javax.swing.JMenuItem verClientes;
    // End of variables declaration//GEN-END:variables

}
