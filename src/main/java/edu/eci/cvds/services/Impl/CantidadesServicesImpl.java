package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CantidadesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Cantidades;
import edu.eci.cvds.services.CantidadesServices;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class CantidadesServicesImpl implements CantidadesServices {
    @Inject
    CantidadesDAO cantidadesDAO;

    @Override
    public List<Cantidades> solicitudes() throws ServicesException {
        try {
            return cantidadesDAO.solicitudes();
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ServicesException("Error al consultar nombres", e);
        }
    }
}
