package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.AnswersDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.AnswersMapper;
import edu.eci.cvds.entities.Answers;
import edu.eci.cvds.entities.Categories;

public class MyBatisAnswersDAO implements AnswersDAO {
    @Inject
    AnswersMapper answersMapper;

    @Override
    public void agregarRespuesta(Answers answer) throws PersistenceException {
        try {
            answersMapper.agregarRespuesta(answer);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al insertar nueva categoria: " + answer.getId(), e);
        }
    }
}
