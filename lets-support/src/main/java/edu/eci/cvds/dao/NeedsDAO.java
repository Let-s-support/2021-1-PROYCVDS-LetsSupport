package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;

import java.util.Date;

public interface NeedsDAO {
    public void agregarNecesidades(int id, String value, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion, Categories category_id) throws PersistenceException;
}