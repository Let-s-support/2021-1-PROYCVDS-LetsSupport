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
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     * @throws ServicesException controlador de errores de la capa de services
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
