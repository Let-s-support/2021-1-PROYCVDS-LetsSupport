package edu.eci.cvds.entities;

import java.io.Serializable;

public class Status implements Serializable {
    private int id;
    private String value;

    /**
     * Constructor que se dirige a la interfaz serializable
     */
    public Status() {
        super();
    }

    /**
     *  Realiza la concatenacion de los datos del objeto como un string
     * @return
     */
    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     * Obtiene el id del estado
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el id del estado
     * @param id nuevo id del estado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Modifica el nombre del estado
     * @param value nuevo nomber del estado
     */
    public void setValue(String value) {
        this.value = value;
    }
}
