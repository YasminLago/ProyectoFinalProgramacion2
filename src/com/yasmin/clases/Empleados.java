package com.yasmin.clases;

import com.yasmin.bd.ConexionBD;
import static com.yasmin.ventanas.Login.pass;
import static com.yasmin.ventanas.Login.tipoUser;
import static com.yasmin.ventanas.Login.user;
import static com.yasmin.ventanas.VEmpleados.apeE;
import static com.yasmin.ventanas.VEmpleados.dirE;
import static com.yasmin.ventanas.VEmpleados.dniE;
import static com.yasmin.ventanas.VEmpleados.nomE;
import static com.yasmin.ventanas.VEmpleados.tablaE;
import static com.yasmin.ventanas.VEmpleados.telE;
import static com.yasmin.ventanas.VEmpleados.tpE;

import static com.yasmin.ventanas.VUsuarios.claveU;

import static com.yasmin.ventanas.VUsuarios.nomU;
import static com.yasmin.ventanas.VUsuarios.tablaU;

import static com.yasmin.ventanas.VUsuarios.tpU;
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
        String SSQL = "SELECT * FROM usuarios WHERE nomu = '" + usuario + "' AND  clave ='" + passw + "' AND codu IN (SELECT codu FROM tipousuarios WHERE tipo = '" + tipoU + "')";
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
            String tipoUsers = "SELECT * FROM tipousuarios";
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
     * Métodos para la Clase VEmpleados
     * 
     * 
     */
    
    /**
     * Muesta los datos de los distintos empleados en la 'tablaE'
     * @throws SQLException
     * @throws IOException 
     */
    public void listaTablaEmpleados() {
        DefaultTableModel modelo = new DefaultTableModel();
        ListSelectionModel lsm;
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Direccion");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Tipo Empleado");
        
        tablaE.setModel(modelo);
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT code,nome,apee,diree,telee,tipoE FROM empleados e,tipoempleados t WHERE e.cod=t.cod");      
            String[] datos = new String[6];
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            tablaE.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println("Imposible visualizar ");
        }

    }
    
    /**
     * Llena el ComboBox 'tpE' con información contenida en la columna tipo de la tabla usuarios
     */
    public final void llenarCBTpE(){
        try {
            String tipoEmpleados = "SELECT * FROM tipoempleados";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(tipoEmpleados);
            while (rs.next()) {               
                tpE.addItem(rs.getObject("tipoE"));  
            }  
        } catch (SQLException ex) {
        }
    }
     
     /**
      * Modifica los datos del empleado seleccionado
      */
    public void modificarEmpleados()throws SQLException, IOException{
         int cod = 0 ;
         try{
         String select ="SELECT cod FROM tipoempleados WHERE tipoE='"+tpE.getSelectedItem()+"'";
         Statement st2 = cn.createStatement();
         ResultSet rs = st2.executeQuery(select);
         while (rs.next())
             cod = (int) rs.getObject("cod");
 
        String update = "UPDATE empleados SET "
                + "code =" + dniE.getText() 
                +",nome ='" + nomE.getText()
                +"',apee ='" + apeE.getText()
                +"',diree ='" + dirE.getText() 
                +"',telee =" + telE.getText() 
                +",cod =" + cod
                +" WHERE code=" + dniE.getText();     
         
        try {
            Statement st= cn.createStatement();
            st.executeUpdate(update);
            listaTablaEmpleados();
            JOptionPane.showMessageDialog(null,"Usuario modificado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al modificar el usuario");
        }
        }catch(SQLException ex){
             
         }
    }
     /**
      * Añade nuevos empleados
      * @throws SQLException
      * @throws IOException 
      */   
    public void insertEmpleados() throws SQLException, IOException{    
        int cod = 0 ;
        try {
         String select ="SELECT cod FROM tipoempleados WHERE tipoE='"+tpE.getSelectedItem()+"'";
         Statement st2 = cn.createStatement();
         ResultSet rs = st2.executeQuery(select);
         while (rs.next())
             cod = (int) rs.getObject("cod");
        
        String insert = "INSERT INTO empleados (code,nome,apee,diree,telee,cod) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(dniE.getText()));
            st.setString(2, nomE.getText());
            st.setString(3, apeE.getText());
            st.setString(4, dirE.getText());
            st.setInt(5, Integer.parseInt(telE.getText()));         
            st.setInt(6, cod);
         
            st.executeUpdate();
            listaTablaEmpleados();
            JOptionPane.showMessageDialog(null,"Registro correcto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al registrar");
        }
    }
    
     /**
      * Elimina empleados
      * @throws SQLException
      * @throws IOException 
      */
    public void eliminarEmpleados()throws SQLException, IOException{
        int fila=tablaE.getSelectedRow();
        String cod="";
        cod=tablaE.getValueAt(fila,0).toString();
        String delete = "DELETE FROM empleados WHERE code ='" + cod + "'";
        try {
            PreparedStatement ps = cn.prepareStatement(delete);
            ps.executeUpdate();
            listaTablaEmpleados();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El empleado que has elegido no se puede eliminar ");
        }
    }

    /**
     * 
     * 
     * Fin métodos para la Clase VEmpleados
     */

    
    }