package edu.eci.cvds.dao;

import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public interface MaxiumRequerementsDAO {
    List<MaxiumRequerements> traerMaxiumOffers( ) throws PersistenceException;
    List<MaxiumRequerements> traerMaxiumNeeds() throws PersistenceException;
    void ModificarOffers(int moffers) throws PersistenceException;
    void ModificarNeeds(int mneeds) throws PersistenceException;
}
