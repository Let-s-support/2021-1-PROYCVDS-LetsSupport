package edu.eci.cvds.services.Impl;
import com.google.inject.Inject;
import edu.eci.cvds.dao.OffersDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.OffersServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class OffersServicesImpl implements OffersServices {
    @Inject
    OffersDAO offersDAO;

    @Override
    public void agregarOfertas(Offers offer) throws ServicesException {
        try {
            List<Offers> values = traerValuesOffers(offer.getValue());
            if (values.isEmpty()){
                offersDAO.agregarOfertas(offer);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    @Override
    public List<Offers> traerValuesOffers(String oldvalue) throws ServicesException {
        try {
            return offersDAO.traerValuesOffers(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Offers> cantidadOffersUser(int idsolicitante) throws ServicesException {
        try {
            return offersDAO.cantidadOffersUser(idsolicitante);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public void  ModificarEstadoOffer(String value,Integer newstatus) throws ServicesException {
        try {
            offersDAO.ModificarEstadoOffer(value, newstatus);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Offers> AllOffers() throws ServicesException {
        try {
            return offersDAO.AllOffers();
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }
}
