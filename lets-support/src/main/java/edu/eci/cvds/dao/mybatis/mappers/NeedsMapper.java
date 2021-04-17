package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categories;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NeedsMapper {
    /**
     * Envia la información que viene de MyBatisNeedsDAO hacia NeedsMapper.xml, a través de params para registrar en la base de datos
     * @param id valor del id del elemento a registrar en needs
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @param creationdate fecha en la que se crea el  elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     * @Param urgencia urgencia que tiene la need
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en needs
     */
     void agregarNecesidades(@Param("newid")int id,
                             @Param("newvalue") String value,
                             @Param("newdescription") String description,
                             @Param("newstatus") int status,
                             @Param("newcreationdate") Date creationdate,
                             @Param("newmodificationdate")Date modificationdate,
                             @Param("newcategory_id") Categories category_id,
                             @Param("newurgencia") int urgencia);

     /**
     * Retorna una lista con los nombres de las necesidades existentes que trae desde NeedsMapper.xml
     * @return List
     */
     List<String> traerValuesNeeds();

     /**
     * Retorna una lista con los ids de las necesidades existentes que trae desde NeedsMapper.xml
     * @return List
     */
     List<Integer> traerIdNeeds();
}
