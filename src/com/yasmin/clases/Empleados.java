package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Login.pass;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import static com.yasmin.ventanas.Usuarios.apeU;
import static com.yasmin.ventanas.Usuarios.claveU;
import static com.yasmin.ventanas.Usuarios.dirU;
import static com.yasmin.ventanas.Usuarios.dniU;
import static com.yasmin.ventanas.Usuarios.nomU;
import static com.yasmin.ventanas.Usuarios.tablaU;
import static com.yasmin.ventanas.Usuarios.telU;
import static com.yasmin.ventanas.Usuarios.tpU;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasmín
 */
public class Empleados {
   
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.ConexionBD();
    
    /**
     * Métodos para la Clase Login
     * 
     * 
     */
     
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
    /**
     * 
     * 
     * Fin métodos para la Clase Login
     */
    
    
    /**
     * Métodos para la Clase Usuarios
     * 
     * 
     */
    
    /**
     * Muesta los datos de los distintos Usuarios en la 'tablaU'
     * @throws SQLException
     * @throws IOException 
     */
    public void listaTablaUsuarios() {
        DefaultTableModel modelo = new DefaultTableModel();
        ListSelectionModel lsm;
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Tipo Usuario");
        modelo.addColumn("Clave");
        tablaU.setModel(modelo);
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT code,nome,apee,diree,telee,tipo,clave FROM empleados e,usuarios u WHERE e.codu=u.codu");      
            String[] datos = new String[7];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos [5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tablaU.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }

    }
    
    /**
     * Llena el ComboBox 'tpU' con información contenida en la columna tipo de la tabla usuarios
     */
     public final void llenarCBTpU(){
        try {
            String tipoUsers = "SELECT * FROM usuarios";
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
     public void modificarUsuarios()throws SQLException, IOException{
         int cod = 0 ;
         try{
         String select ="SELECT codu FROM usuarios WHERE tipo='"+tpU.getSelectedItem()+"'";
         Statement st2 = cn.createStatement();
         ResultSet rs = st2.executeQuery(select);
         while (rs.next())
             cod = (int) rs.getObject("codu");
 
        String update = "UPDATE empleados SET "
                + "code =" + dniU.getText() 
                +",nome ='" + nomU.getText()
                +"',apee ='" + apeU.getText()
                +"',diree ='" + dirU.getText() 
                +"',telee =" + telU.getText() 
                +",codu =" + cod
                +",clave ='" + claveU.getText() + "' WHERE code=" + dniU.getText();     
         
        try {
            Statement st= cn.createStatement();
            st.executeUpdate(update);
            listaTablaUsuarios();
            JOptionPane.showMessageDialog(null,"Usuario modificado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar el usuario");
        }
        }catch(SQLException ex){
             
         }
    }
     /**
      * Añade nuevos usuarios
      * @throws SQLException
      * @throws IOException 
      */   
     public void insertUsuarios() throws SQLException, IOException{    
        int cod = 0 ;
        try {
         String select ="SELECT codu FROM usuarios WHERE tipo='"+tpU.getSelectedItem()+"'";
         Statement st2 = cn.createStatement();
         ResultSet rs = st2.executeQuery(select);
         while (rs.next())
             cod = (int) rs.getObject("codu");
         
        String insert = "INSERT INTO empleados (code,nome,apee,diree,telee,codu,clave) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(dniU.getText()));
            st.setString(2, nomU.getText());
            st.setString(3, apeU.getText());
            st.setString(4, dirU.getText());
            st.setInt(5, Integer.parseInt(telU.getText()));
            st.setInt(6, cod);
            st.setString(7, claveU.getText());
            st.executeUpdate();
            listaTablaUsuarios();
            JOptionPane.showMessageDialog(null,"Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al registrar");
        }
    }
    
     /**
      * Elimina usuarios
      * @throws SQLException
      * @throws IOException 
      */
    public void eliminarUsuarios()throws SQLException, IOException{
        int fila=tablaU.getSelectedRow();
        String cod="";
        cod=tablaU.getValueAt(fila,0).toString();
        String delete = "DELETE FROM empleados WHERE code ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            listaTablaUsuarios();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El usuario que has elegido no se puede eliminar ");
        }
    }
      
    
    /**
     * 
     * 
     * Fin métodos para la Clase Usuarios
     */

    }