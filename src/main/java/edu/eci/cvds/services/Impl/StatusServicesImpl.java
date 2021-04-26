package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.dao.StatusDAO;
import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.StatusServices;

import java.util.List;

public class StatusServicesImpl implements StatusServices {
    @Inject
    StatusDAO statusDAO;

    /**
     * Retorna una lista con los tipos de status registrados
     * @return List de tipo Status
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Status> traerStatus() throws ServicesException {
        try {
            return statusDAO.traerStatus();
        } catch (PersistenceException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }
}
