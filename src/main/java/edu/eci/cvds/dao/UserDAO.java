package edu.eci.cvds.dao;

import edu.eci.cvds.entities.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserDAO {

    /**
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<User> IngresarSesion(String username) throws PersistenceException;
    List<User> NombreUsuario(int id) throws PersistenceException;
}