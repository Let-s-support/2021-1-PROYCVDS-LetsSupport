package edu.eci.cvds.services;

import java.util.List;

public interface UserServices {

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de agregarUsuario y la envia a UserServicesImpl
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     * @throws ServicesException controlador de excepciones
     */
    void agregarUsuario(int id, String fullname, String username, String passwd, int rol, boolean isactive, String correo) throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de IngresarSesion y asi obtener la contraseña del user por medio del correo, la envia a UserServicesImpl
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    String IngresarSesion(String correo) throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de ModificarRol y la envia a UserServicesImpl para realizar la modificacion de rol de un user
     * @param rol nuevo rol del user
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    void ModificarRol(int rol, String correo) throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de EstadoUser y la envia a UserServicesImpl para realizar el cambio de estado del user
     * @param isactive nuevo estado del usr
     * @param correo correo del user con el que se va a realizar la busqueda
     * @throws ServicesException controlador de excepciones
     */
    void EstadoUser(boolean isactive, String correo) throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de traerUserNameUsers y asi obtener la información de los usernames de los users existentes, la envia a UserServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<String> traerUserNameUsers() throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de traerIdUsers y asi obtener la información de los ids de los users existentes, la envia a UserServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<Integer> traerIdUsers() throws ServicesException;

    /**
     * Es usado por UserServicesBean para desplegar la funcionalidad de traerCorreoUsers y asi obtener la información de los correos de los users existentes, la envia a UserServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<String> traerCorreoUsers() throws ServicesException;
}