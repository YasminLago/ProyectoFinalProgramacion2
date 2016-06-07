package com.yasmin.ventanas;

/**
 *
 * @author Yasmín
 */
public class ArqueoCaja extends javax.swing.JFrame {

    String totalMonedas = null;
    String totalBilletes = null;
    String totalSuma = null;

    public ArqueoCaja() {
        initComponents();
        this.setLocationRelativeTo(null);//Ventana centrada
        totalM1.setEditable(false);
        totalM2.setEditable(false);
        totalM5.setEditable(false);
        totalM10.setEditable(false);
        totalM20.setEditable(false);
        totalM50.setEditable(false);
        totalM1e.setEditable(false);
        totalM2e.setEditable(false);
        totalB5.setEditable(false);
        totalB10.setEditable(false);
        totalB20.setEditable(false);
        totalB50.setEditable(false);
        totalB100.setEditable(false);
        totalB200.setEditable(false);
        totalB500.setEditable(false);

        sumImporteM.setEditable(false);
        sumImporteB.setEditable(false);
        sumTotal.setEditable(false);

        cantidadM1.setText("0");
        cantidadM2.setText("0");
        cantidadM5.setText("0");
        cantidadM10.setText("0");
        cantidadM20.setText("0");
        cantidadM50.setText("0");
        cantidadM1e.setText("0");
        cantidadM2e.setText("0");
        cantidadB5.setText("0");
        cantidadB10.setText("0");
        cantidadB20.setText("0");
        cantidadB50.setText("0");
        cantidadB100.setText("0");
        cantidadB200.setText("0");
        cantidadB500.setText("0");
    }

