package com.yasmin.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Yasmín
 */
public class ConexionBD {
    //String user = "ylagorebollar";
    String user = "root";
    String pass = "ylagorebollar";
    String driver = "com.mysql.jdbc.Driver";
    //String url = "jdbc:mysql://10.0.0.254/ylagorebollar";
    String url = "jdbc:mysql://localhost/controldestock2";
    Statement s = null;
    Connection conectar=null;
    
    /**
     * Metodo que conecta la base de datos con el programa y carga los drivers
     * @return Retorna la conexion
     */
    public Connection ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}
