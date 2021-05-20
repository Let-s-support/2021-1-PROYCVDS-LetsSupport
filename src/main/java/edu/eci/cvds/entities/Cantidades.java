package edu.eci.cvds.entities;

import java.io.Serializable;
import java.util.Date;

public class Cantidades implements Serializable {
    private int necesidades;
    private int ofertas;
    private int total;
    private int category_id;
    private String category;

    public Cantidades(int necesidades, int ofertas, int total, int category_id, String category) {
        this.necesidades = necesidades;
        this.ofertas = ofertas;
        this.total = total;
        this.category_id = category_id;
        this.category = category;
    }

    public Cantidades(){
            super();
    }

    public int getNecesidades() {
        return necesidades;
    }

    public void setNecesidades(int necesidades) {
        this.necesidades = necesidades;
    }

    public int getOfertas() {
        return ofertas;
    }

    public void setOfertas(int ofertas) {
        this.ofertas = ofertas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategoryid(int categoryid) {
        this.category_id = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Cantidades{" +
                "necesidades=" + necesidades +
                ", ofertas=" + ofertas +
                ", total=" + total +
                ", categoryid=" + category_id +
                ", category='" + category + '\'' +
                '}';
    }
}
