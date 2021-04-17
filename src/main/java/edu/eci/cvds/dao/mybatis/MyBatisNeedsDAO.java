package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.NeedsMapper;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;

import java.util.Date;
import java.util.List;

public class MyBatisNeedsDAO implements NeedsDAO {
    @Inject
    NeedsMapper needsMapper;

    /**
     * Envia la información que viene de MyBatisNeedsDAO hacia NeedsMapper, a través de params para registrar en la base de datos
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void agregarNecesidades(Needs need) throws PersistenceException {
        try {
            needsMapper.agregarNecesidades(need);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
    }

    /**
     * Retorna una lista con los nombres de las necesidades existentes que llama desde NeedsMapper
     * @return List
     * @param oldvalue nombre a verificar si existe en la tabla
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<String> traerValuesNeeds(String oldvalue) throws PersistenceException {
        try {
            return needsMapper.traerValuesNeeds(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
}
