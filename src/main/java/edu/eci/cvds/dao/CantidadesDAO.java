package edu.eci.cvds.dao;

import edu.eci.cvds.entities.Cantidades;

import java.util.List;

public interface CantidadesDAO {
    List<Cantidades> solicitudes() throws PersistenceException;
}
