package edu.eci.cvds.dao.mybatis;


import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.entities.User;

import java.sql.ResultSet;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    UserMapper userMapper;

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que llama desde UsersMapper
     * @param username  es el username con el cual se consultaran los datos
     * @return String
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<User> IngresarSesion(String username) throws PersistenceException {
        try {
            return userMapper.IngresarSesion(username);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    }

}
