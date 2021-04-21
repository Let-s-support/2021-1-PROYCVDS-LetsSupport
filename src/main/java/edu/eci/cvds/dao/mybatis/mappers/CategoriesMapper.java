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
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de value
     * @param value nuevo nombre de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     */
    void ModificarValue(@Param("upvalue")String value,
                        @Param("oldvalue") String oldvalue);

    /**
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de description
     * @param descripcion nueva descripción de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     */
    void ModificarDescription(@Param("updescripcion") String descripcion,
                            @Param("oldvalue") String oldvalue);

    /**
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de status
     * @param estado nuevo estado de la categoria que se va a modificar
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     */
    void ModificarStatus(@Param("upestado") int estado,
                            @Param("oldvalue") String oldvalue);

    /**
     * Envia la información que viene de MyBatisCategories y lo envia a CategoriesMapper.xml para realizar la moficacion de date
     * @param oldvalue nombre por el medio del cual se esta consultando el dato que se va a cambiar
     */
    void ModificarDate(@Param("oldvalue") String oldvalue);

    /**
     * Retorna una lista con los nombres de las categorias existentes que trae desde CategoriesMapper.xml
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     */
    List<Categories> traerValuesCategories(@Param("oldvalue") String oldvalue);
    List<Categories> traerCategories();
}
