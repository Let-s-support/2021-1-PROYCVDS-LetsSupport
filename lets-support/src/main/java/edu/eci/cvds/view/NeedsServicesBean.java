package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;

import java.util.Date;
import java.util.List;

public class NeedsServicesBean {
    @Inject
    NeedsServices needsServices;

    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
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
    public void agregarNecesidades(int id, String value, String description, int status, Date creationdate, Date modificationdate, Categories category_id, int urgencia) throws ServicesException {
        try {
            needsServices.agregarNecesidades(id, value, description, status, creationdate, modificationdate, category_id, urgencia);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }
}
