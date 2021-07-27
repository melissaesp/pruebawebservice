/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.usuario;
import modelo.usuarioDAO;

/**
 *
 * @author MelissaE
 */
@WebService(serviceName = "servicios")
public class servicios {
    usuarioDAO dao= new usuarioDAO();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono, @WebParam(name = "contrase\u00f1a") String contraseña) {
        String data = dao.add(id, nombre, correo, telefono, contraseña);
        return data;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultar")
    public List<usuario> consultar() {
        List datos = dao.listar();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public usuario eliminar(@WebParam(name = "id") int id) {
       usuario user = dao.delete(id);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarID")
    public usuario listarID(@WebParam(name = "id") int id) {
        usuario user = dao.listarID(id);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificar")
    public String modificar(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "correo") String correo, @WebParam(name = "telefono") String telefono, @WebParam(name = "contrase\u00f1a") String contraseña) {
       String user = dao.edit(id, nombre, correo, telefono, contraseña);
        return user;
    }

}
