/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MelissaE
 */
public class Conexion {
  Connection con;
public Conexion(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","1995");
    } catch (Exception e) {
    }  
    
}
public Connection getConnection(){
    return con;
}
}
