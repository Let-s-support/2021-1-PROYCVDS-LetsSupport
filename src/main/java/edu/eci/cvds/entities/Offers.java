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
     *
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
    public Offers() {
        super();
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }
}
