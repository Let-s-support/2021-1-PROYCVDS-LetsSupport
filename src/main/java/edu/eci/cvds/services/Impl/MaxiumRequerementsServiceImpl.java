package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.MaxiumRequerementsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.MaxiumRequerements;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.services.MaxiumRequerementsServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class MaxiumRequerementsServiceImpl implements MaxiumRequerementsServices {
    @Inject
    MaxiumRequerementsDAO maxiumRequerementsDAO;

    /**
     * Retorna la maxima cantidad de ofertas que puede registrar un usuario
     * @return List de tipo MaxiumRequeriments
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<MaxiumRequerements> traerMaxiumOffers() throws ServicesException {
        try {
            return maxiumRequerementsDAO.traerMaxiumOffers();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Retorna la maxima cantidad de necesidades que puede registrar un usuario
     *  @return List de tipo MaxiumRequeriments
     *  @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<MaxiumRequerements> traerMaxiumNeeds() throws ServicesException {
        try {
            return maxiumRequerementsDAO.traerMaxiumNeeds();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Modifica el maximo de ofertas que puede registrar un usuario
     * @param moffers nuevo maximo de ofertas que podra registrar un usuario
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void ModificarOffers(int moffers) throws ServicesException {
        try {
            maxiumRequerementsDAO.ModificarOffers(moffers);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }

    /**
     * Modifica el maximo de necesidades que puede registrar un usuario
     * @param mneeds nuevo maximo de necesidades que podra registrar un usuario
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void agregarNecesidades(int mneeds) throws ServicesException {
        try {
            maxiumRequerementsDAO.ModificarNeeds(mneeds);
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }
}
