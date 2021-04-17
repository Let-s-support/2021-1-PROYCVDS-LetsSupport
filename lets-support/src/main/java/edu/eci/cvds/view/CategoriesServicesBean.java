package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;

import java.util.Date;
import java.util.List;

public class CategoriesServicesBean extends BasePageBean{
    @Inject
    CategoriesServices categoriesServices;
    /**
     * Es usado para controlar la funcionalidad de crear categoria desde la interfaz
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     * @throws ServicesException controlador de excepciones
     */
    public void agregarCategoria(int id, String value, String description, int status, Date creationdate, Date modificationdate) throws ServicesException {
        try {
            categoriesServices.agregarCategoria(id, value, description, status, creationdate, modificationdate);
        } catch (ServicesException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Es usado controlar la funcionalidad de modificar datos de categoria desde la interfaz
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param description nueva descripción de la categoria que se va a modificar
     * @param status nuevo estado de la categoria que se va a modificar
     * @throws ServicesException controlador de excepciones
     */
    public void ModificarCategoria(String value, String description, int status) throws ServicesException {
        try {
            categoriesServices.ModificarCategoria(value, description, status);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
    }
}
