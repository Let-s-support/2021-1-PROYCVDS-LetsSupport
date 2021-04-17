package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que trae desde UsersMapper.xml
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     */
    List<String> IngresarSesion(@Param("concorreo")String correo,
                                 @Param("conpasswd")String passwd);

}
