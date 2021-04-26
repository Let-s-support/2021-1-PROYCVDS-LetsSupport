package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.AnswersServices;
import edu.eci.cvds.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "answerBean")
@SessionScoped
public class AnswersServicesBean {
    @Inject
    AnswersServices answersServices;

    private int id;
    private String value;
    private String comentary;
    private Date creationdate;
    private int offer_id;
    private int need_id;
    private int owner;
    private List<Offers> ofertas;
    private List<Needs> necesidades;

    /**
     * Metodo para agregar una nueva respuesta de una necesidad
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarRespuestaNeed() throws ServicesException{
        Answers answer = new Answers(value, comentary, need_id, owner, true);
        answersServices.agregarRespuesta(answer);
    }

    /**
     * Metodo para agrefar una nueva respuesta de una oferta
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarRespuestaOffer() throws ServicesException{
        Answers answer = new Answers(value, comentary, offer_id, owner, false);
        answersServices.agregarRespuesta(answer);
    }

    /**
     * Obtiene las necesidades que se encuentran en estado 'Activa' o 'En proceso'
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void NeedsToAnswer() throws ServicesException{
        necesidades=answersServices.NeedsToAnswer();
    }

    /**
     * Obtiene las ofertas que se enuentran en estado 'Activa' o 'En proceso'
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void OffersToAnswer() throws ServicesException{
        ofertas=answersServices.OffersToAnswer();
    }

}
