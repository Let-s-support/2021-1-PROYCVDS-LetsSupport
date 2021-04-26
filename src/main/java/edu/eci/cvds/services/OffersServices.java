package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Offers;

import java.util.List;

public interface OffersServices {

    /**
     * Envia un objeto de tipo Offers el cual sera la nueva oferta que se esta creando, el cual proviene desde el categoriesBean y lo envia al impl para hacer la inserción
     * @param offer objeto que es la nueva oferta que se esta registrando
     * @throws ServicesException controlador de errores de la capa de services
     */
    void agregarOfertas(Offers offer) throws ServicesException;

    /**
     * Retorna una lista de los registros que contengan el mismo valor en el campo value , el cual lo trae desde el categoriesBean
     * @param oldvalue dato por el medio del cual condicionara la consulta
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Offers> traerValuesOffers(String oldvalue) throws ServicesException;

    /**
     * Retorna unba lista con las oferta que tiene registradas el usuario
     * @param idsolicitante id del usuario que esta intentando crear la nueva oferta
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Offers> cantidadOffersUser(int idsolicitante) throws ServicesException;

    /**
     * Función que envia datos parametrizados que provienen desde el impl a la capa de mybatis, para realizar la modificación del status de una oferta
     * @param value nombre de la oferta que se va a modificar
     * @param newstatus nuevo estado de la oferta a modificar
     * @throws ServicesException controlador de errores de la capa de services
     */
    void  ModificarEstadoOffer(String value,Integer newstatus)  throws ServicesException;

    /**
     * Retorna una lista de todas las ofertas registradas
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Offers> AllOffers() throws ServicesException;
}
