package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.NeedsMapper;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
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
    public List<Needs> traerValuesNeeds(String oldvalue) throws PersistenceException {
        try {
            return needsMapper.traerValuesNeeds(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna una lista con todas las necesidades que tiene registradas un usuario
     * @param idsolicitante id de quien esta intentando inscribir una nueva necesidad
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Needs> cantidadNeedsUser(int idsolicitante) throws PersistenceException {
        try {
            return needsMapper.cantidadNeedsUser(idsolicitante);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna todas las necesidades que sencuentren en estado 'Abierta' o 'En proceso'
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Needs> NeedsToAnswer() throws PersistenceException {
        try {
            return needsMapper.NeedsToAnswer();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Se encarga de enviar datos al mapper, los cuales trae desde la capa de DAO, para modificar el estado de  la necesidad
     * @param value nombre de la necesidad que se va a modificar
     * @param newstatus nuevo estado de la necesidad
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public void ModificarEstadoNeed(String value, Integer newstatus)  throws PersistenceException {
        try {
            System.out.println(value+" "+newstatus);
            needsMapper.ModificarEstadoNeed(value,newstatus);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Obtiene todas las necesidades registradas
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Needs> AllNeeds(int id, int rol)  throws PersistenceException {
        try {
            return needsMapper.AllNeeds(id, rol);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterCategory(int id, int rol, int category)  throws PersistenceException {
        try {
            return needsMapper.AllNeedsFilterCategory(id, rol,category);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterStatus(int id, int rol, int status)  throws PersistenceException {
        try {
            return needsMapper.AllNeedsFilterStatus(id, rol,status);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterCategoryStatus(int id, int rol, int category, int status)  throws PersistenceException {
        try {
            return needsMapper.AllNeedsFilterCategoryStatus(id, rol,category,status);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> NeedName(int id) throws PersistenceException {
        try {
            return needsMapper.NeedName(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }
}
