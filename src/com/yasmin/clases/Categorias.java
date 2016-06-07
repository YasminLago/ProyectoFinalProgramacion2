package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Stock2.codCat;
import static com.yasmin.ventanas.Stock2.nomCat;
import static com.yasmin.ventanas.Stock2.tCategorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public class Categorias {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();

    public void visualizaTablaCategorias() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");

        tCategorias.setModel(modelo);
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categorias");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                modelo.addRow(datos);
            }
            tCategorias.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }
    }

    public void insertarCategorias() throws SQLException {
        int cod = 0;
        try {
            String insert = "INSERT INTO categorias (codc,nomc) VALUES(?,?)";
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(codCat.getText()));
            st.setString(2, nomCat.getText());
            st.executeUpdate();
            visualizaTablaCategorias();
            JOptionPane.showMessageDialog(null, "Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }

    public void eliminarCategorias() {
        int fila = tCategorias.getSelectedRow();
        String cod = "";
        cod = tCategorias.getValueAt(fila, 0).toString();
        String delete = "DELETE FROM categorias WHERE codc ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            visualizaTablaCategorias();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La categoría que has elegido no se puede eliminar ");
        }
    }

    public void modificarCategorias() {
        try {
            String update = "UPDATE categorias SET "
                    + "nomc ='" + nomCat.getText()
                    + "' WHERE codc=" + codCat.getText();
            Statement st = cn.createStatement();
            st.executeUpdate(update);
            visualizaTablaCategorias();
            JOptionPane.showMessageDialog(null, "Categoría modificada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la categoría");
        }
    }
}
