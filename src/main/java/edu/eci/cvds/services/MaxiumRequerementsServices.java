package edu.eci.cvds.services;

import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public interface MaxiumRequerementsServices {

    /**
     * Retorna la maxima cantidad de ofertas que puede registrar un usuario
     * @return List de tipo MaxiumRequeriments
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<MaxiumRequerements> traerMaxiumOffers() throws ServicesException;

    /**
     * Retorna la maxima cantidad de necesidades que puede registrar un usuario
     *  @return List de tipo MaxiumRequeriments
     *  @throws ServicesException controlador de errores de la capa de services
     */
    List<MaxiumRequerements> traerMaxiumNeeds() throws ServicesException;

    /**
     * Modifica el maximo de ofertas que puede registrar un usuario
     * @param moffers nuevo maximo de ofertas que podra registrar un usuario
     * @throws ServicesException controlador de errores de la capa de services
     */
    void ModificarOffers(int moffers) throws ServicesException;

    /**
     * Modifica el maximo de necesidades que puede registrar un usuario
     * @param mneeds nuevo maximo de necesidades que podra registrar un usuario
     * @throws ServicesException controlador de errores de la capa de services
     */
    void agregarNecesidades(int mneeds) throws ServicesException;
}
