package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Login.pass;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import static com.yasmin.ventanas.Usuarios.tablaU;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class Empleados {
   
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
     
    /**
     * Permite el acceso a los empleados si están autorizados a través de un
     * usuario y contraseña
     *
     * @return Retorna un 1 si la consulta se realizó con exito
     */
    public int login() {
        String usuario = user.getText();
        String passw = String.valueOf(pass.getPassword());
        String tipoU = String.valueOf(tipoUser.getSelectedItem());
        int resultado = 0;
        String SSQL = "SELECT * FROM empleados WHERE nome = '" + usuario + "' AND  clave ='" + passw + "' AND codu IN (SELECT codu FROM USUARIOS WHERE tipo = '" + tipoU + "')";
        ConexionBD cc = new ConexionBD();
        
        try {
            Connection cn = cc.ConexionBD();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if (rs.next()) {
                resultado = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        } finally {
            Connection cn = cc.ConexionBD();
            try {
                cn.close();//Cierra la conexión con la base de datos
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        }
        return resultado;
    }
    
     /**
     * Llena el ComboBox 'tipoUser' con información contenida en la columna tipo de la tabla usuarios
     */
    public final void llenarCBTipoUsers(){
        try {
            String tipoUsers = "SELECT * FROM usuarios";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(tipoUsers);

            while (rs.next()) {               
                tipoUser.addItem(rs.getObject("tipo"));    
            }  
        } catch (SQLException ex) {
        }
    }
    
    public void listaUsuarios() throws SQLException, IOException {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Tipo de Usuario");
        modelo.addColumn("Clave");
        tablaU.setModel(modelo);
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");
            String[] datos = new String[5];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tablaU.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }

    }
    
    
    
}
