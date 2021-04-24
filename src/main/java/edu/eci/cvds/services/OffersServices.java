package edu.eci.cvds.services;
import edu.eci.cvds.entities.Offer;

public interface OffersServices {
    void RegistrarOferta(Offer offer) throws ServicesException;
    List<Offer> traerValuesOffers(String oldvalue) throws PersistenceException, ServicesException;
    public List<Categories> traerOffers() throws PersistenceException, ServicesException ;
}
