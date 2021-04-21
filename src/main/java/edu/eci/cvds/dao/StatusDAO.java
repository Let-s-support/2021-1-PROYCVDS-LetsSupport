package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public interface StatusDAO {
    List<Status> traerStatus( ) throws PersistenceException;
}
