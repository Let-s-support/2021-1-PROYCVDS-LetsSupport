package edu.eci.cvds.services;

import edu.eci.cvds.entities.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserServices {

    /**
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<User> IngresarSesion(String username) throws ServicesException;

}