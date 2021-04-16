package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Status;

import java.util.Date;

public class MyBatisCategoriesDAO implements CategoriesDAO {
    @Inject
    private CategoriesDAO categoriesDAO;


    @Override
    public void agregarCategoria(int id, String value, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion) throws PersistenceException {
        try {
            categoriesDAO.agregarCategoria(id,value,descripcion,estado,fecha_creacion,fecha_modificacion);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " + id, e);
        }
    }

    @Override
    public void ModificarCategoria(int nombre, String descripcion, Status estado) throws PersistenceException {
        try {
            categoriesDAO.ModificarCategoria(nombre,descripcion,estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }
}
