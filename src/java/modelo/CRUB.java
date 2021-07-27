/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;



/**
 *
 * @author MelissaE
 */
public interface CRUB {
 
       public List listar();
       public usuario listarID(int id);
       public String add(int id,String nombre,String correo,String telefono,String contraseña);
       public String edit(int id,String nombre,String correo,String telefono,String contraseña);
         public usuario delete(int id);
        
    
}
