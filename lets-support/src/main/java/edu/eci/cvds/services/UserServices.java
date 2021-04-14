package edu.eci.cvds.services;
import java.util.List;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.User;

public interface UserServices {
    
    /**
   * @obj add user to Database
   * @param id user Identifier
   * @param fullName first and last User name 
   * @param username short name
   * @param passwd unique password identified
   * @param rol rol as Student, Professor, administrative, graduate, administrator
   * @param isActive if the user is active in the system
   * @throws UserServiceException if the information is not complete or if the identifier already exists
   */
    public abstract void addUser(int id, String fullName, String username, String passwd, Rol rol, boolean isActive) throws UserServiceException;

    /**
   * @obj see user' info 
   * @param id user Identifier
   * @return Basic User info  identified by 'id' 
   * @throws UserServiceException If identifier is wrong
   */   
    public abstract User seeUser(int id) throws UserServiceException;
    //public abstract User seeRolUser() throws UserServiceException;

    /**
   * @obj see user's info 
   * @return List with Basic Users info 
   * @throws UserServiceException 
   */   
    public abstract List<User> seeUsers() throws UserServiceException;

    
    /**
   * @obj see which users are active or inactive in the system
   * @return List with id,fullname,username and user state
   * @throws UserServiceException 
   */   
    public abstract List<User> seeActiveUsers() throws UserServiceException;
}