package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Rol;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public void agregarUsuario(@Param("newid")int id,
                                @Param("newfullname") String fullname,
                                @Param("newusername") String username,
                                @Param("newpasswd")String passwd,                                 
                                @Param("newrol") Rol rol,
                                @Param("newisactive")boolean isactive,
                                @Param("newcorreo")String correo);
                    
    public String IngresarSesion(@Param("concorreo")String correo);

    public void ModificarRol(@Param("uprol")Rol rol,
                                @Param("upcorreo")String correo);

    public void DesactivarUser(@Param("upisactive")boolean isactive,
                                @Param("upcorreo")String correo);
}
