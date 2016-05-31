package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Login.pass;
import static com.yasmin.ventanas.Login.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasmín
 */
public class Empleados {
    
    
    
    /**
     * Permite el acceso a los empleados si están autorizados a través de un
     * usuario y contraseña
     *
     * @return Retorna un 1 si la consulta se realizó con exito
     */
    public int login() {
        String usuario = user.getText();
        String passw = String.valueOf(pass.getPassword());

        int resultado = 0;

        String SSQL = "SELECT * FROM empleado WHERE nombre = '" + usuario + "' AND  clave ='" + passw + "'";
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
}
