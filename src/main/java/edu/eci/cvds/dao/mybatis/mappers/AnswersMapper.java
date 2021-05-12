package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Needs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswersMapper {
    /**
     * Enlaza la capa mybatis de answer con el xml para crear una respuesta, sea de una necesidad o una oferta
     * @param answer objeto de tipo answer el cual sera la respuesta que se esta creando
     * @throws PersistenceException controlador de excepciones de persistencia
     */
    void agregarRespuesta(@Param("answer") Answers answer) throws PersistenceException;

    List<Answers> AllAnswers() throws PersistenceException;
}
