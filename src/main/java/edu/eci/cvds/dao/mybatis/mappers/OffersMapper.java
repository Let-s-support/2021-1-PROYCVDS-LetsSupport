package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OffersMapper {

    /**
     * Envia un objeto de tipo Offers el cual sera la nueva oferta que se esta creando, el cual proviene desde la capa de mybatis y lo envia al xml para hacer la inserción
     * @param offer objeto que es la nueva oferta que se esta registrando
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void agregarOfertas(@Param("offer") Offers offer) throws PersistenceException;

    /**
     * Retorna una lista de los registros que contengan el mismo valor en el campo value , el cual lo trae desde el xml
     * @param oldvalue dato por el medio del cual condicionara la consulta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> traerValuesOffers(@Param("oldvalue") String oldvalue) throws PersistenceException;

    /**
     * Retorna unba lista con las oferta que tiene registradas el usuario
     * @param idsolicitante id del usuario que esta intentando crear la nueva oferta
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> cantidadOffersUser(@Param("thisidsolicitante") int idsolicitante) throws PersistenceException;

    /**
     * Retorna una lista con las ofertas que se encuentran en estado 'Abierta' o 'En proceso'
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> OffersToAnswer() throws PersistenceException;

    /**
     * Función que envia datos parametrizados que provienen desde la capa de mybatis al xml, para realizar la modificación del status de una oferta
     * @param value nombre de la oferta que se va a modificar
     * @param newstatus nuevo estado de la oferta a modificar
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void  ModificarEstadoOffer(@Param("value") String value,
                              @Param("newstatus") Integer newstatus)  throws PersistenceException ;

    /**
     * Retorna una lista de todas las ofertas registradas
     * @return List de tipo Offers
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Offers> AllOffers(@Param("id") int id,
                           @Param("rol") int rol) throws PersistenceException;

    List<Offers> AllOffersFilterCategory(@Param("id") int id,
                                       @Param("rol") int rol,
                                       @Param("category") int category) throws PersistenceException;

    List<Offers> AllOffersFilterStatus(@Param("id") int id,
                                     @Param("rol") int rol,
                                     @Param("status") int status) throws PersistenceException;

    List<Offers> AllOffersFilterCategoryStatus(@Param("id") int id,
                                             @Param("rol") int rol,
                                             @Param("category") int category,
                                             @Param("status") int status) throws PersistenceException;

    List<Offers> OfferName(@Param("id") int id);
}

