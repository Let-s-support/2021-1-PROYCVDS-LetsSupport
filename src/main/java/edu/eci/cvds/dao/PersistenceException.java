package edu.eci.cvds.dao;

public class PersistenceException extends Exception{
    private static final long serialVersionUID = 1L;

    public PersistenceException(String message, Exception e) {
        super(message+e.toString());
    }
    public PersistenceException(String msg) {
        super(msg);
    }
}