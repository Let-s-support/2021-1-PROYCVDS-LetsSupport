package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.MaxiumRequerements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaxiumRequerementsMapper {
    List<MaxiumRequerements> traerMaxiumOffers() throws PersistenceException;
    List<MaxiumRequerements> traerMaxiumNeeds() throws PersistenceException;
    void ModificarOffers(@Param("nmoffers") int moffers) throws PersistenceException;
    void ModificarNeeds(@Param("nmneeds") int mneeds) throws PersistenceException;
}
