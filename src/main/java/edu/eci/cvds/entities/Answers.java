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

    public Answers (String value, String comentary, int type_id, int owner, boolean type){
        this.value=value;
        this.comentary=comentary;
        this.owner=owner;
        if(type){
            this.need_id=type_id;
            this.offer_id=0;
        }else {
            this.need_id=0;
            this.offer_id=type_id;
        }
    }

    public Answers(){
        super();
    }

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

    public String getComentary() {
        return comentary;
    }

    public void setComentary(String comentary) {
        this.comentary = comentary;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getNeed_id() {
        return need_id;
    }

    public void setNeed_id(int need_id) {
        this.need_id = need_id;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
