package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.NeedsMapper;
import edu.eci.cvds.entities.Categories;

import java.util.Date;
import java.util.List;

public class MyBatisNeedsDAO implements NeedsDAO {
    @Inject
    NeedsMapper needsMapper;

    /**
     * Envia la información que viene de MyBatisNeedsDAO hacia NeedsMapper, a través de params para registrar en la base de datos
     * @param id valor del id del elemento a registrar en needs
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @param creationdate fecha en la que se crea el  elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     * @Param urgencia urgencia que tiene la need
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en needs
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void agregarNecesidades(int id, String value, String description, int status, Date creationdate, Date modificationdate, int category_id, int urgencia) throws PersistenceException {
        try {
            needsMapper.agregarNecesidades(id, value, description, status, creationdate, modificationdate, category_id, urgencia);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
    }

    /**
     * Retorna una lista con los nombres de las necesidades existentes que llama desde NeedsMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<String> traerValuesNeeds() throws PersistenceException {
        try {
            return needsMapper.traerValuesNeeds();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna una lista con los ids de las necesidades existentes que llama desde NeedsMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdNeeds() throws PersistenceException {
        try {
            return needsMapper.traerIdNeeds();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los ID", e);
        }
    }
}
