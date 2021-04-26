package edu.eci.cvds.services;

import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public interface StatusServices {
    /**
     * Retorna una lista con los tipos de status registrados
     * @return List de tipo Status
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Status> traerStatus() throws ServicesException;
}
