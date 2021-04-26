package edu.eci.cvds.dao;

import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public interface MaxiumRequerementsDAO {

    /**
     * Retorna la maxima cantidad de ofertas que puede registrar un usuario
     * @return List de tipo MaxiumRequeriments
     * @throws PersistenceException controlador de errores de persistencia
     */
    List<MaxiumRequerements> traerMaxiumOffers( ) throws PersistenceException;

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
    void ModificarOffers(int moffers) throws PersistenceException;

    /**
     * Modifica el maximo de necesidades que puede registrar un usuario
     * @param mneeds nuevo maximo de necesidades que podra registrar un usuario
     * @throws PersistenceException controlador de errores de persistencia
     */
    void ModificarNeeds(int mneeds) throws PersistenceException;
}
