package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.User;
import org.apache.ibatis.annotations.Param;

import java.sql.ResultSet;
import java.util.List;

public interface UserMapper {

    /**
     * Retorna una lista con la información de un usruaio consultado
     * @param username  es el username con el cual se consultaran los datos
     * @return List de tipo User
     */
    List<User> IngresarSesion(@Param("conusername")String username);

    List<User> NombreUsuario(@Param("id")int id);

}
