package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;
import javax.faces.bean.ApplicationScoped;
import java.util.Date;

@javax.faces.bean.ManagedBean(name = "categoryBean")
@ApplicationScoped
public class CategoriesServicesBean extends BasePageBean{

    private int id;
    private String value;
    private String description;
    private int status = 1;
    private Date creationdate;
    private Date modificationdate;
    private String oldvalue;

    @Inject
    CategoriesServices categoriesServices;

    /**
     * Es usado para controlar la funcionalidad de crear categoria desde la interfaz
     * @throws ServicesException controlador de excepciones
     */
    public void agregarCategoria() throws ServicesException {
        try {
            Categories categorie = new Categories(value, description, status);
            categoriesServices.agregarCategoria(categorie);
        } catch (ServicesException ex) {
            throw new ServicesException("El item no esta registrado",ex);
        }
    }

    /**
     * Es usado controlar la funcionalidad de modificar datos de categoria desde la interfaz
     * @throws ServicesException controlador de excepciones
     */
    public void ModificarCategoria() throws ServicesException {
        try {
            categoriesServices.ModificarCategoria(value, description, status,oldvalue);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
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

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public CategoriesServices getCategoriesServices() {
        return categoriesServices;
    }

    public void setCategoriesServices(CategoriesServices categoriesServices) {
        this.categoriesServices = categoriesServices;
    }
}
