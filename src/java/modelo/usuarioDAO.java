/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MelissaE
 */
public class usuarioDAO implements CRUB{
   Conexion conec = new Conexion();
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs= null;
    int respuesta;
    String mensaje;
    @Override
    public List listar() {
       String sql = "SELECT * FROM usuario";
       List<usuario> datos = new ArrayList<>();
       
               
        try {
          con=conec.getConnection();
          ps= con.prepareStatement(sql);
          rs= ps.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setCorreo(rs.getString("correo"));
                user.setTelefono(rs.getString("telefono"));
                user.setContraseña(rs.getString("contraseña"));
                datos.add(user);
            }
        } catch (Exception e) {
        }
       return datos;
    }

    @Override
    public usuario listarID(int id) {
        String sql = "SELECT * FROM usuario where id="+id;
        usuario user = new usuario();
        try {
          con=conec.getConnection();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
             
            while (rs.next()) {
              
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setCorreo(rs.getString("correo"));
                user.setTelefono(rs.getString("telefono"));
                user.setContraseña(rs.getString("contraseña"));
            }
        } catch (Exception e) {
        }
        return user;
    }


    @Override
    public usuario delete(int id) {
      String sql= "DELETE from usuario where id="+id;
      usuario user = new usuario();
        try {
            
            con=conec.getConnection();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
 
        } catch (Exception e) {
        }
        return user;
    }

    @Override
    public String add(int id, String nombre, String correo, String telefono,String contraseña) {
        String sql = "INSERT INTO user(id,nombre,correo,telefono,contraseña)values (?,?,?,?,?)";
        try {
            con=conec.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, correo);
            ps.setString(4, telefono);
            ps.setString(5, contraseña);
           respuesta= ps.executeUpdate();
           if(respuesta==1){
           mensaje="usuario agregado";
           }else{
               mensaje= "usuario no agregado";
           }
        } catch (Exception e) {
        }
        return mensaje;
    }

    @Override
    public String edit(int id, String nombre, String correo, String telefono,String contraseña) {
        String sql ="UPDATE usuario set nombre=?,correo=?,telefono=?,contraseña=? where id="+id;
        try {
            con=conec.getConnection();
            ps= con.prepareStatement(sql);   
            ps.setString(1,nombre);
            ps.setString(2,correo);
            ps.setString(3,telefono);
            ps.setString(4,contraseña);
           respuesta= ps.executeUpdate();
           if(respuesta==1){
           mensaje="usuario actualizado";
           }else{
               mensaje= "error al modificar!!!";
           }
            
        } catch (Exception e) {
        }
    
    return mensaje;
    }
    
}
