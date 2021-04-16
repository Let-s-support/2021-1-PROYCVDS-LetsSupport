package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;

import java.util.Date;

public class MyBatisNeedsDAO implements NeedsDAO {
    @Inject
    private MyBatisNeedsDAO myBatisNeedsDAO;

    @Override
    public void agregarNecesidades(int id, String value, String descripcion, Status estado, Date fecha_creacion, Date fecha_modificacion, Categories category_id) throws PersistenceException {
        try {
            myBatisNeedsDAO.agregarNecesidades(id, value, descripcion, estado, fecha_creacion, fecha_modificacion, category_id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
    }
}
