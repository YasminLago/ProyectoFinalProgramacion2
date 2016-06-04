package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Login.pass;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import static com.yasmin.ventanas.Stock2.fondoStock2;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
    
    
    
}
