package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.RolesDAO;
import edu.eci.cvds.dao.mybatis.mappers.RolesMapper;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Roles;

import java.util.List;

public class MyBatisRolesDAO implements RolesDAO {
    @Inject
    RolesMapper rolesMapper;

    /**
     * Retorna los roles registrados en la base de datos
     * @return List de tipo Roles
     * @throws PersistenceException Controlador de errores de persistencia
     */
    @Override
    public List<Roles> traerRoles( ) throws PersistenceException {
        try {
            return rolesMapper.traerRoles();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }
}
