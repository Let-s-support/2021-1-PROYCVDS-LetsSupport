package edu.eci.cvds.dao;

public interface UserDAO {

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que llama desde MyBatisUserDAO
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     * @throws PersistenceException controlador de excepciones
     */
    String IngresarSesion(String correo) throws PersistenceException;

}