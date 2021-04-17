package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;
import java.util.List;

public class NeedsServicesImpl implements NeedsServices {

    @Inject
    NeedsDAO needsDAO;

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de agregarNecesidades y la despliega en NeedsDAO
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public void agregarNecesidades(Needs need) throws ServicesException {
        try {
            List<String> values = traerValuesNeeds(need.getValue());
            if (values.isEmpty()){
                needsDAO.agregarNecesidades(need);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la despliega en NeedsDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    @Override
    public List<String> traerValuesNeeds(String oldvalue) throws ServicesException {
        try {
            return needsDAO.traerValuesNeeds(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

}
