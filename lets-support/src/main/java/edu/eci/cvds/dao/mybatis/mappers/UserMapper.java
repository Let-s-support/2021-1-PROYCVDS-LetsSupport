package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Rol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * Envia la información que viene de MyBatisUsersDAO hacia UsersMapper.xml, a través de params para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param fullname nombre completo del usuario que se va a registrar
     * @param username username del usuario que se va a registrar
     * @param passwd contraseña del usuario que se va a registrar
     * @param rol rol que posee el usuario que se va a registrar
     * @param isactive estado del usuario
     * @param correo correo del usuario que se va a registrar
     */
     void agregarUsuario(@Param("newid")int id,
                                @Param("newfullname") String fullname,
                                @Param("newusername") String username,
                                @Param("newpasswd")String passwd,                                 
                                @Param("newrol") Rol rol,
                                @Param("newisactive")boolean isactive,
                                @Param("newcorreo")String correo);

    /**
     * Retorna un valor que es el password del usuario que intenta acceder que trae desde UsersMapper.xml
     * @param correo  correo con el cual se buscara el usuario
     * @return String
     */
     String IngresarSesion(@Param("concorreo")String correo);

    /**
     * Envia la información que viene de MyBatisUsersDAO hacia UsersMapper.xml, a través de params para modificar el rol del usuario
     * @param rol nuevo rol que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     */
    void ModificarRol(@Param("uprol")Rol rol,
                                @Param("upcorreo")String correo);

    /**
     * Envia la información que viene de MyBatisUsersDAO hacia UsersMapper.xml, a través de params para modificar el estado del usuario
     * @param isactive nuevo estado que tendra el usuario
     * @param correo correo con el cual se buscara el usuario
     */
    void EstadoUser(@Param("upisactive")boolean isactive,
                                @Param("upcorreo")String correo);

    /**
     * Retorna una lista con los usernames de los usuarios existentes que trae desde UsersMapper.xml
     * @return List
     */
    List<String> traerUserNameUsers();

    /**
     * Retorna una lista con los ids de los usuarios existentes que trae desde UsersMapper.xml
     * @return List
     */
    List<Integer> traerIdUsers();

    /**
     * Retorna una lista con los correos de los usuarios existentes que trae desde UsersMapper.xml
     * @return List
     */
    List<String> traerCorreoUsers();
}
