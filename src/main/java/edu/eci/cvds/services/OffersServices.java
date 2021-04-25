package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Offers;

import java.util.List;

public interface OffersServices {
    void agregarOfertas(Offers offer) throws ServicesException;

    List<Offers> traerValuesOffers(String oldvalue) throws ServicesException;

    List<Offers> cantidadOffersUser(int idsolicitante) throws ServicesException;

    void  ModificarEstadoOffer(String value,Integer newstatus)  throws ServicesException;

    List<Offers> AllOffers() throws ServicesException;
}
