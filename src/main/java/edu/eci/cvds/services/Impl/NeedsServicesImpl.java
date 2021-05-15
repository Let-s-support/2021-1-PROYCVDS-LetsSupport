package edu.eci.cvds.services.Impl;

import com.google.inject.Inject;
import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.NeedsDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;
import org.apache.ibatis.annotations.Param;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public class NeedsServicesImpl implements NeedsServices {

    @Inject
    NeedsDAO needsDAO;

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de agregarNecesidades y la despliega en NeedsDAO
     * @param need objeto de tipo needs que leva los datos de la necesidad a crear
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void agregarNecesidades(Needs need) throws ServicesException {
        try {
            List<Needs> values = traerValuesNeeds(need.getValue());
            if (values.isEmpty()){
                needsDAO.agregarNecesidades(need);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Necesidad creada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
            else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                        "La necesidad ya existe");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    /**
     * Es usado por NeedsServices para desplegar la funcionalidad de traerValuesNeeds y asi obtener la información de los nombres de las needs existentes, la despliega en NeedsDAO
     * @param oldvalue nombre a verificar si existe en la tabla
     * @return List de tipo Needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Needs> traerValuesNeeds(String oldvalue) throws ServicesException {
        try {
            return needsDAO.traerValuesNeeds(oldvalue);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Retorna una lista con todas las necesidades que tiene registradas un usuario
     * @param idsolicitante id de quien esta intentando inscribir una nueva necesidad
     * @return List de tipo needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Needs> cantidadNeedsUser(int idsolicitante) throws ServicesException {
        try {
            return needsDAO.cantidadNeedsUser(idsolicitante);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Se encarga de enviar datos parametrizados a la capa de mybatis, los cuales provienen desde el impl para modificar el estado de  la necesidad
     * @param value nombre de la necesidad que se va a modificar
     * @param newstatus nuevo estado de la necesidad
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public void  ModificarEstadoNeed(String value, Integer newstatus) throws ServicesException {
        try {
            System.out.println(value+" "+newstatus);
            needsDAO.ModificarEstadoNeed(value, newstatus);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "Necesidad actulizada correctamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    /**
     * Obtiene todas las necesidades registradas
     * @return List de tipo needs
     * @throws ServicesException controlador de errores de la capa de services
     */
    @Override
    public List<Needs> AllNeeds(int id, int rol) throws ServicesException {
        try {
            return needsDAO.AllNeeds(id,rol);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterCategory(int id, int rol, int category)  throws PersistenceException {
        try {
            return needsDAO.AllNeedsFilterCategory(id, rol,category);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterStatus(int id, int rol, int status)  throws PersistenceException {
        try {
            return needsDAO.AllNeedsFilterStatus(id, rol,status);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> AllNeedsFilterCategoryStatus(int id, int rol, int category, int status)  throws PersistenceException {
        try {
            return needsDAO.AllNeedsFilterCategoryStatus(id, rol,category,status);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("No se pudo consultar los nombres", e);
        }
    }

    @Override
    public List<Needs> NeedName(int id) throws ServicesException{
        try {
            return needsDAO.NeedName(id);
        }catch (PersistenceException ex){
            throw new ServicesException("Error al consultar nombres",ex);
        }
    }

    @Override
    public List<Needs> NeedsToAnswer() throws ServicesException {
        try {
            return needsDAO.NeedsToAnswer();
        } catch (org.apache.ibatis.exceptions.PersistenceException | PersistenceException e) {
            throw new ServicesException("No se pudo consultar los nombres", e);
        }
    }
}
