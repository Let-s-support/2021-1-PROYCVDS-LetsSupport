package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

import java.util.Date;
import java.util.List;

public interface CategoriesServices {

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de agregarCategoria y la envia a CategoriesServicesImpl
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     * @throws ServicesException controlador de excepciones
     */
    void agregarCategoria(int id, String value, String description, int status, Date creationdate, Date modificationdate) throws ServicesException;

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de ModificarCategoria y la envia a CategoriesServicesImpl
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @throws ServicesException controlador de excepciones
     */
    void ModificarCategoria(String value, String description, int status) throws ServicesException;

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de traerValuesCategories y asi obtener la información de los nombres de las categorias existentes, la envia a CategoriesServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<String> traerValuesCategories() throws PersistenceException, ServicesException;

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de traerIdCategories y asi obtener la información de los ids de las categorias existentes, la envia a CategoriesServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<Integer> traerIdCategories() throws ServicesException;
}
