package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.AnswersServices;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.OffersServices;
import edu.eci.cvds.services.ServicesException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "answerBean")
@SessionScoped
public class AnswersServicesBean extends BasePageBean{
    
    @Inject
    AnswersServices answersServices;

    @Inject
    NeedsServices needsServices;

    @Inject
    OffersServices offersServices;

    private int id;
    private String type;
    private String value;
    private String comentary;
    private String description;
    private Date creationdate;
    private int offer_id;
    private int need_id;
    private int owner;
    private List<Offers> ofertas;
    private List<Needs> necesidades;
    private List<Answers> AllAnswers;

    public void agregarRespuesta(){
        try {
            if(this.type.equals("offer")){
                agregarRespuestaOffer();
            }else{
                agregarRespuestaNeed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para agregar una nueva respuesta de una necesidad
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarRespuestaNeed() throws ServicesException{
        Answers answer = new Answers(value, comentary, need_id,0, UserServicesBean.getId());
        answersServices.agregarRespuesta(answer);
    }

    /**
     * Metodo para agrefar una nueva respuesta de una oferta
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarRespuestaOffer() throws ServicesException{
        Answers answer = new Answers(value, comentary,0, offer_id, UserServicesBean.getId());
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
    public List<Answers> AllAnswers() throws ServicesException{
        try {
            AllAnswers=answersServices.AllAnswers();
            return AllAnswers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Answers>();
        }
    }
    public String clasifica(int offer_id, int need_id) throws ServicesException {
        System.out.println(offer_id);
        System.out.println(need_id);
        String res="Respuesta a";
        if (offer_id == 0){
            res+=" necesidad " + needsServices.NeedName(need_id).get(0).getValue();
        }else {
            res+=" oferta " + offersServices.OfferName(offer_id).get(0).getValue();
        }
        return res;
    }


    public void setData(String type, String name, String description, int id, int author){
        try {
            this.type = type;
            this.value = name;
            this.description = description;
            this.owner = author;
            if(this.type.equals("offer")){this.offer_id = id;}else this.need_id = id;
            FacesContext.getCurrentInstance().getExternalContext().redirect("createAnswer.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AnswersServices getAnswersServices() {
        return answersServices;
    }

    public void setAnswersServices(AnswersServices answersServices) {
        this.answersServices = answersServices;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComentary() {
        return this.comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getOffer_id() {
        return this.offer_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getNeed_id() {
        return this.need_id;
    }

    public void setNeed_id(int need_id) {
        this.need_id = need_id;
    }

    public int getOwner() {
        return this.owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public List<Offers> getOfertas() {
        return this.ofertas;
    }

    public void setOfertas(List<Offers> ofertas) {
        this.ofertas = ofertas;
    }

    public List<Needs> getNecesidades() {
        return this.necesidades;
    }

    public void setNecesidades(List<Needs> necesidades) {
        this.necesidades = necesidades;
    }


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
