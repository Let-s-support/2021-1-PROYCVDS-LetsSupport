package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Categories;
import java.util.List;

public interface CategoriesDAO {
    /**
     * Envia la información que viene de CategoriesInterfaceImpl hacia CategoriesDAO para registrar en la base de datos
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     * @throws PersistenceException controlador de excepciones
     */
    void agregarCategoria(Categories categorie) throws PersistenceException;

    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de value
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    void ModificarValue(String value,String oldvalue) throws PersistenceException;

    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de description
     * @param description nueva descripción de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */

    void ModificarDescription(String description,String oldvalue) throws PersistenceException;

    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de status
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */

    void ModificarStatus(int status,String oldvalue) throws PersistenceException;

    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de date
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */

    void ModificarDate(String oldvalue) throws PersistenceException;

    /**
     * Retorna una lista con los nombres de las categorias existentes que llama desde CategoriesDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Categories> traerValuesCategories(String oldvalue) throws PersistenceException;
    List<Categories> traerCategories() throws PersistenceException;
}