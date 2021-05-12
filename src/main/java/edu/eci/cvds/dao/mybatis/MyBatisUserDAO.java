package edu.eci.cvds.dao.mybatis;


import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    UserMapper userMapper;

    /**
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     */
    @Override
    public List<User> IngresarSesion(String username) throws PersistenceException {
        try {
            return userMapper.IngresarSesion(username);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    }
    @Override
    public List<User> NombreUsuario(int id) throws PersistenceException{
        try {
            return userMapper.NombreUsuario(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    }
}
