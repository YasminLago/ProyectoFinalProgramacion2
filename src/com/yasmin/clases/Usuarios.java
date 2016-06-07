package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.VUsuarios.claveU;
import static com.yasmin.ventanas.VUsuarios.nomU;
import static com.yasmin.ventanas.VUsuarios.tablaU;
import static com.yasmin.ventanas.VUsuarios.tpU;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public class Usuarios {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();

    /**
     * Métodos para la Clase VUsuarios
     *
     *
     */
    /**
     * Muesta los datos de los distintos Usuarios en la 'tablaU'
     *
     * @throws SQLException
     * @throws IOException
     */
    public void listaTablaUsuarios() {
        DefaultTableModel modelo = new DefaultTableModel();
        ListSelectionModel lsm;

        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo Usuario");
        modelo.addColumn("Clave");
        tablaU.setModel(modelo);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nomu,tipo,clave FROM usuarios u,tipousuarios t WHERE u.codu=t.codu");
            String[] datos = new String[3];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tablaU.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }

    }

    /**
     * Llena el ComboBox 'tpU' con información contenida en la columna tipo de
     * la tabla usuarios
     */
    public final void llenarCBTpU() {
        try {
            String tipoUsers = "SELECT * FROM tipousuarios";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(tipoUsers);
            while (rs.next()) {
                tpU.addItem(rs.getObject("tipo"));
            }
        } catch (SQLException ex) {
        }
    }

    /**
     * Modifica los datos del usuarios seleccionado
     */
    public void modificarUsuarios() throws SQLException, IOException {
        int cod = 0;
        try {
            String select = "SELECT codu FROM tipousuarios WHERE tipo='" + tpU.getSelectedItem() + "'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(select);
            while (rs.next()) {
                cod = (int) rs.getObject("codu");
            }

            String update = "UPDATE usuarios SET "
                    + "nomu ='" + nomU.getText()
                    + "',codu =" + cod
                    + ",clave =" + claveU.getText() + " WHERE nomu='" + nomU.getText() + "'";

            try {
                Statement st = cn.createStatement();
                st.executeUpdate(update);
                listaTablaUsuarios();
                JOptionPane.showMessageDialog(null, "Usuario modificado");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al modificar el usuario");
            }
        } catch (SQLException ex) {

        }
    }

    /**
     * Añade nuevos usuarios
     *
     * @throws SQLException
     * @throws IOException
     */
    public void insertUsuarios() throws SQLException, IOException {
        int codU = 0;
        try {
            String select = "SELECT codu FROM tipousuarios WHERE tipo='" + tpU.getSelectedItem() + "'";
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(select);
            while (rs.next()) {
                codU = (int) rs.getObject("codu");
            }

            String insert = "INSERT INTO usuarios (nomu,codu,clave) VALUES(?,?,?)";
            PreparedStatement st = cn.prepareStatement(insert);
            st.setString(1, nomU.getText());
            st.setInt(2, codU);
            st.setString(3, claveU.getText());
            st.executeUpdate();
            listaTablaUsuarios();
            JOptionPane.showMessageDialog(null, "Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }

    /**
     * Elimina usuarios
     *
     * @throws SQLException
     * @throws IOException
     */
    public void eliminarUsuarios() throws SQLException, IOException {
        int fila = tablaU.getSelectedRow();
        String nom = "";
        nom = tablaU.getValueAt(fila, 0).toString();
        String delete = "DELETE FROM usuarios WHERE nomu ='" + nom + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            listaTablaUsuarios();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El usuario que has elegido no se puede eliminar ");
        }
    }
    /**
     *
     *
     * Fin métodos para la Clase VUsuarios
     */

}
