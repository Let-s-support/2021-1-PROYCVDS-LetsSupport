package edu.eci.cvds.services;

import java.util.List;

public interface UserServices {

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, la envia a UserServicesImpl
     * @param correo es el correo son el cual se consultara la contraseña
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    List<String> IngresarSesion(String correo, String passwd) throws ServicesException;

}