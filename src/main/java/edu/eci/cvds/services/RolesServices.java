package edu.eci.cvds.services;

import edu.eci.cvds.entities.Roles;

import java.util.List;

public interface RolesServices {
    /**
     * Retorna los roles registrados en la base de datos
     * @return List de tipo Roles
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Roles> traerRoles() throws ServicesException;
}
