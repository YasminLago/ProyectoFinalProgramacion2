package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Stock.anadirCat;
import static com.yasmin.ventanas.Stock.anadirCod;
import static com.yasmin.ventanas.Stock.anadirNom;
import static com.yasmin.ventanas.Stock.anadirPre;
import static com.yasmin.ventanas.Stock.anadirStock;

import static com.yasmin.ventanas.Stock.busCod;
import static com.yasmin.ventanas.Stock.busquedaCat;
import static com.yasmin.ventanas.Stock.busquedaCod;
import static com.yasmin.ventanas.Stock.busquedaNom;
import static com.yasmin.ventanas.Stock.busquedaPre;
import static com.yasmin.ventanas.Stock.busquedaStock;
import static com.yasmin.ventanas.Stock.imagen;
import static com.yasmin.ventanas.Stock.jTable1;
import static com.yasmin.ventanas.Stock.jTable2;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public class Articulos {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();

    public void listaArticulos() throws SQLException {
        String id = busCod.getText();
        try {
            String consultarArticulos = "SELECT * FROM articulo WHERE idarticulo= '" + id + "'";
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(consultarArticulos);

            while (rs.next()) {
                busquedaCod.setText(rs.getString(1));
                busquedaNom.setText(rs.getString(2));
                busquedaPre.setText(rs.getString(3));
                busquedaStock.setText(rs.getString(4));
                busquedaCat.setText(rs.getString(5));
                imagen.setText(rs.getString(6));
                ImageIcon image = new ImageIcon(rs.getString(6));
                imagen.setIcon(image);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la visualizacion ");
        }

    }

    public void visualizaTablaInsercion() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        jTable1.setModel(modelo);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }
    }
    
    public void insertArticulos() {
        String insert = "INSERT INTO articulo (idarticulo,descripcion,precio,stock,codcategoria) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(anadirCod.getText()));
            st.setString(2, anadirNom.getText());
            st.setString(3, anadirPre.getText());
            st.setString(4, anadirStock.getText());
            st.setString(5, anadirCat.getText());
            st.executeUpdate();
            visualizaTablaInsercion();
            JOptionPane.showMessageDialog(null,"Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al registrar");
        }
    }
    
    
    public void visualizarTablaDeletes(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        jTable2.setModel(modelo);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM articulo");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            jTable2.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }
    }
    public void deleteArticulos(){
        int fila=jTable2.getSelectedRow();
        String cod="";
        cod=jTable2.getValueAt(fila,0).toString();
        String delete = "DELETE FROM articulo WHERE idarticulo ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            visualizarTablaDeletes();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El producto que has elegido no se puede eliminar ");
        }
    }
    
    public void modificarProducto(){
        String update = "UPDATE articulo SET "
                + "descripcion ='" + busquedaNom.getText() 
                +"',precio =" + busquedaPre.getText()
                +",stock= " + busquedaStock.getText()
                +",codcategoria =" + busquedaCod.getText() + " WHERE idarticulo=" + busquedaCod.getText();       
        try {
            Statement st= cn.createStatement();
            st.executeUpdate(update);
            JOptionPane.showMessageDialog(null,"Producto modificado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar el producto");
        }
    }
    
    
}
