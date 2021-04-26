package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.RolesServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class RolesServicesImpl implements RolesServices {
    @Inject
    RolesDAO rolesDAO;

    /**
     * Retorna los roles registrados en la base de datos
     * @return List de tipo Roles
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Roles> traerRoles() throws ServicesException {
        try {
            return rolesDAO.traerRoles();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }
}
