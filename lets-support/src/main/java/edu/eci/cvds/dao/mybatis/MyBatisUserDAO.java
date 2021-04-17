package edu.eci.cvds.dao.mybatis;


import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.dao.mybatis.mappers.UserMapper;
import edu.eci.cvds.entities.Rol;

import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    UserMapper userMapper;

    /**
     * Envia la información que viene de UsersDAO hacia UsersMapper, para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuarioque se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws PersistenceException {
        try {
            userMapper.agregarUsuario(id, fullname, username, passwd, rol, isactive, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nuevo usuario: ", e);
        }
    }

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

    /**
     * Envia la información que viene de UsersDAO hacia UsersMapper, para modificar el rol del usuario
     * @param rol nuevo rol que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarRol(Rol rol, String correo) throws PersistenceException {
        try {
            userMapper.ModificarRol(rol, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar rol de usuario: ", e);
        }
    }

    /**
     * Envia la información que viene de UsersDAO hacia UsersMapper, para modificar el estado del usuario
     * @param isactive nuevo estado que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void EstadoUser(boolean isactive, String correo) throws PersistenceException {
        try {
            userMapper.EstadoUser(isactive, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al cambiar estado del usuario", e);
        }
    }

    /**
     * Retorna una lista con los usernames de los usuarios existentes que llama desde UsersMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<String> traerUserNameUsers() throws PersistenceException {
        try {
            return userMapper.traerUserNameUsers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar usernames", e);
        }
    }

    /**
     * Retorna una lista con los ids de los usuarios existentes que llama desde UsersMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdUsers() throws PersistenceException {
        try {
            return userMapper.traerIdUsers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar ids", e);
        }
    }

    /**
     * Retorna una lista con los correos de los usuarios existentes que llama desde UsersMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<String> traerCorreoUsers() throws PersistenceException {
        try {
            return userMapper.traerCorreoUsers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar correos", e);
        }
    }
}
