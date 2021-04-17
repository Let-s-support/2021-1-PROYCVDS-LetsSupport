package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.entities.Categories;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CategoriesMapper {
    /**
     * Envia la información que viene de MyBatisCategoriesDAO hacia CategoriesMapper.xml, a través de param para registrar en la base de datos
     * @param categorie objeto de tipo categoria, que contiene los datos de la nueva categoria que se va a crear
     */
     void agregarCategoria(@Param("category") Categories categorie);

    /**
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de los valores de la categoria
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param descripcion nueva descripción de la categoria que se va a modificar
     * @param estado nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     */
    void ModificarCategoria(@Param("upvalue")String value,
                                    @Param("updescripcion") String descripcion,
                                    @Param("upestado") int estado,
                                    @Param("oldvalue") String oldvalue);

    /**
     * Retorna una lista con los nombres de las categorias existentes que trae desde CategoriesMapper.xml
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     */
    List<String> traerValuesCategories(@Param("oldvalue") String oldvalue);
}
