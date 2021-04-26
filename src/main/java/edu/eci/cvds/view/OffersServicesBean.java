package edu.eci.cvds.view;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.MaxiumRequerementsServices;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.OffersServices;
import edu.eci.cvds.services.ServicesException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@ManagedBean(name = "offerBean")
@SessionScoped
public class OffersServicesBean extends BasePageBean {
    @Inject
    OffersServices offersServices;

    @Inject
    MaxiumRequerementsServices maxiumRequerementsServices;

    public static int id;
    private String value;
    private String description;
    private int status;
    private Date creationdate;
    private Date modificationdate;
    private int category_id;
    private String selectedCategory;
    private int idsolicitante;
    private List<Offers> AllOffers;

    /**
     * Crea una nueva oferta
     * 
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void agregarOfertas() throws ServicesException {
        try {
            idsolicitante = UserServicesBean.getId();
            if (offersServices.cantidadOffersUser(idsolicitante).size() < maxiumRequerementsServices.traerMaxiumOffers()
                    .get(0).getMoffers()) {
                category_id = CategoriesServicesBean.getCategories_id()
                        .get(CategoriesServicesBean.getCategories().indexOf(selectedCategory));

                try {
                    Offers offer = new Offers(value, description, 1, category_id, idsolicitante);
                    offersServices.agregarOfertas(offer);
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                            "Oferta creada correctamente");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                    //FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
                    System.out.println("Categoria creada");
                } catch (Exception e) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "Ha ocurrido un error");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                    e.printStackTrace();
                }
            } else {
                try {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "Su usuario ha alcanzado la cantidad maxima de ofertas que podia registrar");
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                    //FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (ServicesException ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }

        cleanData();
    }

    /**
     * Obtiene todas las ofertas
     * 
     * @throws ServicesException controlador de errores de la capa de services
     */
    public List<Offers> AllOffers(){
        try {
            AllOffers = offersServices.AllOffers();
            return AllOffers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Offers>();
        }
    }

    /**
     * Modifica el estado de la oferta
     * 
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void ModificarEstadoOffer() throws ServicesException {
        try {
            offersServices.ModificarEstadoOffer(value, status);
        } catch (Exception ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }

    public void cleanData() {
        this.value = "";
        this.description = "";
        this.selectedCategory = "";
    }

    public OffersServices getOffersServices() {
        return offersServices;
    }

    public void setOffersServices(OffersServices offersServices) {
        this.offersServices = offersServices;
    }

    public MaxiumRequerementsServices getMaxiumRequerementsServices() {
        return maxiumRequerementsServices;
    }

    public void setMaxiumRequerementsServices(MaxiumRequerementsServices maxiumRequerementsServices) {
        this.maxiumRequerementsServices = maxiumRequerementsServices;
    }

    public static int getId() {
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

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public int getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public List<Offers> getAllOffers() {
        return this.AllOffers;
    }

    public void setAllOffers(List<Offers> AllOffers) {
        this.AllOffers = AllOffers;
    }
}
