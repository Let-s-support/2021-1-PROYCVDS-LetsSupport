package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;

import java.util.Date;
import java.util.List;

public class CategoriesServicesImpl implements CategoriesServices {

    @Inject
    CategoriesDAO categoriesDAO;

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de traerValuesCategories y asi obtener la información de los nombres de las categorias existentes, lo despliega a CategoriesDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerValuesCategories() throws ServicesException {
        try {
            return categoriesDAO.traerValuesCategories();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de traerIdCategories y asi obtener la información de los ids de las categorias existentes, lo despliega a CategoriesDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdCategories() throws ServicesException {
        try {
            return categoriesDAO.traerIdCategories();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar ids",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de agregarCategoria y lo despliega en CategoriesDAO
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void agregarCategoria(int id, String value, String description, Status status, Date creationdate, Date modificationdate) throws ServicesException {
        try {
            List<String> values = traerValuesCategories();
            List<Integer> ids = traerIdCategories();
            if (!values.contains(value) && !ids.contains(id)) {
                categoriesDAO.agregarCategoria(id, value, description, status, creationdate, modificationdate);
            }
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de ModificarCategoria y lo despliega en CategoriesDAO
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param descripcion nueva descripción de la categoria que se va a modificar
     * @param estado nuevo estado de la categoria que se va a modificar
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void ModificarCategoria(String value, String descripcion, Status estado) throws ServicesException {
        try {
            List values = traerValuesCategories();
            if (!values.contains(value)) {
                categoriesDAO.ModificarCategoria(value, descripcion, estado);
            }
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
    }


}
