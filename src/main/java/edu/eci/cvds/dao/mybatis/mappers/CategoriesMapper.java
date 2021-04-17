package edu.eci.cvds.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CategoriesMapper {
    /**
     * Envia la información que viene de MyBatisCategoriesDAO hacia CategoriesMapper.xml, a través de param para registrar en la base de datos
     * @param id valor del id del elemento a registrar en categories
     * @param value nombre del elemento a registrar en categories
     * @param description descripcion del elemento a registrar en categories
     * @param status estado del elemento a registrar en categories
     * @param creationdate fecha en la que se crea el  elemento a registrar en categories
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en categories
     */
     void agregarCategoria(@Param("newid")int id,
                                @Param("newvalue") String value,
                                @Param("newdescription") String description,
                                @Param("newstatus") int status,
                                @Param("newcreationdate") Date creationdate,
                                @Param("newmodificationdate")Date modificationdate);

    /**
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param descripcion nueva descripción de la categoria que se va a modificar
     * @param estado nuevo estado de la categoria que se va a modificar
     */
    void ModificarCategoria(@Param("upvalue")String value,
                                    @Param("updescripcion") String descripcion,
                                    @Param("upestado") int estado);

    /**
     * Retorna una lista con los nombres de las categorias existentes que trae desde CategoriesMapper.xml
     * @return List
     */
    List<String> traerValuesCategories();

    /**
     * Retorna una lista con los ids de las categorias existentes que trae desde CategoriesMapper.xml
     * @return List
     */
    List<Integer> traerIdCategories();
}
