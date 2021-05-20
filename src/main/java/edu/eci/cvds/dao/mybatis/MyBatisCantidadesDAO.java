package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CantidadesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CantidadesMapper;
import edu.eci.cvds.entities.Cantidades;

import java.util.List;

public class MyBatisCantidadesDAO implements CantidadesDAO {
    @Inject
    CantidadesMapper cantidadesMapper;

    @Override
    public List<Cantidades> solicitudes() throws PersistenceException {
        try {
            return cantidadesMapper.solicitudes();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }
}
