package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.dao.UserDAO;

import java.sql.ResultSet;
import java.util.List;

public class UserServicesImpl implements UserServices {

    @Inject
    UserDAO userDAO;

    /**
     * Es usado por UserServices para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, lo despliega en UserDAO
     * @return String
     * @param username es el username con el cual se consultara los datos
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<User> IngresarSesion(String username) throws ServicesException {
        try {
            return userDAO.IngresarSesion(username);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }

}
