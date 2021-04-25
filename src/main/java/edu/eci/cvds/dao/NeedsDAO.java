package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Needs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NeedsDAO {
    /**
     * Envia la información que viene de NeedsServicesImpl hacia MyBatisNeedsDAO, a través de params para registrar en la base de datos
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     * @throws PersistenceException controlador de excepciones
     */
    void agregarNecesidades(Needs need) throws PersistenceException;

    /**
     * Retorna una lista con los nombres de las necesidades existentes que llama desde MyBatisNeedsDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Needs> traerValuesNeeds(String oldvalue) throws PersistenceException;

    List<Needs> cantidadNeedsUser(int idsolicitante) throws PersistenceException;

    List<Needs> NeedsToAnswer() throws PersistenceException;

    void  ModificarEstadoNeed(String value, Integer newstatus)  throws PersistenceException ;

    List<Needs> AllNeeds() throws PersistenceException;
}