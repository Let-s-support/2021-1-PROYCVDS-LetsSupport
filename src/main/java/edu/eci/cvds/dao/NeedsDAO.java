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

    /**
     * Retorna una lista con todas las necesidades que tiene registradas un usuario
     * @param idsolicitante id de quien esta intentando inscribir una nueva necesidad
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Needs> cantidadNeedsUser(int idsolicitante) throws PersistenceException;

    /**
     * Retorna todas las necesidades que sencuentren en estado 'Abierta' o 'En proceso'
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Needs> NeedsToAnswer() throws PersistenceException;

    /**
     * Se encarga de enviar datos parametrizados a la capa de mybatis, los cuales provienen desde el impl para modificar el estado de  la necesidad
     * @param value nombre de la necesidad que se va a modificar
     * @param newstatus nuevo estado de la necesidad
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void  ModificarEstadoNeed(String value, Integer newstatus)  throws PersistenceException ;

    /**
     * Obtiene todas las necesidades registradas
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Needs> AllNeeds(int id, int rol) throws PersistenceException;

    List<Needs> NeedName(int id) throws PersistenceException;

}