package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import com.yasmin.ventanas.BuscarImagen;
import static com.yasmin.ventanas.Caja.tarticulosCaja;
import com.yasmin.ventanas.Stock2;
import static com.yasmin.ventanas.VProductos.anadirCat;
import static com.yasmin.ventanas.VProductos.anadirCod;
import static com.yasmin.ventanas.VProductos.anadirNom;
import static com.yasmin.ventanas.VProductos.anadirPre;
import static com.yasmin.ventanas.VProductos.anadirStock;
import static com.yasmin.ventanas.VProductos.busCod;
import static com.yasmin.ventanas.VProductos.busquedaCat;
import static com.yasmin.ventanas.VProductos.busquedaCod;
import static com.yasmin.ventanas.VProductos.busquedaNom;
import static com.yasmin.ventanas.VProductos.busquedaPre;
import static com.yasmin.ventanas.VProductos.busquedaStock;
import static com.yasmin.ventanas.VProductos.imagen;
import static com.yasmin.ventanas.VProductos.jTable1;
import static com.yasmin.ventanas.VProductos.jTable2;

import static com.yasmin.ventanas.Caja.autoCompletar;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
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
public class Productos {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    BuscarImagen bi = new BuscarImagen();
   
    
    /**
     * Metodo que muestra las caracteristicas del producto que buscas a partir del codigo
     * @throws SQLException
     * @throws IOException 
     */
    public void listaProductos() throws SQLException, IOException {
        String id = busCod.getText();
        try {
            String consultarArticulos = "SELECT * FROM productos WHERE codp= '" + id + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consultarArticulos);

            while (rs.next()) {
                busquedaCod.setText(rs.getString(1));
                busquedaNom.setText(rs.getString(2));
                busquedaPre.setText(rs.getString(4));
                busquedaStock.setText(rs.getString(5));
                busquedaCat.setText(rs.getString(6));
                Blob blob = rs.getBlob(7);
                Image i= javax.imageio.ImageIO.read(blob.getBinaryStream());
                ImageIcon image = new ImageIcon(i);
                imagen.setIcon(image);
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la visualizacion ");
        }

    }
    
    /**
     * Muestra todos los producto en la tabla de inserciones
     */
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
    
    /**
     * Registra productos nuevos
     * @throws FileNotFoundException 
     */
    public void insertarProductos() throws FileNotFoundException {
        String insert = "INSERT INTO articulo (idarticulo,descripcion,precio,stock,codcategoria,imagen) VALUES(?,?,?,?,?,?)";
        FileInputStream foto;     
        try {
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(anadirCod.getText()));
            st.setString(2, anadirNom.getText());
            st.setString(3, anadirPre.getText());
            st.setString(4, anadirStock.getText());
            st.setString(5, anadirCat.getText());
            
           /* File file = new File(s.ruta);
            foto = new FileInputStream(file);
            st.setBinaryStream(6,foto,(int)file.length());*/
            st.executeUpdate();
            visualizaTablaInsercion();
            JOptionPane.showMessageDialog(null,"Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al registrar");
        }
    }
    
    /**
     * Muestra todos los producto en la tabla de eliminaciones
     */
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
    
    /**
     * Elimina el producto que se selecciona
     */
    public void eliminarProductos(){
        int fila=jTable2.getSelectedRow();
        String cod="";
        cod=jTable2.getValueAt(fila,0).toString();
        String delete = "DELETE FROM producto WHERE idarticulo ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            visualizarTablaDeletes();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El producto que has elegido no se puede eliminar ");
        }
    }
    
    /**
     * Modifica un producto
     */
    public void modificarProductos(){
        String update = "UPDATE producto SET "
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
    
    
    
    /**
     * Métodos Clase Caja
     * 
     * 
     */
    
    
    public ResultSet getListaProductos()throws Exception{
        ResultSet rs;
        try {
            Statement st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM productos");
      } catch (Exception e) {
          throw e;
      }
      return rs;           
    }
    
    /**
     * 
     * 
     * Fin métodos Clase Caja
     */
}
