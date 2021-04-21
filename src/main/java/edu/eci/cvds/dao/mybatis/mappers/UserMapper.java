package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;
import java.util.List;

public interface UserMapper {

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que trae desde UsersMapper.xml
     * @param username  es el username con el cual se consultaran los datos
     * @return String
     */
    List<User> IngresarSesion(@Param("conusername")String username);

}
