package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.dao.UserDAO;

import java.util.List;

public class UserServicesImpl implements UserServices {

    @Inject
    UserDAO userDAO;

    /**
     * Es usado por UserServices para desplegar la funcionalidad de agregarUsuario y lo despliega en UserDAO
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws ServicesException {
        try {
            List<String> correos = userDAO.traerCorreoUsers();
            List<Integer> ids = userDAO.traerIdUsers();
            List<String> usernames = userDAO.traerUserNameUsers();
            if(!correos.contains(correo) && !ids.contains(id) && !usernames.contains(username)){
                userDAO.agregarUsuario(id, fullname, username, passwd, rol, isactive, correo);
            }
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al agregar usuario",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, lo despliega en UserDAO
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public String IngresarSesion(String correo) throws ServicesException {
        try {
            return userDAO.IngresarSesion(correo);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de ModificarRol y lo despliega en UserDAO para realizar la modificacion de rol de un user
     * @param rol nuevo rol del user
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void ModificarRol(Rol rol, String correo) throws ServicesException {
        try {
            userDAO.ModificarRol(rol,correo);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al modificar rol",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de EstadoUser y lo despliega en UserDAO para realizar el cambio de estado del user
     * @param isactive nuevo estado del usr
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void EstadoUser(boolean isactive, String correo) throws ServicesException {
        try {
            userDAO.EstadoUser(isactive, correo);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al modificar estado",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de traerUserNameUsers y asi obtener la información de los usernames de los users existentes, lo despliega en UserDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerUserNameUsers() throws ServicesException {
        try {
            return userDAO.traerUserNameUsers();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al consultar nameusers",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de traerIdUsers y asi obtener la información de los ids de los users existentes, lo despliega en UserDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdUsers() throws ServicesException {
        try {
            return userDAO.traerIdUsers();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al consultar ids",ex);
        }
    }

    /**
     * Es usado por UserServices para desplegar la funcionalidad de traerCorreoUsers y asi obtener la información de los correos de los users existentes, lo despliega en UserDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerCorreoUsers() throws ServicesException {
        try {
            return userDAO.traerCorreoUsers();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al consultar correos",ex);
        }
    }
}
