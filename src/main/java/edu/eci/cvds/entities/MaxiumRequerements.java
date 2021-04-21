package edu.eci.cvds.entities;

import java.io.Serializable;

public class MaxiumRequerements implements Serializable {
    private int id;
    private int moffers;
    private int mneeds;

    public MaxiumRequerements() {
        super();
    }

    @Override
    public String toString() {
        return "MaxiumRequerements{" +
                "moffers=" + moffers +
                ", mneeds=" + mneeds +
                '}';
    }

    public int getMoffers() {
        return moffers;
    }

    public void setMoffers(int moffers) {
        this.moffers = moffers;
    }

    public int getMneeds() {
        return mneeds;
    }

    public void setMneeds(int mneeds) {
        this.mneeds = mneeds;
    }
}

