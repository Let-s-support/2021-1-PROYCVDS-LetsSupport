package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.*;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.AnswersServices;
import edu.eci.cvds.services.ServicesException;

import java.util.List;

public class AnswersServicesImpl implements AnswersServices {
    @Inject
    OffersDAO offersDAO;

    @Inject
    NeedsDAO needsDAO;

    @Inject
    AnswersDAO answersDAO;

    /**
     * Metodo que se comunica con el metodo agregarRespuesta de answer de la capa DAO para agregar la respuesta
     * @param answer objeto de tipo Answers , el cual es la respuesta que se desea registrar
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarRespuesta(Answers answer) throws ServicesException {
        try {
            answersDAO.agregarRespuesta(answer);
        }catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Metodo que se comunica con el metodo NeedsToAnswer de Needs de la capa DAO
     * @return List de tipo Needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    public List<Needs> NeedsToAnswer() throws  ServicesException {
        try{
            return needsDAO.NeedsToAnswer();
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Metodo que se comunica con el metodo OffersToAnswer de Offers de la capa DAO
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    public List<Offers> OffersToAnswer() throws ServicesException {
        try{
            return offersDAO.OffersToAnswer();
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }
}
