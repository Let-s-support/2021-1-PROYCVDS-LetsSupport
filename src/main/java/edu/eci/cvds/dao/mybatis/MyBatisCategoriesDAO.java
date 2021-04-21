package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CategoriesMapper;
import edu.eci.cvds.entities.Categories;
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
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de value
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarValue(String value,String oldvalue) throws PersistenceException {
        try {
            categoriesMapper.ModificarValue(value,oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de description
     * @param description nueva descripción de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarDescription(String description,String oldvalue) throws PersistenceException {
        try {
            categoriesMapper.ModificarDescription(description,oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de status
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarStatus(int status,String oldvalue) throws PersistenceException {
        try {
            categoriesMapper.ModificarStatus(status,oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de los valores de date
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarDate(String oldvalue) throws PersistenceException {
        try {
            categoriesMapper.ModificarDate(oldvalue);
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
    public List<String> traerValuesCategories(String oldvalue) throws PersistenceException {
        try {
            return categoriesMapper.traerValuesCategories(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

}
