package edu.eci.cvds.services;


import edu.eci.cvds.entities.Needs;
import java.util.List;

public interface NeedsServices {

    /**
     * Es usado por NeedsServicesBean para desplegar la funcionalidad de agregarNecesidades y la envia a NeedsServicesImpl
     * @param need objeto de tipo needs que lleva los datos de la necesidad a crear
     * @throws ServicesException controlador de excepciones
     */
    void agregarNecesidades(Needs need) throws ServicesException;

    /**
     * Es usado por para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la envia a NeedsServicesImpl
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<String> traerValuesNeeds(String oldvalue) throws ServicesException;

}
