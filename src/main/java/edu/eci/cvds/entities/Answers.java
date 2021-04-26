package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Answers implements Serializable {
    private int id;
    private String value;
    private String comentary;
    private Date creationdate;
    private int offer_id;
    private int need_id;
    private int owner;

    /**
     * Constructor del objeto con ciertos datos especificos
     * @param value nombre de la erspuesta
     * @param comentary comentario que se va a crear
     * @param type_id id dew la necesidad o la oferta a la que se le realiza el comentario
     * @param owner id de quien realizo el comentario
     * @param type tipo que indica si es una respuesta para una necesidad o para una oferta
     */
    public Answers (String value, String comentary, int need_id,int offer_id, int owner){
        this.value=value;
        this.comentary=comentary;
        this.owner=owner;
        this.need_id=need_id;
        this.offer_id=offer_id;
    }

    /**
     * Constructor que se dirige a la interfaz del serializable
     */
    public Answers(){
        super();
    }

    /**
     * Conversor de los datos del objeto a una unica cadena
     * @return String
     */
    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", comentary='" + comentary + '\'' +
                ", creationdate=" + creationdate +
                ", offer_id=" + offer_id +
                ", need_id=" + need_id +
                ", owner=" + owner +
                '}';
    }


    /**
     * Retorna el id del objeto
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el id
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la answers
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Modifica el value del answer
     * @param value nuevo velue del answers
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Retorna el comentary
     * @return String
     */
    public String getComentary() {
        return comentary;
    }

    /**
     * Modifica el comentary
     * @param comentary nuevo comentary
     */
    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    /**
     * Obtiene la fecha de creacion del comentario
     * @return Date
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * Modifica la fecha de creacion del answer
     * @param creationdate nueva fecha de creacion
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * Obtiene el id de la oferta a la que pertenece
     * @return int
     */
    public int getOffer_id() {
        return offer_id;
    }

    /**
     * Modifica el id de la oferta a la que pertenece
     * @param offer_id nuevo id de la categoria
     */
    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    /**
     * Obtiene el id de la necesidad a la que pertenece
     * @return int
     */
    public int getNeed_id() {
        return need_id;
    }

    /**
     * Modifica el id de la necesidad a la que pertenece
     * @param need_id nuevo id de la necesidad a la que pertenece
     */
    public void setNeed_id(int need_id) {
        this.need_id = need_id;
    }

    /**
     * Obtiene el id del dueño del answer
     * @return int
     */
    public int getOwner() {
        return owner;
    }

    /**
     * Modifica el id del dueño del answer
     * @param owner nuevo id del dueño
     */
    public void setOwner(int owner) {
        this.owner = owner;
    }
}
