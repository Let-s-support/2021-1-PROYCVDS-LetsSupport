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

    /**
     * Envia un objeto de tipo Offers el cual sera la nueva oferta que se esta creando, el cual proviene desde la capa de DAO y lo envia al mapper para hacer la inserción
     * @param offer objeto que es la nueva oferta que se esta registrando
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public void agregarOfertas(Offers offer) throws PersistenceException {
        try {
            offersMapper.agregarOfertas(offer);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva necesidad", e);
        }
    }

    /**
     * Retorna una lista de los registros que contengan el mismo valor en el campo value , el cual lo trae desde el mapper
     * @param oldvalue dato por el medio del cual condicionara la consulta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Offers> traerValuesOffers(String oldvalue) throws PersistenceException {
        try {
            return offersMapper.traerValuesOffers(oldvalue);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna unba lista con las oferta que tiene registradas el usuario
     * @param idsolicitante id del usuario que esta intentando crear la nueva oferta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Offers> cantidadOffersUser(int idsolicitante) throws PersistenceException {
        try {
            return offersMapper.cantidadOffersUser(idsolicitante);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna una lista con las ofertas que se encuentran en estado 'Abierta' o 'En proceso'
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Offers> OffersToAnswer() throws PersistenceException {
        try {
            return offersMapper.OffersToAnswer();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Función que envia datos que provienen desde la capa de mDAO a la capa de los mappers, para realizar la modificación del status de una oferta
     * @param value nombre de la oferta que se va a modificar
     * @param newstatus nuevo estado de la oferta a modificar
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public void ModificarEstadoOffer(String value, Integer newstatus)  throws PersistenceException {
        try {
            offersMapper.ModificarEstadoOffer(value,newstatus);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    /**
     * Retorna una lista de todas las ofertas registradas
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Offers> AllOffers()  throws PersistenceException {
        try {
            return offersMapper.AllOffers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
}
