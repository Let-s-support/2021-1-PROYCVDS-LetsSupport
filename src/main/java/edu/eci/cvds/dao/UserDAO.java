package edu.eci.cvds.dao;

import edu.eci.cvds.entities.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDAO {

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que llama desde MyBatisUserDAO
     * @param username  username con el cual se buscara el se consultaran los datos
     * @return String
     * @throws PersistenceException controlador de excepciones
     */
    List<User> IngresarSesion(String username) throws PersistenceException;

}