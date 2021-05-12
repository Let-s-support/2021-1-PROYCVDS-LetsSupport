package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.services.*;
import edu.eci.cvds.services.Impl.UserServicesImpl;
import org.primefaces.PrimeFaces;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import edu.eci.cvds.entities.Offers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import java.text.SimpleDateFormat;
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

    @Inject
    UserServices userServices;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    private HorizontalBarChartModel graphic;
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
    private String selectedValue;
    private String selectedStatus;
    private List<String> statusList;
    private List<String> names;
    private List<Offers> OffersToAnswer;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

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
                    System.out.println("Oferta creada");
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
            AllOffers = offersServices.AllOffers(UserServicesBean.getId(),UserServicesBean.getRol());
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
            status = statusList.indexOf(selectedStatus);
            offersServices.ModificarEstadoOffer(selectedValue, status+1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Info", "Oferta actualizada"));
        } catch (Exception ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }

    /**
     * Obtener el grafico para mostrar en la interfaz grafica
     * @return
     */    
    public HorizontalBarChartModel getGrafico() {
        createBarModel();
        return graphic;
    }


    /**
     * Asigna los elementos para mostrar en cada una de las barras
     * @return
     */
    private HorizontalBarChartModel initBarModel() {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[4];

        for(Offers need: AllOffers){
            if(need.getStatus() == 1){
                values[0] +=1;                
            }else if(need.getStatus() == 2){
                values[1] +=1;                
            }
            else if(need.getStatus() == 3){
                values[2] +=1;                
            }else if(need.getStatus() == 4){
                values[3] +=1;                
            }
        }
        chatSeries.set("Abierta", values[0]);
        chatSeries.set("Cerrada", values[1]);    
        chatSeries.set("En Proceso ", values[2]);    
        chatSeries.set("Resuelta", values[3]);        
        model.addSeries(chatSeries);
        return model;
    }

    /**
     * Genera el modelo basico de la grafica
     */
    private void createBarModel() {
        AllOffers();
        graphic = initBarModel();
        graphic.setTitle("Ofertas agrupadas por estado");
        graphic.setLegendPosition("ne");
        
        Axis xAxis = graphic.getAxis(AxisType.X);
        Axis yAxis = graphic.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }

    public void cleanData() {
        this.value = "";
        this.description = "";
        this.selectedCategory = "";
    }

    public List<String> getOffersList() {
        AllOffers();
        getStatusList();
        if(selectedValue == "" || selectedStatus == null){
            selectedStatus = statusList.get(AllOffers.get(0).getStatus() - 1);
            selectedValue = AllOffers.get(0).getValue();
        }
        names = new ArrayList<String>();
        if (AllOffers != null) {
            for (Offers offer : AllOffers) {
                names.add(offer.getValue());
            }
        } else {
            System.out.println("Esta vacia");
        }

        return names;
    }

    public void handleChange(ValueChangeEvent event) {
        getOffersList();
        for(Offers offer: AllOffers){
            if(offer.getValue().equals(selectedValue)){
                selectedStatus = statusList.get(offer.getStatus() - 1);
                System.out.println("HandleChangeEvent Called!!");
            }
        }
    }

    public List<String> getStatusList() {
        statusList = new ArrayList<String>();
        statusList.add("Activa");
        statusList.add("En Proceso");
        statusList.add("Resuelta");
        statusList.add("Cerrada");
        return statusList;
    }

    public String nameCategoryOffer(int id) throws ServicesException {
        return categoriesServices.nameCategorie(id).get(0).getValue();
    }

    public String formatofecha(Date fecha){
        return formatter.format(fecha);
    }

    public String NombreUsuario(int id) throws ServicesException {
        return userServices.NombreUsuario(id).get(0).getFullName();
    }

    public List<Offers> OffersToAnswer() throws ServicesException{
        try {
            OffersToAnswer = offersServices.OffersToAnswer();
            return OffersToAnswer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Offers>();
        }
    }

    public String traerStatus(int id) throws ServicesException{
        return statusServices.traerStatus().get(id-1).getValue();
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

    public String getSelectedValue() {
        return this.selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getSelectedStatus() {
        return this.selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
    }
    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<String> getNames() {
        return this.names;
    }

    public void setNames(List<String> names) {
        this.names = names;
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
