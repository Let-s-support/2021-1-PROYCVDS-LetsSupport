package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.StatusDAO;
import edu.eci.cvds.dao.mybatis.mappers.RolesMapper;
import edu.eci.cvds.dao.mybatis.mappers.StatusMapper;
import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public class MyBatisStatusDAO implements StatusDAO {
    @Inject
    StatusMapper statusMapper;
    @Override
    public List<Status> traerStatus( ) throws PersistenceException {
        try {
            return statusMapper.traerStatus();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
}
