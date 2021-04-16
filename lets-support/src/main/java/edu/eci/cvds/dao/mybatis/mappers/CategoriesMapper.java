package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Status;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CategoriesMapper {
    public void agregarCategoria(@Param("newid")int id,
                                @Param("newvalue") String value,
                                @Param("newdescription") String descripcion,
                                @Param("newstatus") Status estado,
                                @Param("newcreationdate") Date fecha_creacion,
                                @Param("newmodificationdate")Date fecha_modificacion);
                    
    public void ModificarCategoria(@Param("upnombre")int nombre,
                                    @Param("updescripcion") String descripcion,
                                    @Param("upestado") Status estado);
       
}
