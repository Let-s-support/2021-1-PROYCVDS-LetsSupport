package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Status;

import java.util.Date;

public interface CategoriesDAO {
    public void agregarCategoria(int id, String value, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion) throws PersistenceException;
    public void ModificarCategoria(int nombre, String descripcion, Status estado) throws PersistenceException;
}