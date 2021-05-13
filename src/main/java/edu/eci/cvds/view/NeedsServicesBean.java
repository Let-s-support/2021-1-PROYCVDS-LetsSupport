package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.dao.CategoriesDAO;
import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.dao.UserDAO;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.*;
import org.primefaces.PrimeFaces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import edu.eci.cvds.entities.Needs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Inject
    UserServices userServices;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    private HorizontalBarChartModel graphic;
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
    private List<Needs> NeedsToAnswer;
    private String Categoryname;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private String categoriaReporte;
    private String estadoReporte;
    private String consulta;
    private List<String> categoriasReporte;
    private List<String> estadosReporte;

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
                List<Categories> invalida = categoriesServices.categoriaInvalida(category_id);
                if(!invalida.get(0).isInvalida()) {
                    Needs need = new Needs(value, description, 1, category_id, urgencia, idsolicitante);
                    needsServices.agregarNecesidades(need);
                }else{
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "La categoria seleccionada es una categoria invalida "+invalida.get(0).getComentarioinvalida());
                    PrimeFaces.current().dialog().showMessageDynamic(message);
                }
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
            System.out.println(consulta);
            AllNeeds = needsServices.AllNeeds(UserServicesBean.getId(),UserServicesBean.getRol());
            return AllNeeds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
        }
    }
    public List<Needs> AllNeedsFilterCategory() {
        try {
            System.out.println(consulta);
            AllNeeds = needsServices.AllNeedsFilterCategory(UserServicesBean.getId(),UserServicesBean.getRol(),categoriesServices.traerValuesCategories(categoriaReporte).get(0).getId());
            return AllNeeds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
        }
    }
    public List<Needs> AllNeedsFilterStatus() {
        try {
            System.out.println(estadosReporte.indexOf(estadoReporte));

            AllNeeds = needsServices.AllNeedsFilterStatus(UserServicesBean.getId(),UserServicesBean.getRol(),estadosReporte.indexOf(estadoReporte));
            System.out.println(AllNeeds);
            return AllNeeds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
        }
    }
    public List<Needs> AllNeedsFilterCategoryStatus() {
        try {
            AllNeeds = needsServices.AllNeedsFilterCategoryStatus(UserServicesBean.getId(),UserServicesBean.getRol(),categoriesServices.traerValuesCategories(categoriaReporte).get(0).getId(),estadosReporte.indexOf(estadoReporte));
            return AllNeeds;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
        }
    }

    /**
     * Obtiene los estados de las necesidades
     * @return
     */
    public List<String> getStatusList() {
        statusList = new ArrayList<String>();
        statusList.add("Activa");
        statusList.add("En Proceso");
        statusList.add("Resuelta");
        statusList.add("Cerrada");
        return statusList;
    }

    /**
     * Permite detectar el cambio en el "select" de los formularios en front
     * @param event
     */
    public void handleChange(ValueChangeEvent event) {
        for(Needs need: AllNeeds){
            if(need.getValue().equals(event.getNewValue().toString())){
                selectedStatus = statusList.get(need.getStatus()-1);
            }
        }
    }

    /**
     * Devuelve una lista de los nombres de las necesidades
     * @return
     */
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

        } catch (Exception ex) {
            throw new ServicesException("Error al agregar la necesidad", ex);
        }
    }

    /**
     * Obtener el grafico para mostrar en la interfaz grafica
     * @return
     */    
    public HorizontalBarChartModel getGrafico() throws ServicesException, PersistenceException {
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
        chatSeries.setLabel("Necesidades");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[4];

        for(Needs need: AllNeeds){
            if((need.getStatus() == 1 && estadoReporte=="Todos") || (need.getStatus() == 1 && estadoReporte=="Activa")){
                values[0] +=1;
            }else if((need.getStatus() == 2 && estadoReporte=="Todos") || (need.getStatus() == 1 && estadoReporte=="En proceso")){
                values[1] +=1;
            }
            else if((need.getStatus() == 3 && estadoReporte=="Todos") || (need.getStatus() == 1 && estadoReporte=="Resuelta")){
                values[2] +=1;
            }else if((need.getStatus() == 4 && estadoReporte=="Todos") || (need.getStatus() == 1 && estadoReporte=="Cerrada")){
                values[3] +=1;
            }
        }
        if (estadoReporte=="Todos" || estadoReporte=="Activa"){
            chatSeries.set("Abierta", values[0]);
        }
        if (estadoReporte=="Todos" || estadoReporte=="En proceso"){
            chatSeries.set("Cerrada", values[1]);
        }
        if (estadoReporte=="Todos" || estadoReporte=="Resuelta"){
            chatSeries.set("En Proceso ", values[2]);
        }
        if (estadoReporte=="Todos" || estadoReporte=="Cerrada"){
            chatSeries.set("Resuelta", values[3]);
        }
        model.addSeries(chatSeries);
        return model;
    }

    /**
     * Genera el modelo basico de la grafica
     */
    private void createBarModel() throws ServicesException, PersistenceException {
        filtros();
        estadoReporte="Activa";
        categoriaReporte="Todas";
        consulta="";
        if (estadoReporte=="Todos" && categoriaReporte=="Todas"){
            AllNeeds();
        }
        if (estadoReporte!="Todos" && categoriaReporte=="Todas"){
            AllNeedsFilterStatus();
        }
        if (estadoReporte=="Todos" && categoriaReporte!="Todas"){
            AllNeedsFilterCategory();
        }
        if (estadoReporte!="Todos" && categoriaReporte!="Todas"){
            AllNeedsFilterCategoryStatus();
        }

        graphic = initBarModel();
        graphic.setTitle("Necesidades agrupadas por estado");
        graphic.setLegendPosition("ne");
        
        Axis xAxis = graphic.getAxis(AxisType.X);
        Axis yAxis = graphic.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }

    public void filtros() throws ServicesException, PersistenceException {
        categoriasReporte=new ArrayList<String>();
        categoriasReporte.add("Todas");
        ArrayList<Categories> categoriesnames= (ArrayList<Categories>) categoriesServices.traerCategories();
        for(int i=0;i<categoriesnames.size();i++){
            categoriasReporte.add(categoriesnames.get(i).getValue());
        }
        estadosReporte=new ArrayList<String>();
        estadosReporte.add("Todos");
        ArrayList<Status> statusnames= (ArrayList<Status>) statusServices.traerStatus();
        for(int i=0;i<statusnames.size();i++){
            estadosReporte.add(statusnames.get(i).getValue());
        }
    }

    /**
     * Limpia los campos despues de una accion
     */
    public void cleanData() {
        this.value = "";
        this.selectedCategory = "";
        this.selectedValue = "";
        this.selectedStatus = "Activa";
    }

    public String nameCategoryNeed(int id) throws ServicesException {
        return categoriesServices.nameCategorie(id).get(0).getValue();
    }
    public String formatofecha(Date fecha){
        return formatter.format(fecha);
    }

    public String NombreUsuario(int id) throws ServicesException {
        return userServices.NombreUsuario(id).get(0).getFullName();
    }

    public String traerStatus(int id) throws ServicesException{
        return statusServices.traerStatus().get(id-1).getValue();
    }

    public List<Needs> NeedsToAnswer() throws ServicesException{
        try {
            NeedsToAnswer = needsServices.NeedsToAnswer();
            return NeedsToAnswer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<Needs>();
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
