package edu.eci.cvds.dao.mybatis;


import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.entities.Rol;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    private MyBatisUserDAO myBatisUserDAO;


    @Override
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws PersistenceException {
        try {
            myBatisUserDAO.agregarUsuario(id, fullname, username, passwd, rol, isactive, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nuevo usuario: ", e);
        }
    }

    @Override
    public String IngresarSesion(String correo) throws PersistenceException {
        try {
            return myBatisUserDAO.IngresarSesion(correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al iniciar sesion: ", e);
        }
    }

    @Override
    public void ModificarRol(Rol rol, String correo) throws PersistenceException {
        try {
            myBatisUserDAO.ModificarRol(rol, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar rol de usuario: ", e);
        }
    }

    @Override
    public void EstadoUser(boolean isactive, String correo) throws PersistenceException {
        try {
            myBatisUserDAO.EstadoUser(isactive, correo);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al cambiar estado del usuario", e);
        }
    }
}
