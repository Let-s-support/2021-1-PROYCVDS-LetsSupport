package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;

import java.util.List;

public interface AnswersServices {

    void agregarRespuesta(Answers answer) throws ServicesException;

    List<Needs> NeedsToAnswer() throws ServicesException;

    List<Offers> OffersToAnswer() throws ServicesException;
}
