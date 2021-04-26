package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Offers implements Serializable {
    private int id;
    private String value;
    private String description;
    private int status;
    private Date creationdate;
    private Date modificationdate;
    private int category_id;
    private int idsolicitante;

    /**
     * Constructor del objeto con datos especificos
     * @param value nombre de la oferta
     * @param description  descripción de la oferta
     * @param status stado de la oferta
     * @param category_id categoria a la que pertenece la oferta
     * @param idsolicitante id del creador de la oferta
     */
    public Offers(String value, String description, int status, int category_id, int idsolicitante) {
        this.value = value;
        this.value = value;
        this.description = description;
        this.status = status;
        this.category_id = category_id;
        this.idsolicitante=idsolicitante;
    }

    /**
     * Constructor que dirige a la interfaz serializable
     */
    public Offers() {
        super();
    }

    /**
     * Concatena los datos del objeto en un string
     * @return String
     */
    @Override
    public String toString() {
        return "Offers{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creationdate=" + creationdate +
                ", modificationdate=" + modificationdate +
                ", category_id=" + category_id +
                ", idsolicitante=" + idsolicitante +
                '}';
    }

    /**
     * Obtiene el id de la oferta
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el id de la oferta
     * @param id nuevo id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la oferta
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Cambia el nombre de la oferta
     * @param value nuevo nombre de la oferta
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene la descripcion de la oferta
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia la descripcion de la oferta
     * @param description nueva descripcion de la oferta
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene el estado en el que se encuentra la oferta
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Cambia el estado de la oferta
     * @param status nuevo estado
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Obtiene la fecha de creacion de la oferta
     * @return Date
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * Modifica la fecha de creacion de la oferta
     * @param creationdate nueva fecha de creacion
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * Obtiene la fecha de modificacion de la oferta
     * @return Date
     */
    public Date getModificationdate() {
        return modificationdate;
    }

    /**
     * Modifica la fecha de modificacion de la oferta
     * @param modificationdate nueva fecha de modificaion
     */
    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    /**
     * Obtiene el id de la categoria a la que pertenece
     * @return int
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * Modifica el id de la categoria a lña que pertenece
     * @param category_id nuevo id de la categoria a la que pertenece
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * Obtiene el id del creador de la oferta
     * @return int
     */
    public int getIdsolicitante() {
        return idsolicitante;
    }

    /**
     * Modifica el id del creador de la ofderta
     * @param idsolicitante nuevo id del creador de la oferta
     */
    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }
}
