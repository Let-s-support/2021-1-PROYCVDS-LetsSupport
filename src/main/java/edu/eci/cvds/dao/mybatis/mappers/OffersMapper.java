package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OffersMapper {

    void agregarOfertas(@Param("offer") Offers offer) throws PersistenceException;

    List<Offers> traerValuesOffers(@Param("oldvalue") String oldvalue) throws PersistenceException;

    List<Offers> cantidadOffersUser(@Param("thisidsolicitante") int idsolicitante) throws PersistenceException;

    List<Offers> OffersToAnswer() throws PersistenceException;

    void  ModificarEstadoOffer(@Param("value") String value,
                              @Param("newstatus") Integer newstatus)  throws PersistenceException ;

    List<Offers> AllOffers() throws PersistenceException;
}

