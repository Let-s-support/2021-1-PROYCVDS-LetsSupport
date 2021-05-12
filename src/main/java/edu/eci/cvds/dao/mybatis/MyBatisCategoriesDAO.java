package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CategoriesMapper;
import edu.eci.cvds.entities.Categories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class MyBatisCategoriesDAO implements CategoriesDAO {
    @Inject
    CategoriesMapper categoriesMapper;

    /**
     * Envia la información que viene de CategoriesDAO hacia CategoriesMapper para registrar en la base de datos
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void agregarCategoria(Categories categorie) throws PersistenceException {
        try {
            categoriesMapper.agregarCategoria(categorie);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " + categorie.getId(), e);
        }
    }

    /**
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarCategoria(String value, String description, boolean status,String oldvalue) throws PersistenceException {
        try {
            categoriesMapper.ModificarCategoria(value,description,status,oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Retorna una lista con los nombres de las categorias existentes que llama desde CategoriesMapper
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<Categories> traerValuesCategories(String oldvalue) throws PersistenceException {
        try {
            return categoriesMapper.traerValuesCategories(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

    /**
     * Retorna todos los registros de categories de la base de datos, obtiene los datos a traves del mapper
     * @return Lst de tipo categories
     */
    @Override
    public List<Categories> traerCategories() throws PersistenceException {
        try {
            return categoriesMapper.traerCategories();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

    @Override
    public List<Categories> nameCategorie(int id) throws PersistenceException {
        try {
            return categoriesMapper.nameCategorie(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }
}
