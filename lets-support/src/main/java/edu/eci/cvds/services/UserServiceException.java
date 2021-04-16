package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;

public class UserServiceException  extends Exception{
    public UserServiceException(String string, PersistenceException ex) {
        super(string);
    }
}
