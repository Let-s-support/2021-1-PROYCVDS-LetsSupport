package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.entities.Needs;
import edu.eci.cvds.entities.Offers;
import edu.eci.cvds.services.*;
import org.primefaces.PrimeFaces;

import edu.eci.cvds.dao.PersistenceException;
import edu.eci.cvds.entities.Categories;
import edu.eci.cvds.entities.Status;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@javax.faces.bean.ManagedBean(name = "categoryBean")
@SessionScoped
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
    private List<String> estado;
    private boolean invalida;
    private boolean eliminada;
    private String comentarioinvalida;
    private ArrayList<String> nombres;
    private ArrayList<ArrayList<Integer>> totales;
    private ArrayList<String> estadosReporte;
    private ArrayList<String> invalidasReporte;
    private ArrayList<String> eliminadasReporte;
    private ArrayList<String> categoriasReporte;
    private String estadoReporte;
    private String invalidaReporte;
    private String eliminadaReporte;
    private String categoriaReporte;
    private int numeroNecesidaes;
    private int numeroOfertas;
    private int numeroTotales;
    private HorizontalBarChartModel graphic;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    @Inject
    NeedsServices needsServices;

    @Inject
    OffersServices offersServices;

    /**
     * Inicaliza la listas como vacias
     * 
     * @throws ServicesException
     */
    public CategoriesServicesBean() throws ServicesException {
        categories = new ArrayList<String>();
        allCategories = new ArrayList<Categories>();
        categories_id = new ArrayList<Integer>();
        statuses = new ArrayList<String>();
        System.out.println("Primer llamado");
        value = "";
        description = "";
    }

    /**
     * Obtiene una cadena con todos los estados y guarrda los nombres de estos en
     * una lista
     * 
     * @return List de tipo string
     * @throws ServicesException controlador de errores de la capa de services
     */
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

    public List<String> estado() throws ServicesException {
        estado = new ArrayList<>();
        estado.add("Activo");
        estado.add("Inactivo");
        return estado;
    }

    /**
     * Es usado para controlar la funcionalidad de crear categoria desde la interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void agregarCategoria() throws ServicesException {
        try {
            status = selectedStatus == "Activa" ? true : false;
            eliminada=false;
            Categories categorie = new Categories(value, description, status,invalida,eliminada,comentarioinvalida);
            categoriesServices.agregarCategoria(categorie);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "Categoria creada correctamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            // FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
            cleanData();
            System.out.println("Categoria creada");
        } catch (ServicesException ex) {
            throw new ServicesException("El item no esta registrado", ex);
        }
        cleanData();
    }

    public void cleanData() {
        this.value = "";
        this.description = "";
        this.selectedStatus = "Activa";
    }

    /**
     * Es usado controlar la funcionalidad de modificar datos de categoria desde la
     * interfaz
     * 
     * @throws ServicesException controlador de excepciones
     */
    public void ModificarCategoria() throws ServicesException {
        try {
            status = selectedStatus == "Activa" ? true : false;
            categoriesServices.ModificarCategoria(value, description, status, oldvalue);

            // FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
            cleanData();
            System.out.println("Categoria creada");
        } catch (ServicesException ex) {
            throw new ServicesException("Error al modificar categoria", ex);
        }
    }

    public void handleChange(ValueChangeEvent event) {
        for (Categories categories : allCategories) {
            if (categories.getValue().equals(event.getNewValue().toString())) {
                id = categories.getId();
                value = categories.getValue();
                description = categories.getDescription();
                selectedStatus = categories.getStatus() ? "Activa" : "Inactiva";
            }
        }
    }

    /**
     * Obtiene todas las categorias existentes y guarda en listas los nombres de las
     * categorias existentes
     * 
     * @return List de tipo string
     * @throws ServicesException
     */
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

    public void EliminarCategoria() throws ServicesException{
        try {
            categoriesServices.EliminarCategoria(value);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "La catagoria Se ha eliminado");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        }catch (Exception ex){
            throw new ServicesException("Error al eliminar la categoria", ex);
        }
    }

    public HorizontalBarChartModel getGrafico(int i) throws ServicesException, PersistenceException {
        createBarModel(i);
        return graphic;
    }


    private HorizontalBarChartModel initBarModelNeeds() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[allCategories.size()];
        int i=0;
        for(Categories categorie: allCategories){
            for(Needs need: needsServices.AllNeeds(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(need.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    values[i] += 1;
                                }
                            }
                        }
                    }
                }
            }
            i+=1;
        }
        int j=0;
        for(Categories categorie: allCategories){
            if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                chatSeries.set(categorie.getValue(), values[j]);
            }
        }
        model.addSeries(chatSeries);
        return model;
    }
    private HorizontalBarChartModel initBarModelOffers() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[allCategories.size()];
        int i=0;
        for(Categories categorie: allCategories){
            for(Offers offer: offersServices.AllOffers(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(offer.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    values[i] += 1;
                                }
                            }
                        }
                    }
                }
            }
            i+=1;
        }

        int j=0;
        for(Categories categorie: allCategories){
            if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                chatSeries.set(categorie.getValue(), values[j]);
            }
        }
        model.addSeries(chatSeries);
        return model;
    }
    private HorizontalBarChartModel initBarModelTotal() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[allCategories.size()];
        int i=0;
        for(Categories categorie: allCategories){
            for(Needs need: needsServices.AllNeeds(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(need.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    values[i] += 1;
                                }
                            }
                        }
                    }
                }
            }
            for(Offers offer: offersServices.AllOffers(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(offer.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    values[i] += 1;
                                }
                            }
                        }
                    }
                }
            }
            i+=1;
        }
        int j=0;
        for(Categories categorie: allCategories){
            if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                chatSeries.set(categorie.getValue(), values[j]);
            }
        }
        model.addSeries(chatSeries);
        return model;
    }

    private void createBarModel(int i) throws ServicesException, PersistenceException {
        filtros();
        allCategories = categoriesServices.traerCategories();
        if(i==1){
            graphic.setTitle("Categorias usadas por necesidades");
            graphic = initBarModelNeeds();
        }else if(i==2){
            graphic.setTitle("Categorias usadas por ofertas");
            graphic = initBarModelOffers();
        }else if(i==3){
            graphic.setTitle("Categorias usadas por ofertas y necesidades");
            graphic = initBarModelTotal();
        }

        graphic.setLegendPosition("ne");

        Axis xAxis = graphic.getAxis(AxisType.X);
        Axis yAxis = graphic.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }

    public void filtros() throws ServicesException, PersistenceException {
        invalidasReporte=new ArrayList<String>();
        invalidasReporte.add("Todas");
        invalidasReporte.add("Validas");
        invalidasReporte.add("Invalidas");
        estadosReporte=new ArrayList<String>();
        estadosReporte.add("Todos");
        estadosReporte.add("Activos");
        estadosReporte.add("Inactivos");
        eliminadasReporte=new ArrayList<String>();
        eliminadasReporte.add("Todas");
        eliminadasReporte.add("Eliminadas");
        eliminadasReporte.add("No eliminadas");
        categoriasReporte=new ArrayList<String>();
        categoriasReporte.add("Todas");
        ArrayList<Categories> categoriesnames= (ArrayList<Categories>) categoriesServices.traerCategories();
        for(int i=0;i<categoriesnames.size();i++){
            categoriasReporte.add(categoriesnames.get(i).getValue());
        }
    }

    public ArrayList<String> populares() throws ServicesException, PersistenceException {
        nombres=new ArrayList<String>();
        totales=new ArrayList<ArrayList<Integer>>();
        allCategories = categoriesServices.traerCategories();
        int i=0;
        for(Categories categorie: allCategories){
            int necesidades=0,ofertas=0,total=0;
            ArrayList<Integer> resultados = new ArrayList<Integer>();
            for(Needs need: needsServices.AllNeeds(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(need.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    necesidades+= 1;
                                }
                            }
                        }
                    }
                }
            }
            resultados.add(necesidades);
            for(Offers offer: offersServices.AllOffers(UserServicesBean.getId(),UserServicesBean.getRol())) {
                if(offer.getCategory_id()==categorie.getId()){
                    if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                        if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                            if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                                if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                                    ofertas+=1;
                                }
                            }
                        }
                    }
                }
            }
            resultados.add(ofertas);
            resultados.add(necesidades+ofertas);
            if(estadoReporte=="Todos" || (categorie.isStatus()==true && estadoReporte=="Activos") || (categorie.isStatus()==false && estadoReporte=="Inactivos")){
                if(invalidaReporte=="Todas" || (categorie.isInvalida()==true && estadoReporte=="Validas") || (categorie.isInvalida()==false && estadoReporte=="Invalidas")){
                    if(eliminadaReporte=="Todas" || (categorie.isEliminada()==true && estadoReporte=="Eliminadas") || (categorie.isEliminada()==false && estadoReporte=="No eliminadas")){
                        if(categoriaReporte=="Todas" || (categorie.getValue()==categoriaReporte)){
                            boolean var=false;
                            for(int n=0;n<totales.size();i++){
                                if(resultados.get(2)<totales.get(i).get(2)){
                                    var=true;
                                    nombres.add(n,categorie.getValue());
                                    totales.add(n,resultados);
                                }
                            }
                            if (!var){
                                nombres.add(categorie.getValue());
                                totales.add(resultados);
                            }
                        }
                    }
                }
            }
            i+=1;
        }
        return nombres;
    }

    public String datos(String categorieBusca){
        numeroNecesidaes=totales.get(nombres.indexOf(categorieBusca)).get(0);
        numeroOfertas=totales.get(nombres.indexOf(categorieBusca)).get(1);
        numeroTotales=totales.get(nombres.indexOf(categorieBusca)).get(2);
        return categorieBusca;
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

    public boolean getStatus() {
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

    public void setStatus(boolean status) {
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
