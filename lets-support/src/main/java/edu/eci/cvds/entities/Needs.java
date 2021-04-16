package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Needs implements Serializable {
    private int id;
    private String value;
    private String description;
    private Status status;
    private Date creationdate;
    private Date modificationdate;
    private Categories category_id;
    private int urgencia;

    public Needs(int id, String value, String description, Status status, Date creationdate, Date modificationdate, Categories category_id, int urgencia) {
        this.id = id;
        this.value = value;
        this.value = value;
        this.description = description;
        this.urgencia = urgencia;
        this.status = status;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
        this.category_id = category_id;
        this.urgencia = urgencia;
    }
}