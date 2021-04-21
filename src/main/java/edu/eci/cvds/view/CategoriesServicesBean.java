package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.StatusServices;

import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@javax.faces.bean.ManagedBean(name = "categoryBean")
@SessionScoped
public class CategoriesServicesBean extends BasePageBean{

    private int id;
    private String value;
    private String description;
    private int status = 1;
    private Date creationdate;
    private Date modificationdate;
    private String oldvalue;
    private List<String> categories;
    private List<String> statuses;
    private String selectedStatus;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    /*public void status() throws ServicesException {
        try {
            List<Status>statuses1= statusServices.traerStatus();
            for (int i=0;i<statuses1.size();i++){
                statuses.add(statuses1.get(i).getValue());
            }
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria",ex);
        }
    }*/

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

    public void traerCategories() throws ServicesException {
        try {
            List<Categories>categories1=categoriesServices.traerCategories();
            for (int i=0;i<categories1.size();i++){
                categories.add(categories1.get(i).getValue());
            }
        } catch (ServicesException | PersistenceException ex) {
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

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getStatuses() {
        return this.statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }

    public String getSelectedStatus() {
        return this.selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }

    public StatusServices getStatusServices() {
        return this.statusServices;
    }

    public void setStatusServices(StatusServices statusServices) {
        this.statusServices = statusServices;
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
