package edu.eci.cvds.services;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.entities.User;

public interface UserServices {
    public void agregarCategoria(int id, String nombre, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion) throws UserServiceException;
    public void ModificarCategoria(int nombre, String descripcion, Status estado) throws UserServiceException;
    public void agregarNecesidades(int id, String nombre, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion, Categories category_id) throws UserServiceException;
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws UserServiceException;
    public String IngresarSesion(String correo) throws UserServiceException;
    public void ModificarRol(Rol rol, String correo) throws UserServiceException;
    public void EstadoUser(boolean isactive, String correo) throws UserServiceException;
}