package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OffersDAO {
    void agregarOfertas(Offers offer) throws PersistenceException;

    List<Offers> traerValuesOffers(String oldvalue) throws PersistenceException;

    List<Offers> cantidadOffersUser(int idsolicitante) throws PersistenceException;

    List<Offers> OffersToAnswer() throws PersistenceException;

    void  ModificarEstadoOffer(String value,Integer newstatus)  throws PersistenceException ;

    List<Offers> AllOffers() throws PersistenceException;

}
