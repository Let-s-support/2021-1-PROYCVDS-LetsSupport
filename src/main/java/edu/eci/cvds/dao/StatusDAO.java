package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public interface StatusDAO {
    /**
     * Retorna una lista con los tipos de status registrados
     * @return List de tipo Status
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Status> traerStatus() throws PersistenceException;
}
