package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.MaxiumRequerementsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.MaxiumRequerementsMapper;
import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public class MyBatisMaxiumRequerementsDAO implements MaxiumRequerementsDAO {
    @Inject
    MaxiumRequerementsMapper maxiumRequerementsMapper;

    /**
     * Retorna la maxima cantidad de ofertas que puede registrar un usuario
     * @return List de tipo MaxiumRequeriments
     * @throws PersistenceException controlador de errores de persistencia
     */
    @Override
    public List<MaxiumRequerements> traerMaxiumOffers( ) throws PersistenceException {
        try {
            return maxiumRequerementsMapper.traerMaxiumOffers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

    /**
     * Retorna la maxima cantidad de necesidades que puede registrar un usuario
     *  @return List de tipo MaxiumRequeriments
     *  @throws PersistenceException controlador de errores de persistencia
     */
    @Override
    public List<MaxiumRequerements> traerMaxiumNeeds() throws PersistenceException {
        try {
            return maxiumRequerementsMapper.traerMaxiumNeeds();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }

    /**
     * Modifica el maximo de ofertas que puede registrar un usuario
     * @param moffers nuevo maximo de ofertas que podra registrar un usuario
     * @throws PersistenceException controlador de errores de persistencia
     */
    @Override
    public void ModificarOffers(int moffers) throws PersistenceException {
        try {
            maxiumRequerementsMapper.ModificarOffers(moffers);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }

    /**
     * Modifica el maximo de necesidades que puede registrar un usuario
     * @param mneeds nuevo maximo de necesidades que podra registrar un usuario
     * @throws PersistenceException controlador de errores de persistencia
     */
    @Override
    public void ModificarNeeds(int mneeds) throws PersistenceException {
        try {
            maxiumRequerementsMapper.ModificarNeeds(mneeds);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }
}
