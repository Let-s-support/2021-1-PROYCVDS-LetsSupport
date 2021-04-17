package edu.eci.cvds.view;

import javax.faces.bean.ApplicationScoped;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

import java.util.List;

@javax.faces.bean.ManagedBean(name = "UserServices")
@ApplicationScoped
public class UserServicesBean extends BasePageBean{

    @Inject
    UserServices userServices;

    /**
     * Es usado para controlar la funcionalidad de crear usuario desde la interfaz
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     * @throws ServicesException controlador de excepciones
     */
    public void agregarUsuario(int id, String fullname, String username, String passwd, int rol, boolean isactive, String correo) throws ServicesException {
        try {
            userServices.agregarUsuario(id, fullname, username, passwd, rol, isactive, correo);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al agregar usuario",ex);
        }
    }

    /**
     * Es usado para controlar la funcionalidad de iniciar sesion desde la interfaz
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    public String IngresarSesion(String correo) throws ServicesException {
        try {
            return userServices.IngresarSesion(correo);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }

    /**
     * Es usado para controlar la funcionalidad de moddificar rol de usuario desde la interfaz
     * @param rol nuevo rol del user
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    public void ModificarRol(int rol, String correo) throws ServicesException {
        try {
            userServices.ModificarRol(rol,correo);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar rol",ex);
        }
    }

    /**
     * Es usado para controlar la funcionalidad de modificar estado de usuario desde la interfaz
     * @param isactive nuevo estado del usr
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    public void EstadoUser(boolean isactive, String correo) throws ServicesException {
        try {
            userServices.EstadoUser(isactive, correo);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar estado",ex);
        }
    }
}
