package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OffersDAO {

    /**
     * Envia un objeto de tipo Offers el cual sera la nueva oferta que se esta creando, el cual proviene desde el impl y lo envia a la capa de mybatis para hacer la inserción
     * @param offer objeto que es la nueva oferta que se esta registrando
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void agregarOfertas(Offers offer) throws PersistenceException;

    /**
     * Retorna una lista de los registros que contengan el mismo valor en el campo value , el cual lo trae desde la capa de mybatis
     * @param oldvalue dato por el medio del cual condicionara la consulta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> traerValuesOffers(String oldvalue) throws PersistenceException;

    /**
     * Retorna unba lista con las oferta que tiene registradas el usuario
     * @param idsolicitante id del usuario que esta intentando crear la nueva oferta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> cantidadOffersUser(int idsolicitante) throws PersistenceException;

    /**
     * Retorna una lista con las ofertas que se encuentran en estado 'Abierta' o 'En proceso'
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> OffersToAnswer() throws PersistenceException;

    /**
     * Función que envia datos parametrizados que provienen desde el impl a la capa de mybatis, para realizar la modificación del status de una oferta
     * @param value nombre de la oferta que se va a modificar
     * @param newstatus nuevo estado de la oferta a modificar
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void  ModificarEstadoOffer(String value,Integer newstatus)  throws PersistenceException ;

    /**
     * Retorna una lista de todas las ofertas registradas
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> AllOffers() throws PersistenceException;

}
