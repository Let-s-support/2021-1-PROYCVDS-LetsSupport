package edu.eci.cvds.dao;

import jdk.internal.org.jline.utils.Status;

import java.util.Date;
import java.util.List;

public interface CategoriesDAO {
    /**
     * Envia la información que viene de CategoriesInterfaceImpl hacia CategoriesDAO para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     * @throws PersistenceException controlador de excepciones
     */
    void agregarCategoria(int id, String value, String description, int status, Date creationdate, Date modificationdate) throws PersistenceException;

    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @throws PersistenceException controlador de excepciones
     */
    void ModificarCategoria(String value, String description, int status) throws PersistenceException;

    /**
     * Retorna una lista con los nombres de las categorias existentes que llama desde CategoriesDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<String> traerValuesCategories() throws PersistenceException;

    /**
     * Retorna una lista con los ids de las categorias existentes que llama desde CategoriesDAO
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Integer> traerIdCategories() throws PersistenceException;
}