package edu.eci.cvds.dao.mybatis.mappers;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface NeedsMapper {
    /**
     * Envia la información que viene de MyBatisNeedsDAO hacia NeedsMapper.xml, a través de params para registrar en la base de datos
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     * @throws PersistenceException Controlador de errores de persistencia
     */
    void agregarNecesidades(@Param("need")Needs need) throws PersistenceException;

     /**
      * Retorna una lista de los registros que tengan el mismo campo value que el solicitado que trae desde NeedsMapper.xml
      * @param oldvalue nombre a verificar si existe en la tabla
      * @return List de tipo needs
      * @throws PersistenceException Controlador de errores de persistencia
      */
    List<Needs> traerValuesNeeds(@Param("oldvalue") String oldvalue) throws PersistenceException;

     /**
      * Retorna una lista con todas las necesidades que tiene registradas un usuario
      * @param idsolicitante id de quien esta intentando inscribir una nueva necesidad
      * @return List de tipo needs
      * @throws PersistenceException Controlador de errores de persistencia
      */
    List<Needs> cantidadNeedsUser(@Param("thisidsolicitante") int idsolicitante) throws PersistenceException;

     /**
      * Retorna todas las necesidades que sencuentren en estado 'Abierta' o 'En proceso'
      * @return List de tipo needs
      * @throws PersistenceException Controlador de errores de persistencia
      */
    List<Needs> NeedsToAnswer() throws PersistenceException;

     /**
      * Se encarga de enviar datos parametrizados al xml, los cuales trae desde la capa de mybatis, para modificar el estado de  la necesidad
      * @param value nombre de la necesidad que se va a modificar
      * @param newstatus nuevo estado de la necesidad
      * @throws PersistenceException Controlador de errores de persistencia
      */
    void  ModificarEstadoNeed(@Param("value") String value,
                                   @Param("newstatus") Integer newstatus)  throws PersistenceException ;

    /**
     * Obtiene todas las necesidades registradas
     * @return List de tipo needs
     * @throws PersistenceException Controlador de errores de persistencia
     */
    List<Needs> AllNeeds(@Param("id") int id,
                            @Param("rol") int rol) throws PersistenceException;

    List<Needs> AllNeedsFilterCategory(@Param("id") int id,
                                        @Param("rol") int rol,
                                       @Param("category") int category) throws PersistenceException;

    List<Needs> AllNeedsFilterStatus(@Param("id") int id,
                                     @Param("rol") int rol,
                                     @Param("status") int status) throws PersistenceException;

    List<Needs> AllNeedsFilterCategoryStatus(@Param("id") int id,
                                            @Param("rol") int rol,
                                            @Param("category") int category,
                                            @Param("status") int status) throws PersistenceException;

    List<Needs> NeedName(@Param("id") int id);
}
