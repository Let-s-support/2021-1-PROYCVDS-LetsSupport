package edu.eci.cvds.services;


import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NeedsServices {

    /**
     * Es usado por NeedsServicesBean para desplegar la funcionalidad de agregarNecesidades y la envia a NeedsServicesImpl
     * @param need objeto de tipo needs que lleva los datos de la necesidad a crear
     * @throws ServicesException controlador de excepciones
     */
    void agregarNecesidades(Needs need) throws ServicesException;

    /**
     * Es usado por para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la envia a NeedsServicesImpl
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<Needs> traerValuesNeeds(String oldvalue) throws ServicesException;

    /**
     * Retorna una lista con todas las necesidades que tiene registradas un usuario
     * @param idsolicitante id de quien esta intentando inscribir una nueva necesidad
     * @return List de tipo needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Needs> cantidadNeedsUser(int idsolicitante) throws ServicesException;

    /**
     * Se encarga de enviar datos parametrizados a la capa de mybatis, los cuales provienen desde el impl para modificar el estado de  la necesidad
     * @param value nombre de la necesidad que se va a modificar
     * @param newstatus nuevo estado de la necesidad
     * @throws ServicesException controlador de errores de la capa de services
     */
    void  ModificarEstadoNeed(String value, Integer newstatus)  throws ServicesException;

    /**
     * Obtiene todas las necesidades registradas
     * @return List de tipo needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Needs> AllNeeds(int id, int rol) throws PersistenceException, ServicesException;

    List<Needs> AllNeedsFilterCategory(int id, int rol, int category)  throws PersistenceException;

    List<Needs> AllNeedsFilterStatus(int id, int rol, int status)  throws PersistenceException;

    List<Needs> AllNeedsFilterCategoryStatus(int id, int rol, int category, int status)  throws PersistenceException;


    List<Needs> NeedName(int id) throws ServicesException;

    List<Needs> NeedsToAnswer() throws ServicesException;

}
