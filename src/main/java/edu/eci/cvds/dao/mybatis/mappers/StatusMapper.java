package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Roles;
import edu.eci.cvds.entities.Status;

import java.util.List;

public interface StatusMapper {
    List<Status> traerStatus() throws PersistenceException;
}
