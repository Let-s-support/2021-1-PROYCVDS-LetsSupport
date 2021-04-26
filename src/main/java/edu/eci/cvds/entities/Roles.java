package edu.eci.cvds.entities;

import java.io.Serializable;

public class Roles implements Serializable {
    private int id;
    private String value;

    /**
     * Constructor que se dirige a la interfaz serializable
     */
    public Roles() {
        super();
    }

    /**
     * Realiza la concatenacion de los datos del objeto como un string
     */
    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    /**
     * Obtiene el id del rol
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el id del rol
     * @param id nuevo id del rol
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del rol
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Modifica el nombre del rol
     * @param value nuevo nombre del rol
     */
    public void setValue(String value) {
        this.value = value;
    }
}
