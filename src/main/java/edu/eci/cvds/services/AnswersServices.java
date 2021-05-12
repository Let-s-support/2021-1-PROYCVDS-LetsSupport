package edu.eci.cvds.services;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;

import java.util.List;

public interface AnswersServices {

    /**
     * Metodo que se comunica con el metodo agregarRespuesta de answer del impl para agregar la respuesta
     * @param answer objeto de tipo Answers , el cual es la respuesta que se desea registrar
     * @throws ServicesException controlador de errores de la capa de services
     */
    void agregarRespuesta(Answers answer) throws ServicesException;

    /**
     * Metodo que se comunica con el metodo NeedsToAnswer de answer del impl para agregar la respuesta
     * @return List de tipo Needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Needs> NeedsToAnswer() throws ServicesException;

    /**
     * Metodo que se comunica con el metodo OffersToAnswer de answer del impl para agregar la respuesta
     * @return List de tipo Offers
     * @throws ServicesException controlador de errores de la capa de services
     */
    List<Offers> OffersToAnswer() throws ServicesException;

    List<Answers> AllAnswers() throws ServicesException;
}
