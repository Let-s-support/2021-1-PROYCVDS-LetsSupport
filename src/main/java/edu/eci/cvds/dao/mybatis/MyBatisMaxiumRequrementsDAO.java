package edu.eci.cvds.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.mybatis.mappers.CategoriesMapper;
import edu.eci.cvds.dao.mybatis.mappers.MaxiumRequerementsMapper;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public class MyBatisMaxiumRequrementsDAO implements MaxiumRequerementsMapper {
    @Inject
    MaxiumRequerementsMapper maxiumRequerementsMapper;
    @Override
    public List<MaxiumRequerements> traerMaxiumOffers( ) throws PersistenceException {
        try {
            return maxiumRequerementsMapper.traerMaxiumOffers();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }
    @Override
    public List<MaxiumRequerements> traerMaxiumNeeds() throws PersistenceException {
        try {
            return maxiumRequerementsMapper.traerMaxiumNeeds();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar nombres", e);
        }
    }
    @Override
    public void ModificarOffers(int moffers) throws PersistenceException {
        try {
            maxiumRequerementsMapper.ModificarOffers(moffers);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }
    @Override
    public void ModificarNeeds(int mneeds) throws PersistenceException {
        try {
            maxiumRequerementsMapper.ModificarNeeds(mneeds);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al modificar la categoria", e);
        }
    }
}
