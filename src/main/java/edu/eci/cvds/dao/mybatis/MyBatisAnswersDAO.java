package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.AnswersDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.AnswersMapper;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;

import java.util.List;

public class MyBatisAnswersDAO implements AnswersDAO {
    @Inject
    AnswersMapper answersMapper;

    /**
     * Enlaza la capa DAO de answer con el mapper para crear una respuesta, sea de una necesidad o una oferta
     * @param answer objeto de tipo answer el cual sera la respuesta que se esta creando
     * @throws PersistenceException controlador de excepciones de persistencia
     */
    @Override
    public void agregarRespuesta(Answers answer) throws PersistenceException {
        try {
            answersMapper.agregarRespuesta(answer);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " + answer.getId(), e);
        }
    }

    @Override
    public  List<Answers> AllAnswers() throws PersistenceException {
        try {
            return answersMapper.AllAnswers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " , e);
        }
    }
}
