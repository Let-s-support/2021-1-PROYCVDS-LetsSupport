package edu.eci.cvds.services.Impl;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.UserServiceException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.dao.UserDAO;
public class UserServicesImpl implements UserServices {

    @Inject
    private CategoriesDAO categoriesDAO;

    @Inject
    private NeedsDAO needsDAO;

    @Inject
    private UserDAO userDAO;

    @Override
    public void agregarCategoria(int id, String nombre, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion) throws UserServiceException {
        try {
            categoriesDAO.agregarCategoria(id, nombre, descripcion, estado, fecha_creacion, fecha_modificacion);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public void ModificarCategoria(int nombre, String descripcion, Status estado) throws UserServiceException {
        try {
            categoriesDAO.ModificarCategoria(nombre, descripcion, estado);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public void agregarNecesidades(int id, String nombre, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion, Categories category_id) throws UserServiceException {
        try {
            needsDAO.agregarNecesidades(id, nombre, descripcion, estado, fecha_creacion, fecha_modificacion, category_id);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws UserServiceException {
        try {
            userDAO.agregarUsuario(id, fullname, username, passwd, rol, isactive, correo);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public String IngresarSesion(String correo) throws UserServiceException {
        try {
            return userDAO.IngresarSesion(correo);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public void ModificarRol(Rol rol, String correo) throws UserServiceException {
        try {
            userDAO.ModificarRol(rol,correo);
        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }

    @Override
    public void EstadoUser(boolean isactive, String correo) throws UserServiceException {
        try {
            userDAO.EstadoUser(isactive, correo);
;        } catch (PersistenceException ex) {
            throw new UserServiceException("El item no esta registrado",ex);
        }
    }
}
