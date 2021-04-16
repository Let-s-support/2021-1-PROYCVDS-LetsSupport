package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface NeedsMapper {
    public void agregarNecesidades(@Param("newid")int id,
                                    @Param("newvalue") String value,
                                    @Param("newdescription") String descripcion,
                                    @Param("newstatus") Status estado,
                                    @Param("newcreationdate") Date fecha_creacion,
                                    @Param("newmodificationdate")Date fecha_modificacion,
                                    @Param("newcategory_id") Categories category_id);
}
