package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Roles;

import java.util.List;

public interface RolesDAO {

    /**
     * Retorna los roles registrados en la base de datos
     * @return List de tipo Roles
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Roles> traerRoles() throws PersistenceException;
}
