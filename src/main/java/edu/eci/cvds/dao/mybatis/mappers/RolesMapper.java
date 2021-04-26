package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolesMapper {
    /**
     * Retorna los roles registrados en la base de datos
     * @return List de tipo Roles
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Roles> traerRoles() throws PersistenceException;
}
