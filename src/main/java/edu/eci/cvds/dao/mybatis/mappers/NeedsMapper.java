package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NeedsMapper {
    /**
     * Envia la información que viene de MyBatisNeedsDAO hacia NeedsMapper.xml, a través de params para registrar en la base de datos
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     */
     void agregarNecesidades(@Param("need")Needs need);

     /**
     * Retorna una lista con los nombres de las necesidades existentes que trae desde NeedsMapper.xml
      * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     */
     List<String> traerValuesNeeds(@Param("oldvalue") String oldvalue);

}
