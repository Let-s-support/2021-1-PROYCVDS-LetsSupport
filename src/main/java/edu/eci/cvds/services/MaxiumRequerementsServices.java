package edu.eci.cvds.services;

import edu.eci.cvds.entities.MaxiumRequerements;

import java.util.List;

public interface MaxiumRequerementsServices {
    List<MaxiumRequerements> traerMaxiumOffers() throws ServicesException;
    List<MaxiumRequerements> traerMaxiumNeeds() throws ServicesException;
    void ModificarOffers(int moffers) throws ServicesException;
    void agregarNecesidades(int mneeds) throws ServicesException;
}
