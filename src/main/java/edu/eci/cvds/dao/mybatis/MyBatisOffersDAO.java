package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.OffersDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.NeedsMapper;
import edu.eci.cvds.dao.mybatis.mappers.OffersMapper;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;

import java.util.List;

public class MyBatisOffersDAO implements OffersDAO {
    @Inject
    OffersMapper offersMapper;

    @Override
    public void agregarOfertas(Offers offer) throws PersistenceException {
        try {
            offersMapper.agregarOfertas(offer);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
    }


    @Override
    public List<Offers> traerValuesOffers(String oldvalue) throws PersistenceException {
        try {
            return offersMapper.traerValuesOffers(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Offers> cantidadOffersUser(int idsolicitante) throws PersistenceException {
        try {
            return offersMapper.cantidadOffersUser(idsolicitante);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Offers> OffersToAnswer() throws PersistenceException {
        try {
            return offersMapper.OffersToAnswer();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public void ModificarEstadoOffer(String value, Integer newstatus)  throws PersistenceException {
        try {
            offersMapper.ModificarEstadoOffer(value,newstatus);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Offers> AllOffers()  throws PersistenceException {
        try {
            return offersMapper.AllOffers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
}
