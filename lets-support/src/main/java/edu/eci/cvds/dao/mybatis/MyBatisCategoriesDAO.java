package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CategoriesMapper;
import edu.eci.cvds.entities.Status;

import java.util.Date;
import java.util.List;

public class MyBatisCategoriesDAO implements CategoriesDAO {
    @Inject
    CategoriesMapper categoriesMapper;

    /**
     * Envia la información que viene de CategoriesDAO hacia CategoriesMapper para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void agregarCategoria(int id, String value, String description, Status status, Date creationdate, Date modificationdate) throws PersistenceException {
        try {
            categoriesMapper.agregarCategoria(id,value,description,status,creationdate,modificationdate);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " + id, e);
        }
    }

    /**
     * Envia la información que viene de CategoriesDAO y lo envia a CategoriesMapper para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param descripcion nueva descripción de la categoria que se va a modificar
     * @param estado nuevo estado de la categoria que se va a modificar
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public void ModificarCategoria(String value, String descripcion, Status estado) throws PersistenceException {
        try {
            categoriesMapper.ModificarCategoria(value,descripcion,estado);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Retorna una lista con los nombres de las categorias existentes que llama desde CategoriesMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<String> traerValuesCategories() throws PersistenceException {
        try {
            return categoriesMapper.traerValuesCategories();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

    /**
     * Retorna una lista con los ids de las categorias existentes que llama desde CategoriesMapper
     * @return List
     * @throws PersistenceException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdCategories() throws PersistenceException {
        try {
            return categoriesMapper.traerIdCategories();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar ids", e);
        }
    }
}
