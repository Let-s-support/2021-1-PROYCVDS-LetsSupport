package edu.eci.cvds.view;

import com.google.inject.Inject;

import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.services.MaxiumRequerementsServices;
import edu.eci.cvds.services.NeedsServices;
import edu.eci.cvds.services.ServicesException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "needBean")
@SessionScoped
public class NeedsServicesBean extends BasePageBean {
    @Inject
    NeedsServices needsServices;

    @Inject
    MaxiumRequerementsServices maxiumRequerementsServices;

    private BarChartModel graphic;
    private int id;
    private String value;
    private String description;
    private int status;
    private Date creationdate;
    private Date modificationdate;
    private int category_id;
    private String selectedValue;
    private int urgencia;
    private String selectedCategory;
    private String selectedStatus;
    private int idsolicitante;
    private List<Needs> AllNeeds;
    private List<String> statusList;
    private List<String> names;

    /**
     * Es usado para controlar la funcionalidad de crear necesidad desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarNecesidades() throws ServicesException {
        try {
            idsolicitante = UserServicesBean.getId();
            if (needsServices.cantidadNeedsUser(idsolicitante).size() < maxiumRequerementsServices.traerMaxiumNeeds()
                    .get(0).getMneeds()) {
                category_id = CategoriesServicesBean.getCategories_id()
                        .get(CategoriesServicesBean.getCategories().indexOf(selectedCategory));
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                        "Necesidad creada correctamente");
                PrimeFaces.current().dialog().showMessageDynamic(message);
                Needs need = new Needs(value, description, 1, category_id, urgencia, idsolicitante);
                needsServices.agregarNecesidades(need);
            } else {
                try {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "Ha creado la cantidad maxima de necesidades que podia registrar");
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
     * Obtiene todas las necesidades registradas
     * 
     * @throws ServicesException controlador de errores de la capa de services
     */
    public List<Needs> AllNeeds() {
        try {
            AllNeeds = needsServices.AllNeeds();
            return AllNeeds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
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

    public void handleChange(ValueChangeEvent event) {
        for(Needs need: AllNeeds){
            if(need.getValue().equals(event.getNewValue().toString())){
                selectedStatus = statusList.get(need.getStatus()-1);
            }
        }
    }

    public List<String> getNeedsList() {
        AllNeeds();
        getStatusList();
        if(selectedValue == "" || selectedStatus == null){
            selectedStatus = statusList.get(AllNeeds.get(0).getStatus());
            selectedValue = AllNeeds.get(0).getValue();
        }
        names = new ArrayList<String>();
        if (AllNeeds != null) {
            for (Needs need : AllNeeds) {
                names.add(need.getValue());
            }
        } else {
            System.out.println("Esta vacia");
        }

        return names;
    }

    /**
     * Modifica el estado de la necesidad
     * 
     * @throws ServicesException controlador de errores de la capa de services
     */
    public void ModificarEstadoNeed() throws ServicesException {
        try {
            status = statusList.indexOf(selectedStatus);
            needsServices.ModificarEstadoNeed(selectedValue, status+1);
            cleanData();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "Necesidad actulizada correctamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }


    
    public BarChartModel getGrafico() {
        createBarModel();
        return graphic;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries graph = new ChartSeries();
        graph.setLabel("Algooo");


        for(Needs need: AllNeeds){
            graph.set(need.getValue(),500 );
        }

        model.addSeries(graph);

        return model;
    }

    private void createBarModel() {
        graphic = initBarModel();
        graphic.setTitle("Algomassss");
        graphic.setLegendPosition("ne");

        
        Axis xAxis = graphic.getAxis(AxisType.X);

        Axis yAxis = graphic.getAxis(AxisType.Y);
        yAxis.setLabel("eje Y");
        yAxis.setMin(0);
        yAxis.setMax(1000);
    }

    public void cleanData() {
        this.value = "";
        this.selectedCategory = "";
        this.selectedValue = "";
        this.selectedStatus = "Activa";
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

    public String getSelectedCategory() {
        return this.selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
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

    public String getSelectedValue() {
        return this.selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getSelectedStatus() {
        return this.selectedStatus;
    }

    public void setSelectedStatus(String selectedStatus) {
        this.selectedStatus = selectedStatus;
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

    public MaxiumRequerementsServices getMaxiumRequerementsServices() {
        return this.maxiumRequerementsServices;
    }

    public void setMaxiumRequerementsServices(MaxiumRequerementsServices maxiumRequerementsServices) {
        this.maxiumRequerementsServices = maxiumRequerementsServices;
    }

    public int getIdsolicitante() {
        return this.idsolicitante;
    }

    public void setIdsolicitante(int idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public List<Needs> getAllNeeds() {
        return this.AllNeeds;
    }

    public void setAllNeeds(List<Needs> AllNeeds) {
        this.AllNeeds = AllNeeds;
    }

}
