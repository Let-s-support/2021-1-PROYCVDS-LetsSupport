package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Cantidades;
import edu.eci.cvds.entities.Categories;
import org.apache.ibatis.annotations.Param;

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
    /**
     * Envia la información que viene de CategoriesInterfaceImpl y lo envia a CategoriesDAO para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    void ModificarCategoria(String value, String description, boolean status, String oldvalue) throws PersistenceException;

    /**
     * Retorna una lista con los nombres de las categorias existentes que llama desde el mybatis
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    List<Categories> traerValuesCategories(String oldvalue) throws PersistenceException;

    /**
     * Retorna todos los registros de categories de la base de datos, obtiene los datos a traves del mybatis
     * @return Lst de tipo categories
     */
    List<Categories> traerCategories() throws PersistenceException;

    List<Categories> nameCategorie(int id) throws PersistenceException;

    void EliminarCategoria(String value) throws PersistenceException;

    List<Categories> categoriaInvalida(int id) throws PersistenceException;


}