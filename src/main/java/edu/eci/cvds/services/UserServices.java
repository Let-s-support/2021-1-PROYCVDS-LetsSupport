package edu.eci.cvds.services;

import edu.eci.cvds.entities.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserServices {

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, la envia a UserServicesImpl
     * @param username es el username con el cual se consultaran los datos
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    List<User> IngresarSesion(String username) throws ServicesException;

}