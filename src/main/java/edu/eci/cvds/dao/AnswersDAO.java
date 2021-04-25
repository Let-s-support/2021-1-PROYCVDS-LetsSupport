package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Answers;

public interface AnswersDAO {
    void agregarRespuesta(Answers answer) throws PersistenceException;
}
