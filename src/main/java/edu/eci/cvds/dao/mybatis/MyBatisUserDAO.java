package edu.eci.cvds.dao.mybatis;


import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;

import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    UserMapper userMapper;

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que llama desde UsersMapper
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public String IngresarSesion(String correo) throws PersistenceException {
        try {
            return userMapper.IngresarSesion(correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    }

}
