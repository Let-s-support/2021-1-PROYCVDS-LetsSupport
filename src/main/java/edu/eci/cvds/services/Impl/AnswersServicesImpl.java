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

    public void agregarRespuesta(Answers answer) throws ServicesException {
        try {
            answersDAO.agregarRespuesta(answer);
        }catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    public List<Needs> NeedsToAnswer() throws  ServicesException {
        try{
            return needsDAO.NeedsToAnswer();
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    public List<Offers> OffersToAnswer() throws ServicesException {
        try{
            return offersDAO.OffersToAnswer();
        } catch (PersistenceException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }
}
