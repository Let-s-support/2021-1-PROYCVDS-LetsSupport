package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;

import java.util.Date;
import java.util.List;

public class NeedsServicesImpl implements NeedsServices {

    @Inject
    NeedsDAO needsDAO;

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de agregarNecesidades y la despliega en NeedsDAO
     * @param id valor del id del elemento a registrar en needs
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @param creationdate fecha en la que se crea el  elemento a registrar en needs
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     * @Param urgencia urgencia que tiene la need
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void agregarNecesidades(int id, String value, String description, int status, Date creationdate, Date modificationdate, Categories category_id, int urgencia) throws ServicesException {
        try {
            List<String> values = traerValuesNeeds();
            List<Integer> ids = traerIdNeeds();
            if (!values.contains(value) && !ids.contains(id)){
                needsDAO.agregarNecesidades(id, value, description, status, creationdate, modificationdate, category_id, urgencia);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la despliega en NeedsDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerValuesNeeds() throws ServicesException {
        try {
            return needsDAO.traerValuesNeeds();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de traerIdNeeds y asi obtener la información de los ids de las needs existentes, la despliega en NeedsDAO
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<Integer> traerIdNeeds() throws ServicesException {
        try {
            return needsDAO.traerIdNeeds();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar ids",ex);
        }
    }


}
