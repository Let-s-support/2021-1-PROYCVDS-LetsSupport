package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Rol;

public interface UserDAO {
    public void agregarUsuario(int id, String fullname, String username, String passwd, Rol rol, boolean isactive, String correo) throws PersistenceException;      
    public String IngresarSesion(String correo) throws PersistenceException;
    public void ModificarRol(Rol rol, String correo) throws PersistenceException;
    public void EstadoUser(boolean isactive, String correo) throws PersistenceException;
}