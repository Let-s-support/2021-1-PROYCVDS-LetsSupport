package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Answers;

public interface AnswersDAO {
    /**
     * Enlaza el impl de answer con la capa de mybatis para crear una respuesta, sea de una necesidad o una oferta
     * @param answer objeto de tipo answer el cual sera la respuesta que se esta creando
     * @throws PersistenceException controlador de excepciones de persistencia
     */
    void agregarRespuesta(Answers answer) throws PersistenceException;
}
