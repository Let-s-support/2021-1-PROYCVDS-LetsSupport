package edu.eci.cvds.entities;

import java.io.Serializable;

public class MaxiumRequerements implements Serializable {
    private int id;
    private int moffers;
    private int mneeds;

    /**
     * Constructor que dirige hacia la interfaz del serializable
     */
    public MaxiumRequerements() {
        super();
    }

    /**
     * Concatena todos los valores y devuelve un string con todos los datos del objeto
     * @return String
     */
    @Override
    public String toString() {
        return "MaxiumRequerements{" +
                "moffers=" + moffers +
                ", mneeds=" + mneeds +
                '}';
    }

    /**
     * Obtiene el nuemero maximo de ofertas que puede registrar un usuario
     * @return int
     */
    public int getMoffers() {
        return moffers;
    }

    /**
     * Modifica la cantidad maxima de ofertas que puede realizar un usuario
     * @param moffers nuevo nuemero maximo de ofertas
     */
    public void setMoffers(int moffers) {
        this.moffers = moffers;
    }

    /**
     * Obtiene el numero maximo de necesidades que puede realizar un usario
     * @return int
     */
    public int getMneeds() {
        return mneeds;
    }

    /**
     * Modifica el numero maximo de necesidades que puede realizar un usuario
     * @param mneeds nuevo numero maximo de necesidades
     */
    public void setMneeds(int mneeds) {
        this.mneeds = mneeds;
    }
}

