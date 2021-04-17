package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Categories;

import java.util.Date;
import java.util.List;

public interface NeedsDAO {
    /**
     * Envia la información que viene de NeedsServicesImpl hacia MyBatisNeedsDAO, a través de params para registrar en la base de datos
     * @param id valor del id del elemento a registrar en needs
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @param creationdate fecha en la que se crea el  elemento a registrar en needs
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     * @Param urgencia urgencia que tiene la need
     * @throws PersistenceException controlador de excepciones
     */
    void agregarNecesidades(int id, String value, String description, int status, Date creationdate, Date modificationdate, Categories category_id, int urgencia) throws PersistenceException;

    /**
     * Retorna una lista con los nombres de las necesidades existentes que llama desde MyBatisNeedsDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<String> traerValuesNeeds() throws PersistenceException;

    /**
     * Retorna una lista con los ids de las necesidades existentes que llama desde MyBatisNeedsDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Integer> traerIdNeeds() throws PersistenceException;
}