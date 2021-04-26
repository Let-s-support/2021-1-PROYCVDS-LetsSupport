package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import java.util.List;

public interface CategoriesServices {

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de agregarCategoria y la envia a CategoriesServicesImpl
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     * @throws ServicesException controlador de excepciones
     */
    void agregarCategoria(Categories categorie) throws ServicesException;

    /**
     * Es usado por CategoriesServicesBean para desplegar la funcionalidad de ModificarCategoria y la envia a CategoriesServicesImpl
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws ServicesException controlador de excepciones
     */
    void ModificarCategoria(String value, String description, boolean status, String oldvalue) throws ServicesException;

    /**
     * Es usado para desplegar la funcionalidad de traerValuesCategories y asi obtener la información de los nombres de las categorias existentes, la envia a CategoriesServicesImpl
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List de tipo categories
     * @throws ServicesException controlador de excepciones
     */
    List<Categories> traerValuesCategories(String oldvalue) throws PersistenceException, ServicesException;

    /**
     * Retorna todos los registros de categories de la base de datos, obtiene los datos a traves del impl
     * @return Lst de tipo categories
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Categories> traerCategories() throws PersistenceException, ServicesException;
}
