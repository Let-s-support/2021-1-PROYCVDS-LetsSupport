package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;

import java.util.Date;
import java.util.List;

public class NeedsServicesBean extends BasePageBean{
    @Inject
    NeedsServices needsServices;

    private int id;
    private String value;
    private String description;
    private int status;
    private Date creationdate;
    private Date modificationdate;
    private int category_id;
    private int urgencia;
    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
     * @throws ServicesException controlador de excepciones
     */
    public void agregarNecesidades() throws ServicesException {
        try {
            Needs need = new Needs(value, description, status, category_id, urgencia);
            needsServices.agregarNecesidades(need);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al agregar la necesidad",ex);
        }
    }

    public NeedsServices getNeedsServices() {
        return needsServices;
    }

    public void setNeedsServices(NeedsServices needsServices) {
        this.needsServices = needsServices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }
}
