package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.dao.UserDAO;

public class UserServicesImpl implements UserServices {

    @Inject
    UserDAO userDAO;

    /**
     * Es usado por UserServices para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, lo despliega en UserDAO
     * @return String
     * @param correo es el correo son el cual se consultara la contraseña
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

}
