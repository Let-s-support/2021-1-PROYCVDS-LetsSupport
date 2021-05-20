package edu.eci.cvds.services;

import edu.eci.cvds.entities.Cantidades;

import java.util.List;

public interface CantidadesServices {
    List<Cantidades> solicitudes() throws ServicesException;
}
