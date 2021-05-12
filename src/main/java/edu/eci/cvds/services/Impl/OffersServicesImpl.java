package edu.eci.cvds.services.Impl;
import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.OffersDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.OffersServices;
import edu.eci.cvds.services.ServicesException;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import java.util.List;

public class OffersServicesImpl implements OffersServices {
    @Inject
    OffersDAO offersDAO;

    /**
     * Envia un objeto de tipo Offers el cual sera la nueva oferta que se esta creando, el cual proviene desde el services y lo envia a la capa de DAO para hacer la inserción
     * @param offer objeto que es la nueva oferta que se esta registrando
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void agregarOfertas(Offers offer) throws ServicesException {
        try {
            List<Offers> values = traerValuesOffers(offer.getValue());
            if (values.isEmpty()){
                offersDAO.agregarOfertas(offer);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Oferta creada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La oferta ya existe");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    /**
     * Retorna una lista de los registros que contengan el mismo valor en el campo value , el cual lo trae desde la capa de DAO
     * @param oldvalue dato por el medio del cual condicionara la consulta
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Offers> traerValuesOffers(String oldvalue) throws ServicesException {
        try {
            return offersDAO.traerValuesOffers(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Retorna unba lista con las oferta que tiene registradas el usuario
     * @param idsolicitante id del usuario que esta intentando crear la nueva oferta
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Offers> cantidadOffersUser(int idsolicitante) throws ServicesException {
        try {
            return offersDAO.cantidadOffersUser(idsolicitante);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Función que envia datos parametrizados que provienen desde el impl a la capa de mybatis, para realizar la modificación del status de una oferta
     * @param value nombre de la oferta que se va a modificar
     * @param newstatus nuevo estado de la oferta a modificar
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void  ModificarEstadoOffer(String value,Integer newstatus) throws ServicesException {
        try {
            offersDAO.ModificarEstadoOffer(value, newstatus);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Retorna una lista de todas las ofertas registradas
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Offers> AllOffers(int id, int rol) throws ServicesException {
        try {
            return offersDAO.AllOffers(id,rol);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Offers> OfferName(int id) throws ServicesException{
        try {
            return offersDAO.OfferName(id);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Offers> OffersToAnswer() throws ServicesException {
        try {
            return offersDAO.OffersToAnswer();
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ServicesException("No se pudo consultar los nombres", e);
        }
    }

}
