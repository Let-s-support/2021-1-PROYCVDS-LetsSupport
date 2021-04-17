package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Rol;

import java.util.List;

public interface UserDAO {

    /**
     * Envia la información que viene de UsersServicesImpl hacia MyBatisUserDAO, para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     * @throws PersistenceException controlador de excepciones
     */
    void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws PersistenceException;

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que llama desde MyBatisUserDAO
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     * @throws PersistenceException controlador de excepciones
     */
    String IngresarSesion(String correo) throws PersistenceException;

    /**
     * Envia la información que viene de UsersServicesImpl hacia MyBatisUserDAO, para modificar el rol del usuario
     * @param rol nuevo rol que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     * @throws PersistenceException controlador de excepciones
     */
    void ModificarRol(Rol rol, String correo) throws PersistenceException;

    /**
     * Envia la información que viene de UsersServicesImpl hacia MyBatisUserDAO, para modificar el estado del usuario
     * @param isactive nuevo estado que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     * @throws PersistenceException controlador de excepciones
     */
    void EstadoUser(boolean isactive, String correo) throws PersistenceException;

    /**
     * Retorna una lista con los usernames de los usuarios existentes que llama desde MyBatisUserDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<String> traerUserNameUsers() throws PersistenceException;

    /**
     * Retorna una lista con los ids de los usuarios existentes que llama desde MyBatisUserDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Integer> traerIdUsers() throws PersistenceException;

    /**
     * Retorna una lista con los correos de los usuarios existentes que llama desde MyBatisUserDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<String> traerCorreoUsers() throws PersistenceException;
}