package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Answers;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    void agregarRespuesta(@Param("answer") Answers answer) throws PersistenceException;
}
