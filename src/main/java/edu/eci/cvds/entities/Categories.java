package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Categories implements Serializable {
    private int id;
    private String value;
    private String description;
    private boolean status;
    private Date creationdate;
    private Date modificationdate;
    private boolean invalida;
    private boolean eliminada;
    private String comentarioinvalida;


    /**
     * Constructor de categories el cual genera una nueva category
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     */
    public Categories(String value, String description, boolean status,boolean invalida, boolean eliminada, String comentarioinvalida) {
        this.value = value;
        this.description = description;
        this.status = status;
        this.invalida=invalida;
        this.eliminada=eliminada;
        this.comentarioinvalida=comentarioinvalida;
    }

    /**
     * Constructos de categories el cual hace super a la interfaz Serializable
     */
    public Categories(){
        super();
    }

    /**
     * Convierte a cadena todos los datos de una category y la retorna
     * @return String
     */
    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creationdate=" + creationdate +
                ", modificationdate=" + modificationdate +
                ", invalida=" + invalida +
                ", eliminada=" + eliminada +
                ", comentarioinvalida='" + comentarioinvalida + '\'' +
                '}';
    }

    /**
     * Obtiene el Id de la category
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el id de la category
     * @param id nuevo id de la category
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la category
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Cambia nombre de la cateogry
     * @param value nuevo nombre de la category
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtiene descripcion de la category
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia descripción de la category
     * @param description nueva descripción para la category
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene estado de la category
     * @return Status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Cambia Status de la category
     * @param status nuevo status de la category
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Obtiene creationDate de la category
     * @return Date
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * Cambia creationdate de la category
     * @param creationdate nueva fecha de creacion
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * Obtiene modificationdate de la category
     * @return Date
     */
    public Date getModificationdate() {
        return modificationdate;
    }

    /**
     * Cambia modificationdate de la category
     * @param modificationdate nueva modificationdate de la category
     */
    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isInvalida() {
        return invalida;
    }

    public void setInvalida(boolean invalida) {
        this.invalida = invalida;
    }

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public String getComentarioinvalida() {
        return comentarioinvalida;
    }

    public void setComentarioinvalida(String comentarioinvalida) {
        this.comentarioinvalida = comentarioinvalida;
    }
}