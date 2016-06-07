package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import com.yasmin.ventanas.BuscarImagen;
import static com.yasmin.ventanas.Stock2.anadirCat;
import static com.yasmin.ventanas.Stock2.anadirCod;
import static com.yasmin.ventanas.Stock2.anadirNom;
import static com.yasmin.ventanas.Stock2.anadirPre;
import static com.yasmin.ventanas.Stock2.anadirStock;
import static com.yasmin.ventanas.Stock2.busquedaCat;
import static com.yasmin.ventanas.Stock2.busquedaCod;
import static com.yasmin.ventanas.Stock2.busquedaNom;
import static com.yasmin.ventanas.Stock2.busquedaPre;
import static com.yasmin.ventanas.Stock2.busquedaStock;
import static com.yasmin.ventanas.Stock2.imagen;
import static com.yasmin.ventanas.Stock2.tInsert;
import static com.yasmin.ventanas.Stock2.tablaDelete;
import static com.yasmin.ventanas.Stock2.busCod;
import static com.yasmin.ventanas.Stock2.imagenBuscar;
import static com.yasmin.ventanas.Stock2.rutaFoto;
import java.awt.Color;
import java.awt.Image;
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
     * Metodo que muestra las caracteristicas del producto que buscas a partir
     * del codigo
     *
     * @throws SQLException
     * @throws IOException
     */
    public void listaProductos() throws SQLException, IOException {
        String id = busCod.getText();
        try {
            String consultarArticulos = "SELECT codp,nomp,precio,stock,nomc,imagen FROM productos p, categorias c WHERE p.codc=c.codc AND codp= '" + id + "'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consultarArticulos);

            while (rs.next()) {
                busquedaCod.setText(rs.getString(1));
                busquedaNom.setText(rs.getString(2));
                busquedaPre.setText(rs.getString(3));
                busquedaStock.setText(rs.getString(4));
                busquedaCat.setText(rs.getString(5));
                Blob blob = rs.getBlob(6);
                Image i = javax.imageio.ImageIO.read(blob.getBinaryStream());
                ImageIcon image = new ImageIcon(i);
                imagen.setIcon(image);
                String stock = rs.getString(4);
                int s = Integer.parseInt(stock);
                if (s <= 5) {
                    busquedaStock.setBackground(Color.red);
                } else if (s >= 6 || s <= 9) {
                    busquedaStock.setBackground(Color.yellow);
                }
                if (s >= 10) {
                    busquedaStock.setBackground(Color.green);
                }
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la visualizacion ");
        }

    }

    public void stock() {

    }

    /**
     * Llena el ComboBox con las categorías existentes en la BD
     */
    public final void llenarAñadirCat() {
        try {
            String cat = "SELECT * FROM categorias";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(cat);
            while (rs.next()) {
                anadirCat.addItem(rs.getObject("nomc"));
            }
        } catch (SQLException ex) {
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
        tInsert.setModel(modelo);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT codp,nomp,precio,stock,nomc FROM productos p,categorias c WHERE p.codc=c.codc");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            tInsert.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }
    }

    public void insertarProductos() throws SQLException, IOException {
        int cod = 0;
        try {
            String select = "SELECT codc FROM categorias WHERE nomc='" + anadirCat.getSelectedItem() + "'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(select);
            while (rs.next()) {
                cod = (int) rs.getObject("codc");
            }

            String insert = "INSERT INTO productos (codp,nomp,precio,stock,codc,imagen) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(anadirCod.getText()));
            st.setString(2, anadirNom.getText());
            st.setString(3, anadirPre.getText());
            st.setString(4, anadirStock.getText());
            st.setInt(5, cod);
            st.setString(6, rutaFoto.getText());
            st.executeUpdate();
            visualizaTablaInsercion();
            JOptionPane.showMessageDialog(null, "Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }

    /**
     * Muestra todos los producto en la tabla de eliminaciones
     */
    public void visualizarTablaDeletes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        tablaDelete.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaDelete.getColumnModel().getColumn(2).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(3).setPreferredWidth(20);
        tablaDelete.getColumnModel().getColumn(4).setPreferredWidth(100);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT codp,nomp,precio,stock,nomc FROM productos p, categorias c WHERE p.codc=c.codc");
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
    }

    /**
     * Elimina el producto que se selecciona
     */
    public void eliminarProductos() {
        int fila = tablaDelete.getSelectedRow();
        String cod = "";
        cod = tablaDelete.getValueAt(fila, 0).toString();
        String delete = "DELETE FROM productos WHERE codp ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            visualizarTablaDeletes();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El producto que has elegido no se puede eliminar ");
        }
    }

    /**
     * Modifica un producto
     */
    public void modificarProductos() {
        int codc = 0;

        try {
            String select = "SELECT codc FROM categorias WHERE nomc='" + busquedaCat.getText() + "'";

            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(select);
            while (rs.next()) {
                codc = (int) rs.getObject("codc");
            }

            String update = "UPDATE productos SET "
                    + "nomp ='" + busquedaNom.getText()
                    + "',precio =" + busquedaPre.getText()
                    + ",stock= " + busquedaStock.getText()
                    + ",codc =" + codc
                    + ",imagen='" + imagenBuscar.getText() + "' WHERE codp=" + busquedaCod.getText();
            Statement st = cn.createStatement();
            st.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "Producto modificado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto");
        }
    }

    /**
     * Métodos Clase Caja
     *
     *
     */
    public ResultSet getListaProductos() throws Exception {
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
