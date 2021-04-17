package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que trae desde UsersMapper.xml
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     */
     String IngresarSesion(@Param("concorreo")String correo);

}
