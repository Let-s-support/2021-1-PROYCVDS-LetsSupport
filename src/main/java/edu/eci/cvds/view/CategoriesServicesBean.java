package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.services.CategoriesServices;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.StatusServices;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@javax.faces.bean.ManagedBean(name = "categoryBean")
@RequestScoped
public class CategoriesServicesBean extends BasePageBean {

    private int id;
    private String value;
    private String description;
    private boolean status = true;
    private Date creationdate;
    private Date modificationdate;
    private String oldvalue;
    private static List<String> categories;
    public static List<Integer> categories_id;
    public static List<Categories> allCategories;
    private List<String> statuses;
    private String selectedStatus;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    public void handleChange() throws ServicesException{
        value = allCategories.get(categories.indexOf(oldvalue)).getValue();
        description = allCategories.get(categories.indexOf(oldvalue)).getDescription();
        selectedStatus = statuses.get(allCategories.get(categories.indexOf(oldvalue)).getStatus() - 1);
    }

    public CategoriesServicesBean() throws ServicesException {
        categories = new ArrayList<String>();
        allCategories = new ArrayList<Categories>();
        categories_id = new ArrayList<Integer>();
        statuses = new ArrayList<String>();
    }

    public List<String> status() throws ServicesException {
        statuses.clear();
        try {
            List<Status> statuses1 = statusServices.traerStatus();
            for (int i = 0; i < statuses1.size(); i++) {
                statuses.add(statuses1.get(i).getValue());
            }
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria", ex);
        }

        return statuses;
    }

    /**
     * Es usado para controlar la funcionalidad de crear categoria desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarCategoria() throws ServicesException {
        try {

            Categories categorie = new Categories(value, description, status);
            categoriesServices.agregarCategoria(categorie);
        } catch (ServicesException ex) {
            throw new ServicesException("El item no esta registrado", ex);
        }
    }

    /**
     * Es usado controlar la funcionalidad de modificar datos de categoria desde la
     * interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void ModificarCategoria() throws ServicesException {
        try {
            categoriesServices.ModificarCategoria(value, description, 
                selectedStatus == "Cerrado" ? 4 : selectedStatus == "En Proceso" ? 2 
                : selectedStatus == "Resuelta" ? 3 : 1
                , oldvalue);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria", ex);
        }
    }

    public List<String> traerCategories() throws ServicesException {
        status();
        categories.clear();
        categories_id.clear();
        try {
            allCategories = categoriesServices.traerCategories();
            for (int i = 0; i < allCategories.size(); i++) {
                if (!categories.contains(allCategories.get(i).getValue())) {
                    categories_id.add(allCategories.get(i).getId());
                    categories.add(allCategories.get(i).getValue());
                }
            }
        } catch (ServicesException | PersistenceException ex) {
            throw new ServicesException("Error al modificar categoria", ex);
        }

        return categories;
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

    public static List<String> getCategories() {
        return categories;
    }

    public static void setCategories(List<String> newCategories) {
        categories = newCategories;
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

    public static List<Integer> getCategories_id() {
        return categories_id;
    }

    public static void setCategories_id(List<Integer> categories_id2) {
        categories_id = categories_id2;
    }
}
