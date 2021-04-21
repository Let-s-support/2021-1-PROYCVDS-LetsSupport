package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Roles;

import java.util.List;

public interface RolesDAO {
    List<Roles> traerRoles() throws PersistenceException;
}
