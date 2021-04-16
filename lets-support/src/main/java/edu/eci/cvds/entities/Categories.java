package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Categories implements Serializable {
    private int id;
    private String value;
    private String description;
    private Status status;
    private Date creationdate;
    private Date modificationdate;

    public Categories(int id, String value, String description, Status status, Date creationdate, Date modificationdate) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.status = status;
        this.creationdate = creationdate;
        this.modificationdate = modificationdate;
    }
}