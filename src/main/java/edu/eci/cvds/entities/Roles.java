package edu.eci.cvds.entities;

import java.io.Serializable;

public class Roles implements Serializable {
    private int id;
    private String value;

    public Roles() {
        super();
    }
    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", value='" + value + '\'' +
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
}
