package edu.eci.cvds.services.Impl;
import edu.eci.cvds.dao.OffersDAO;
import edu.eci.cvds.services.OffersServices;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class OffersServicesImpl implements OffersServices {
    @Inject
    OffersDAO  offersDAO;

    @Override
    public void RegistrarOferta(Offer oferta) throws ServicesException {
        try {
            List<Offers> values = traerValuesCategories(oferta.getValue());
            if (values.isEmpty()) {
                offersDAO.agregarOferta(oferta);
            }
            else{
                FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR, "Error la oferta ya existe");
            }
        } catch (PersistenceException ex) {
            throw new ServicesException("La oferta no pudo ser Registrada",ex);
        }
    }
    @Override
    public List<Offer> traerValuesOffers(String oldvalue) throws ServicesException {
            try {
                return offersDAO.traerValuesOffers(oldvalue);
            }catch (PersistenceException ex){
                FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR, "Error al Obtener Oferta");
                throw new ServicesException("Error al consultar ofertas",ex);
            }
        }
    @Override
    public List<Categories> traerOffers() throws ServicesException {
            try {
                return offersDAO.traerOffers();
            }catch (PersistenceException ex){
                FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR, "Error al Consultar Oferta");
                throw new ServicesException("Error al consultar Ofertas",ex);
            }
        }

    
}
