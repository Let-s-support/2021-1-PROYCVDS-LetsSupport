package edu.eci.cvds.services;

import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public interface StatusServices {
    List<Status> traerStatus() throws ServicesException;
}