    /*public void focusGained(java.awt.event.FocusEvent evt){
     Object o = evt.getSource();
     if(o instanceof javax.swing.JTextField){
     javax.swing.JTextField txt = (javax.swing.JTextField) o;
     txt.setSelectionStart(0);
     txt.setSelectionEnd(txt.getText().length());
     }
     }
    
     */
    /**
     * Calcula el arqueo total de la caja
     */
    public void calcularArqueo() {
        int m1 = Integer.parseInt(cantidadM1.getText());
        int m2 = Integer.parseInt(cantidadM2.getText());
        int m5 = Integer.parseInt(cantidadM5.getText());
        int m10 = Integer.parseInt(cantidadM10.getText());
        int m20 = Integer.parseInt(cantidadM20.getText());
        int m50 = Integer.parseInt(cantidadM50.getText());
        int m1e = Integer.parseInt(cantidadM1e.getText());
        int m2e = Integer.parseInt(cantidadM2e.getText());
        int b5 = Integer.parseInt(cantidadB5.getText());
        int b10 = Integer.parseInt(cantidadB10.getText());
        int b20 = Integer.parseInt(cantidadB20.getText());
        int b50 = Integer.parseInt(cantidadB50.getText());
        int b100 = Integer.parseInt(cantidadB100.getText());
        int b200 = Integer.parseInt(cantidadB200.getText());
        int b500 = Integer.parseInt(cantidadB500.getText());

        double cm1 = m1 * 0.01;
        double cm2 = m2 * 0.02;
        double cm5 = m5 * 0.05;
        double cm10 = m10 * 0.10;
        double cm20 = m20 * 0.20;
        double cm50 = m50 * 0.50;
        double cm1e = m1e * 1.00;
        double cm2e = m2e * 2.00;
        double cb5 = b5 * 5.00;
        double cb10 = b10 * 10.00;
        double cb20 = b20 * 20.00;
        double cb50 = b50 * 50.00;
        double cb100 = b100 * 100.00;
        double cb200 = b200 * 200.00;
        double cb500 = b500 * 500.00;

        totalM1.setText(Double.toString(cm1));
        totalM2.setText(Double.toString(cm2));
        totalM5.setText(Double.toString(cm5));
        totalM10.setText(Double.toString(cm10));
        totalM20.setText(Double.toString(cm20));
        totalM50.setText(Double.toString(cm50));
        totalM1e.setText(Double.toString(cm1e));
        totalM2e.setText(Double.toString(cm2e));
        totalB5.setText(Double.toString(cb5));
        totalB10.setText(Double.toString(cb10));
        totalB20.setText(Double.toString(cb20));
        totalB50.setText(Double.toString(cb50));
        totalB100.setText(Double.toString(cb100));
        totalB200.setText(Double.toString(cb200));
        totalB500.setText(Double.toString(cb500));

        /**
         * Suma la cantidad en € de todas las monedas
         */
        Double[] sumMonedas = {cm1, cm2, cm5, cm10, cm20, cm50, cm1e, cm2e};
        double sumaM = 0;
        for (int i = 0; i < sumMonedas.length; i++) {
            sumaM += sumMonedas[i];
            totalMonedas = Double.toString(sumaM);
        }
        sumImporteM.setText(totalMonedas);

        /**
         * Suma la cantidad en € de todas los billetes
         */
        Double[] sumBilletes = {cb5, cb10, cb20, cb50, cb100, cb200, cb500};
        double sumaB = 0;
        for (int i = 0; i < sumBilletes.length; i++) {
            sumaB += sumBilletes[i];
            totalBilletes = Double.toString(sumaB);
        }
        sumImporteB.setText(totalBilletes);

        /**
         * Total arqueo
         */
        double sumaTotal = sumaM + sumaB;
        totalSuma = Double.toString(sumaTotal);
        sumTotal.setText(totalSuma);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelArqueo = new javax.swing.JPanel();
        unCent = new javax.swing.JLabel();
        dosCent = new javax.swing.JLabel();
        cincoCent = new javax.swing.JLabel();
        diezCent = new javax.swing.JLabel();
        veinteCent = new javax.swing.JLabel();
        cincuentaCent = new javax.swing.JLabel();
        unEuro = new javax.swing.JLabel();
        dosEuros = new javax.swing.JLabel();
        img1cent = new javax.swing.JLabel();
        img2cent = new javax.swing.JLabel();
        img5cent = new javax.swing.JLabel();
        img10cent = new javax.swing.JLabel();
        img20cent = new javax.swing.JLabel();
        img50cent = new javax.swing.JLabel();
        img1e = new javax.swing.JLabel();
        img2e = new javax.swing.JLabel();
        cantidadM1 = new javax.swing.JTextField();
        totalM1 = new javax.swing.JTextField();
        cantidadM2 = new javax.swing.JTextField();
        totalM2 = new javax.swing.JTextField();
        cantidadM5 = new javax.swing.JTextField();
        totalM5 = new javax.swing.JTextField();
        cantidadM10 = new javax.swing.JTextField();
        totalM10 = new javax.swing.JTextField();
        cantidadM20 = new javax.swing.JTextField();
        totalM20 = new javax.swing.JTextField();
        cantidadM50 = new javax.swing.JTextField();
        totalM50 = new javax.swing.JTextField();
        cantidadM1e = new javax.swing.JTextField();
        totalM1e = new javax.swing.JTextField();
        cantidadM2e = new javax.swing.JTextField();
        totalM2e = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        img5e = new javax.swing.JLabel();
        img10e = new javax.swing.JLabel();
        img50e = new javax.swing.JLabel();
        img20e = new javax.swing.JLabel();
        img100e = new javax.swing.JLabel();
        img200e = new javax.swing.JLabel();
        img500e = new javax.swing.JLabel();
        cantidadB5 = new javax.swing.JTextField();
        totalB5 = new javax.swing.JTextField();
        cantidadB10 = new javax.swing.JTextField();
        totalB10 = new javax.swing.JTextField();
        cantidadB20 = new javax.swing.JTextField();
        totalB20 = new javax.swing.JTextField();
        cantidadB50 = new javax.swing.JTextField();
        totalB50 = new javax.swing.JTextField();
        totalB100 = new javax.swing.JTextField();
        cantidadB100 = new javax.swing.JTextField();
        cantidadB200 = new javax.swing.JTextField();
        totalB200 = new javax.swing.JTextField();
        cantidadB500 = new javax.swing.JTextField();
        totalB500 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        totalImpMon = new javax.swing.JLabel();
        totalImpBill = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        sumImporteM = new javax.swing.JTextField();
        sumImporteB = new javax.swing.JTextField();
        sumTotal = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        bPonerACero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        unCent.setText("1 céntimo");

        dosCent.setText(" 2 céntimos");

        cincoCent.setText("  5 céntimos");

        diezCent.setText(" 10 céntimos");

        veinteCent.setText("  20 céntimos");

        cincuentaCent.setText("   50 céntimos");

        unEuro.setText("      1 euro");

        dosEuros.setText("      2 euros");

        img1cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/1cent.png"))); // NOI18N

        img2cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/2cent.png"))); // NOI18N

        img5cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/5cent.png"))); // NOI18N

        img10cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/10cent.png"))); // NOI18N

        img20cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/20cent.png"))); // NOI18N

        img50cent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/50cent.png"))); // NOI18N

        img1e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/1e.png"))); // NOI18N

        img2e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/2e.png"))); // NOI18N

        jLabel1.setText("€");

        jLabel2.setText("€");

        jLabel3.setText("€");

        jLabel4.setText("€");

        jLabel5.setText("€");

        jLabel6.setText("€");

        jLabel7.setText("€");

        jLabel8.setText("€");

        img5e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/5e.png"))); // NOI18N

        img10e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/10e.png"))); // NOI18N

        img50e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/50e.png"))); // NOI18N

        img20e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/20e.png"))); // NOI18N

        img100e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/100e.png"))); // NOI18N

        img200e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/200e.png"))); // NOI18N

        img500e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/yasmin/imagenes/500e.png"))); // NOI18N

        jLabel16.setText("€");

        jLabel17.setText("€");

        jLabel18.setText("€");

        jLabel19.setText("€");

        jLabel20.setText("€");

        jLabel21.setText("€");

        jLabel22.setText("€");

        jLabel23.setText("€");

        jLabel24.setText("€");

        jLabel25.setText("€");

        jLabel26.setText("5 euros");

        jLabel27.setText("10 euros");

        jLabel28.setText("20 euros");

        jLabel29.setText("50 euros");

        jLabel30.setText("100 euros");

        jLabel31.setText("200 euros");

        jLabel32.setText("500 euros");

        totalImpMon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalImpMon.setText("Total importe monedas:");

        totalImpBill.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalImpBill.setText("Total importe billetes:");

        total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        total.setText("TOTAL:");

        bAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bAceptar.setForeground(new java.awt.Color(0, 153, 0));
        bAceptar.setText("Aceptar");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bSalir.setForeground(new java.awt.Color(255, 0, 0));
        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bPonerACero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bPonerACero.setForeground(new java.awt.Color(0, 153, 153));
        bPonerACero.setText("Poner a cero");
        bPonerACero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPonerACeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelArqueoLayout = new javax.swing.GroupLayout(panelArqueo);
        panelArqueo.setLayout(panelArqueoLayout);
        panelArqueoLayout.setHorizontalGroup(
            panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArqueoLayout.createSequentialGroup()
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel26))
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addComponent(totalB5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addComponent(cantidadB5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(139, 139, 139)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addComponent(totalB10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel18)
                                .addGap(102, 102, 102)
                                .addComponent(totalB20, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addComponent(cantidadB10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(cantidadB20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cantidadB50, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalB50, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addGap(43, 43, 43))
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel27)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(103, 103, 103))))
            .addGroup(panelArqueoLayout.createSequentialGroup()
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(img5e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img20e)
                        .addGap(48, 48, 48)
                        .addComponent(img50e))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelArqueoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(img10e)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalM1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadM1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel8)
                                        .addGap(14, 14, 14)
                                        .addComponent(totalM2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img1cent)
                                            .addComponent(unCent, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img2cent)
                                            .addComponent(dosCent, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadM2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadM5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cincoCent, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalM5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(img5cent))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cantidadM10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalM10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(img10cent))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(diezCent, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadM20, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                                .addComponent(totalM20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addGap(20, 20, 20)
                                                .addComponent(totalM50, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel1))
                                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(img20cent)
                                                    .addComponent(veinteCent, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(img50cent)
                                                    .addComponent(cantidadM50, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cincuentaCent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(14, 14, 14)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                                .addComponent(totalM1e, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6))
                                            .addComponent(unEuro, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadM1e, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(img1e))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(img2e)
                                            .addComponent(cantidadM2e, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dosEuros, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalM2e, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18))
            .addGroup(panelArqueoLayout.createSequentialGroup()
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalImpBill)
                            .addComponent(totalImpMon)
                            .addComponent(total))
                        .addGap(44, 44, 44)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sumImporteM)
                            .addComponent(sumImporteB)
                            .addComponent(sumTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArqueoLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31)
                                .addGap(170, 170, 170))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArqueoLayout.createSequentialGroup()
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalB100, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadB100, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cantidadB200, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalB200, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addComponent(bSalir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bPonerACero)
                                        .addGap(157, 157, 157)))
                                .addComponent(jLabel21)
                                .addGap(122, 122, 122))
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bAceptar)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addComponent(img100e)
                                        .addGap(46, 46, 46)
                                        .addComponent(img200e)))))
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(img500e)
                                .addGroup(panelArqueoLayout.createSequentialGroup()
                                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalB500, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cantidadB500, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)
                                    .addGap(41, 41, 41)))
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jLabel32)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelArqueoLayout.setVerticalGroup(
            panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArqueoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img5cent)
                    .addComponent(img10cent, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img20cent, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img50cent)
                    .addComponent(img1e)
                    .addComponent(img2cent)
                    .addComponent(img1cent)
                    .addComponent(img2e, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unCent)
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dosCent, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cincoCent)
                            .addComponent(diezCent)
                            .addComponent(veinteCent)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cincuentaCent)
                        .addComponent(unEuro)
                        .addComponent(dosEuros)))
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cantidadM1e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cantidadM50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cantidadM2e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadM10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadM20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addComponent(totalM20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalM1e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(totalM2e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(totalM10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(totalM50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(totalM5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelArqueoLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(img5e))
                        .addComponent(img50e))
                    .addComponent(img20e)
                    .addComponent(img10e))
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)))
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cantidadB50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidadB20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidadB10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cantidadB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalB10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(totalB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalB20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalB50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addGap(35, 35, 35)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img100e)
                    .addComponent(img200e)
                    .addComponent(img500e))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArqueoLayout.createSequentialGroup()
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(cantidadB500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(totalB500, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)
                                            .addComponent(totalB200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21)))
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cantidadB100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cantidadB200, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(totalB100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(69, 69, 69)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalImpMon)
                                    .addComponent(sumImporteM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addGap(28, 28, 28)
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalImpBill)
                                    .addComponent(sumImporteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelArqueoLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(total)
                                            .addComponent(sumTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArqueoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelArqueoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(bAceptar)
                                            .addComponent(bSalir)
                                            .addComponent(bPonerACero))
                                        .addGap(7, 7, 7))))
                            .addGroup(panelArqueoLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel20))))
                    .addComponent(jLabel32))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelArqueo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelArqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        calcularArqueo();
    }//GEN-LAST:event_bAceptarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void bPonerACeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPonerACeroActionPerformed
        totalM1.setText("");
        totalM2.setText("");
        totalM5.setText("");
        totalM10.setText("");
        totalM20.setText("");
        totalM50.setText("");
        totalM1e.setText("");
        totalM2e.setText("");
        totalB5.setText("");
        totalB10.setText("");
        totalB20.setText("");
        totalB50.setText("");
        totalB100.setText("");
        totalB200.setText("");
        totalB500.setText("");

        cantidadM1.setText("");
        cantidadM2.setText("");
        cantidadM5.setText("");
        cantidadM10.setText("");
        cantidadM20.setText("");
        cantidadM50.setText("");
        cantidadM1e.setText("");
        cantidadM2e.setText("");
        cantidadB5.setText("");
        cantidadB10.setText("");
        cantidadB20.setText("");
        cantidadB50.setText("");
        cantidadB100.setText("");
        cantidadB200.setText("");
        cantidadB500.setText("");

        sumImporteM.setText("");
        sumImporteB.setText("");
        sumTotal.setText("");
    }//GEN-LAST:event_bPonerACeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bPonerACero;
    private javax.swing.JButton bSalir;
    public static javax.swing.JTextField cantidadB10;
    public static javax.swing.JTextField cantidadB100;
    public static javax.swing.JTextField cantidadB20;
    public static javax.swing.JTextField cantidadB200;
    public static javax.swing.JTextField cantidadB5;
    public static javax.swing.JTextField cantidadB50;
    public static javax.swing.JTextField cantidadB500;
    public static javax.swing.JTextField cantidadM1;
    public static javax.swing.JTextField cantidadM10;
    public static javax.swing.JTextField cantidadM1e;
    public static javax.swing.JTextField cantidadM2;
    public static javax.swing.JTextField cantidadM20;
    public static javax.swing.JTextField cantidadM2e;
    public static javax.swing.JTextField cantidadM5;
    public static javax.swing.JTextField cantidadM50;
    private javax.swing.JLabel cincoCent;
    private javax.swing.JLabel cincuentaCent;
    private javax.swing.JLabel diezCent;
    private javax.swing.JLabel dosCent;
    private javax.swing.JLabel dosEuros;
    private javax.swing.JLabel img100e;
    private javax.swing.JLabel img10cent;
    private javax.swing.JLabel img10e;
    private javax.swing.JLabel img1cent;
    private javax.swing.JLabel img1e;
    private javax.swing.JLabel img200e;
    private javax.swing.JLabel img20cent;
    private javax.swing.JLabel img20e;
    private javax.swing.JLabel img2cent;
    private javax.swing.JLabel img2e;
    private javax.swing.JLabel img500e;
    private javax.swing.JLabel img50cent;
    private javax.swing.JLabel img50e;
    private javax.swing.JLabel img5cent;
    private javax.swing.JLabel img5e;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelArqueo;
    public static javax.swing.JTextField sumImporteB;
    public static javax.swing.JTextField sumImporteM;
    public static javax.swing.JTextField sumTotal;
    private javax.swing.JLabel total;
    public static javax.swing.JTextField totalB10;
    public static javax.swing.JTextField totalB100;
    public static javax.swing.JTextField totalB20;
    public static javax.swing.JTextField totalB200;
    public static javax.swing.JTextField totalB5;
    public static javax.swing.JTextField totalB50;
    public static javax.swing.JTextField totalB500;
    private javax.swing.JLabel totalImpBill;
    private javax.swing.JLabel totalImpMon;
    public static javax.swing.JTextField totalM1;
    public static javax.swing.JTextField totalM10;
    public static javax.swing.JTextField totalM1e;
    public static javax.swing.JTextField totalM2;
    public static javax.swing.JTextField totalM20;
    public static javax.swing.JTextField totalM2e;
    public static javax.swing.JTextField totalM5;
    public static javax.swing.JTextField totalM50;
    private javax.swing.JLabel unCent;
    private javax.swing.JLabel unEuro;
    private javax.swing.JLabel veinteCent;
    // End of variables declaration//GEN-END:variables
}
