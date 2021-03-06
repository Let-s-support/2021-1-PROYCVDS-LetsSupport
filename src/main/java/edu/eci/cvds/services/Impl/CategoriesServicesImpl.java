package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CantidadesDAO;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Cantidades;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;
import org.primefaces.PrimeFaces;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CategoriesServicesImpl implements CategoriesServices {

    @Inject
    CategoriesDAO categoriesDAO;



    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de traerValuesCategories y asi obtener la información de los nombres de las categorias existentes, lo despliega a CategoriesDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List de tipo categories
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Categories> traerValuesCategories(String oldvalue) throws ServicesException {
        try {
            return categoriesDAO.traerValuesCategories(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Es usado por CategoriesServices para desplegar la funcionalidad de agregarCategoria y lo despliega en CategoriesDAO
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void agregarCategoria(Categories categorie) throws ServicesException {
        try {
            List<Categories> values = traerValuesCategories(categorie.getValue());
            if (values.isEmpty()) {
                categoriesDAO.agregarCategoria(categorie);
            }else{
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La catagoria ya existe"));
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
     * @throws ServicesException controlador de errores de la capa de services@throws ServicesException controlador de excepciones
     */

    @Override
    public void ModificarCategoria(String value, String description, boolean status, String oldvalue) throws ServicesException {
        try {
            List values = traerValuesCategories(oldvalue);
            if (values.isEmpty()) {
                categoriesDAO.ModificarCategoria(value, description, status, oldvalue);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Categoria actulizada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            else {
                FacesMessage message =new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La catagoria ya existe");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
    }

    /**
     * Retorna todos los registros de categories de la base de datos, obtiene los datos a traves de la capa del DAO
     * @return Lst de tipo categories
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Categories> traerCategories() throws ServicesException {
        try {
            return categoriesDAO.traerCategories();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Categories> nameCategorie(int id) throws ServicesException{
        try {
            return categoriesDAO.nameCategorie(id);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public void EliminarCategoria(String value) throws ServicesException {
        try {
            categoriesDAO.EliminarCategoria(value);
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ServicesException("Error al consultar nombres", e);
        }
    }

    @Override
    public List<Categories> categoriaInvalida(int id) throws ServicesException {
        try {
            return categoriesDAO.categoriaInvalida(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ServicesException("Error al consultar nombres", e);
        }
    }


}
