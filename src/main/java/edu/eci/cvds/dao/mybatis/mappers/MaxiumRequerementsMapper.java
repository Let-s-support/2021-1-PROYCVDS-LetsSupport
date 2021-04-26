package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.MaxiumRequerements;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaxiumRequerementsMapper {
    /**
     * Retorna la maxima cantidad de ofertas que puede registrar un usuario
     * @return List de tipo MaxiumRequeriments
     * @throws PersistenceException controlador de errores de persistencia
     */
    List<MaxiumRequerements> traerMaxiumOffers() throws PersistenceException;

    /**
     * Retorna la maxima cantidad de necesidades que puede registrar un usuario
     *  @return List de tipo MaxiumRequeriments
     *  @throws PersistenceException controlador de errores de persistencia
     */
    List<MaxiumRequerements> traerMaxiumNeeds() throws PersistenceException;

    /**
     * Modifica el maximo de ofertas que puede registrar un usuario
     * @param moffers nuevo maximo de ofertas que podra registrar un usuario
     * @throws PersistenceException controlador de errores de persistencia
     */
    void ModificarOffers(@Param("nmoffers") int moffers) throws PersistenceException;

    /**
     * Modifica el maximo de necesidades que puede registrar un usuario
     * @param mneeds nuevo maximo de necesidades que podra registrar un usuario
     * @throws PersistenceException controlador de errores de persistencia
     */
    void ModificarNeeds(@Param("nmneeds") int mneeds) throws PersistenceException;
}
