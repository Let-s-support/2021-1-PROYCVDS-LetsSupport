package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Needs implements Serializable {
    private int id;
    private String value;
    private String description;
    private int status;
    private Date creationdate;
    private Date modificationdate;
    private int category_id;
    private int urgencia;
    private int idsolicitante;

    /**
     * Constructor de needs el cual genera una nueva need
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     */
    public Needs(String value, String description, int status, int category_id, int urgencia, int idsolicitante) {
        this.value = value;
        this.value = value;
        this.description = description;
        this.urgencia = urgencia;
        this.status = status;
        this.category_id = category_id;
        this.urgencia = urgencia;
        this.idsolicitante=idsolicitante;
    }

    /**
     * Constructor de needs el cual hace super a la interfaz Serializable
     */
    public Needs() {
        super();
    }

    /**
     * Obtiene el Id de la need
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Convierte a cadena todos los datos de una need y la retorna
     * @return String
     */
    @Override
    public String toString() {
        return "Needs{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creationdate=" + creationdate +
                ", modificationdate=" + modificationdate +
                ", category_id=" + category_id +
                ", urgencia=" + urgencia +
                '}';
    }

    /**
     * Cambia el id de la need
     * @param id nuevo id de la need
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la need
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Cambia nombre de la need
     * @param value nuevo nombre de la need
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene descripcion de la need
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia descripción de la need
     * @param description nueva descripción para la need
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene estado de la need
     * @return Status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Cambia Status de la need
     * @param status nuevo status de la need
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Obtiene creationDate de la need
     * @return Date
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * Cambia creationdate de la need
     * @param creationdate nueva fecha de need
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * Obtiene modificationdate de la need
     * @return Date
     */
    public Date getModificationdate() {
        return modificationdate;
    }

    /**
     * Cambia modificationdate de la need
     * @param modificationdate nueva modificationdate de la need
     */
    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    /**
     * Obtiene getCategory_id de la need
     * @return Categories
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     * Cambia setCategory_id de la need
     * @param category_id nueva category_id de la need
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * Obtiene urgencia de la need
     * @return int
     */
    public int getUrgencia() {
        return urgencia;
    }

    /**
     * Cambia urgencia de la need
     * @param urgencia nueva urgencia de la need
     */
    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    /**
     * Obtiene el id de quien creo la necesidad
     * @return int
     */
    public int getIdsolicitante() {
        return idsolicitante;
    }

    /**
     * Modifica el id de quien creo la necesidad
     * @param idsolicitante nuevo id del creador de la necesidad
     */
    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }
}