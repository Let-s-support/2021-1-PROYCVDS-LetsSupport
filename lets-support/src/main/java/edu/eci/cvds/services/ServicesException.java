package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

public class ServicesException extends Exception{
    public ServicesException(String message){
        super(message);
    }

    public ServicesException(String message, Exception e) {
        super(message+e.toString());
    }
}
