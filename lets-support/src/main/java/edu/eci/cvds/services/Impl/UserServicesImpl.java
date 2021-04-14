package edu.eci.cvds.services.Impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.UserServiceException;
import edu.eci.cvds.services.UserServices;
import edu.eci.cvds.dao.UserDAO;
public class UserServicesImpl implements UserServices {

    @Inject
    private UserDAO userDAO;

    @Override
    public void addUser(int id, String fullName, String username, String passwd, Rol rol, boolean isActive){
        try {
            return userDAO.save();
        } catch (PersistenceException ex) {
            throw new UserServiceException("Something happend wrong :( , error when adding user"+id,ex);
        }
        
    }

    @Override
    public User seeUser(int id) throws UserServiceException {
        try {
            return userDAO.load();
        } catch (PersistenceException ex) {
            throw new UserServiceException("Something happend wrong :( , error when consulting user"+id,ex);
        } 
    }

    @Override
    public List<User> seeUsers() throws UserServiceException {
        try {
            return userDAO.seeUsers();
        } catch (PersistenceException ex) {
            throw new UserServiceException("Something happend wrong :( , error when consulting users",ex);
        } 
    }

    @Override
    public List<User> seeActiveUsers() throws UserServiceException {
        try {
            return userDAO.seeActiveUsers();
        } catch (PersistenceException ex) {
            throw new UserServiceException("Something happend wrong :( , error when consulting Active users",ex);
        } 
    }
    
}
