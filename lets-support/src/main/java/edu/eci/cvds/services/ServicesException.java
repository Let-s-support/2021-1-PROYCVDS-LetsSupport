package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

public class ServicesException extends Exception{
    public ServicesException(String string, PersistenceException ex) {
        super(string);
    }
}
