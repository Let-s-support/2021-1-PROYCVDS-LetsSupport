package edu.eci.cvds.services;

import edu.eci.cvds.entities.Roles;

import java.util.List;

public interface RolesServices {
    List<Roles> traerRoles() throws ServicesException;
}
