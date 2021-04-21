package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;
import java.util.List;

public class CategoriesServicesImpl implements CategoriesServices {

    @Inject
    CategoriesDAO categoriesDAO;

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de traerValuesCategories y asi obtener la información de los nombres de las categorias existentes, lo despliega a CategoriesDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerValuesCategories(String oldvalue) throws ServicesException {
        try {
            return categoriesDAO.traerValuesCategories(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de agregarCategoria y lo despliega en CategoriesDAO
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void agregarCategoria(Categories categorie) throws ServicesException {
        try {
            List<String> values = traerValuesCategories(categorie.getValue());
            if (values.isEmpty()) {
                categoriesDAO.agregarCategoria(categorie);
            }
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de ModificarCategoria y lo despliega en CategoriesDAO
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     * @throws ServicesException controlador de excepciones
     */

    @Override
    public void ModificarCategoria(String value, String description, int status, String oldvalue) throws ServicesException {
        try {
            List values = traerValuesCategories(oldvalue);
            if (!values.isEmpty()) {
                if(!value.isEmpty()){
                    categoriesDAO.ModificarValue(value, oldvalue);
                }
                if(!description.isEmpty()){
                    categoriesDAO.ModificarDescription(description, oldvalue);
                }
                if (!(status ==0)){
                    categoriesDAO.ModificarStatus(status, oldvalue);
                }
                if(!value.isEmpty() || !description.isEmpty() || !(status ==0)){
                    categoriesDAO.ModificarDate(oldvalue);
                }

            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
    }


}
