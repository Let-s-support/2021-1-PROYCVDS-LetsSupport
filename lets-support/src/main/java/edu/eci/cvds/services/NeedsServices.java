package edu.eci.cvds.services;

import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;

import java.util.Date;
import java.util.List;

public interface NeedsServices {

    /**
     * Es usado por NeedsServicesBean para desplegar la funcionalidad de agregarNecesidades y la envia a NeedsServicesImpl
     * @param id valor del id del elemento a registrar en needs
     * @param value nombre del elemento a registrar en needs
     * @param description descripcion del elemento a registrar en needs
     * @param status estado del elemento a registrar en needs
     * @param creationdate fecha en la que se crea el  elemento a registrar en needs
     * @param modificationdate fecha de modificacion del  elemento, en este caso la fecha de creacion del elemento a registrar en needs
     * @Param category_id  Categoria a la que pertenece la need
     * @Param urgencia urgencia que tiene la need
     * @throws ServicesException controlador de excepciones
     */
    void agregarNecesidades(int id, String value, String description, Status status, Date creationdate, Date modificationdate, Categories category_id, int urgencia) throws ServicesException;

    /**
     * Es usado por NeedsServicesBean para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la envia a NeedsServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<String> traerValuesNeeds() throws ServicesException;

    /**
     * Es usado por NeedsServicesBean para desplegar la funcionalidad de traerIdNeeds y asi obtener la información de los ids de las needs existentes, la envia a NeedsServicesImpl
     * @return List
     * @throws ServicesException controlador de excepciones
     */
    List<Integer> traerIdNeeds() throws ServicesException;
}
