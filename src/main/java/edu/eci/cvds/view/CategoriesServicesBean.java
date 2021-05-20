package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.*;
import net.bootsfaces.render.A;
import org.primefaces.PrimeFaces;

import edu.eci.cvds.dao.PersistenceException;
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
    private ArrayList<Integer> totales;
    private ArrayList<Integer> necesidades;
    private ArrayList<Integer> ofertas;
    private ArrayList<ArrayList<Integer>> Resultados;
    private ArrayList<String> nombresFinales;
    private ArrayList<String> estadosReporte;
    private ArrayList<String> invalidasReporte;
    private ArrayList<String> eliminadasReporte;
    private ArrayList<String> categoriasReporte;
    private String estadoReporte= "Todos";
    private String invalidaReporte= "Todas";;
    private String eliminadaReporte= "Todas";;
    private String categoriaReporte= "Todas";
    private int numeroNecesidaes;
    private int numeroOfertas;
    private int numeroTotales;
    private List<Cantidades> cantidades;
    private HorizontalBarChartModel graphic;

    @Inject
    CategoriesServices categoriesServices;

    @Inject
    StatusServices statusServices;

    @Inject
    NeedsServices needsServices;

    @Inject
    OffersServices offersServices;

    @Inject
    CantidadesServices cantidadesServices;

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
        value = "";
        description = "";
        cleanData();
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
            eliminada = false;
            Categories categorie = new Categories(value, description, status, invalida, eliminada, comentarioinvalida);
            categoriesServices.agregarCategoria(categorie);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "Categoria creada correctamente");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            // FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
            cleanData();
            System.out.println("Categoria creada");
        } catch (ServicesException ex) {
            cleanData();
            throw new ServicesException("El item no esta registrado", ex);
        }

        cleanData();
    }

    public void cleanData() {
        this.value = "";
        this.description = "";
        this.selectedStatus = "Activa";
        this.invalida = false;
        this.comentarioinvalida = "";
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

    public void EliminarCategoria() throws ServicesException {
        try {
            categoriesServices.EliminarCategoria(value);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message",
                    "La catagoria Se ha eliminado");
            PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception ex) {
            throw new ServicesException("Error al eliminar la categoria", ex);
        }
    }

    public HorizontalBarChartModel getGrafico(int i) throws ServicesException, PersistenceException {
        cantidades=new ArrayList<Cantidades>();
        cantidades=solicitudes();
        createBarModel(i);
        return graphic;
    }

    private HorizontalBarChartModel initBarModelNeeds() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Necesidades");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[cantidades.size()];
        int i = 0;
        for (Cantidades cantidad : cantidades) {
            values[i]+=cantidad.getNecesidades();
            i += 1;
        }
        int j = 0;
        for (Cantidades cantidad : cantidades) {
            chatSeries.set(categoriesServices.nameCategorie(cantidad.getCategory_id()).get(0).getValue(), values[j]);
            j+=1;
        }

        model.addSeries(chatSeries);
        return model;
    }

    private HorizontalBarChartModel initBarModelOffers() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[cantidades.size()];
        int i = 0;
        for (Cantidades cantidad : cantidades) {
            values[i]+=cantidad.getOfertas();
            i += 1;
        }

        int j = 0;
        for (Cantidades cantidad : cantidades) {
            chatSeries.set(categoriesServices.nameCategorie(cantidad.getCategory_id()).get(0).getValue(), values[j]);
            j+=1;
        }
        model.addSeries(chatSeries);
        return model;
    }

    private HorizontalBarChartModel initBarModelTotal() throws ServicesException, PersistenceException {
        HorizontalBarChartModel model = new HorizontalBarChartModel();
        BarChartSeries chatSeries = new BarChartSeries();
        chatSeries.setLabel("Ofertas y Necesidades");
        model.setSeriesColors("B40001,93b75f,E7E658,cc6666");
        int[] values = new int[cantidades.size()];
        int i = 0;
        for (Cantidades cantidad : cantidades) {
            values[i]+=cantidad.getTotal();
            i += 1;
        }
        int j = 0;
        for (Cantidades cantidad : cantidades) {
            chatSeries.set(categoriesServices.nameCategorie(cantidad.getCategory_id()).get(0).getValue(), values[j]);
            j+=1;
        }
        model.addSeries(chatSeries);
        return model;
    }

    private void createBarModel(int i) throws ServicesException, PersistenceException {
        if (i == 1) {
            graphic = initBarModelNeeds();
            graphic.setTitle("Categorías usadas por necesidades");
        } else if (i == 2) {
            graphic = initBarModelOffers();
            graphic.setTitle("Categorías usadas por ofertas");
        } else if (i == 3) {
            graphic = initBarModelTotal();
            graphic.setTitle("Categorías usadas por ofertas y necesidades");

        }

        graphic.setLegendPosition("ne");

        Axis xAxis = graphic.getAxis(AxisType.X);
        Axis yAxis = graphic.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }

    public List<Cantidades> solicitudes() throws ServicesException{
        cantidades=new ArrayList<Cantidades>();
        cantidades=cantidadesServices.solicitudes();
        return cantidades;
    }

    public String datos(Cantidades categorieBusca) throws ServicesException {
        numeroNecesidaes = categorieBusca.getNecesidades();
        numeroOfertas = categorieBusca.getOfertas();
        numeroTotales = categorieBusca.getTotal();
        return categoriesServices.nameCategorie(categorieBusca.getCategory_id()).get(0).getValue();
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

    public boolean isStatus() {
        return this.status;
    }

    public List<String> getEstado() {
        return this.estado;
    }

    public void setEstado(List<String> estado) {
        this.estado = estado;
    }

    public boolean isInvalida() {
        return this.invalida;
    }

    public boolean getInvalida() {
        return this.invalida;
    }

    public void setInvalida(boolean invalida) {
        this.invalida = invalida;
    }

    public boolean isEliminada() {
        return this.eliminada;
    }

    public boolean getEliminada() {
        return this.eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    public String getComentarioinvalida() {
        return this.comentarioinvalida;
    }

    public void setComentarioinvalida(String comentarioinvalida) {
        this.comentarioinvalida = comentarioinvalida;
    }

    public ArrayList<String> getNombres() {
        return this.nombres;
    }

    public void setNombres(ArrayList<String> nombres) {
        this.nombres = nombres;
    }

    public ArrayList<Integer> getTotales() {
        return this.totales;
    }

    public void setTotales(ArrayList<Integer> totales) {
        this.totales = totales;
    }

    public ArrayList<String> getEstadosReporte() {
        return this.estadosReporte;
    }

    public void setEstadosReporte(ArrayList<String> estadosReporte) {
        this.estadosReporte = estadosReporte;
    }

    public ArrayList<String> getInvalidasReporte() {
        return this.invalidasReporte;
    }

    public void setInvalidasReporte(ArrayList<String> invalidasReporte) {
        this.invalidasReporte = invalidasReporte;
    }

    public ArrayList<String> getEliminadasReporte() {
        return this.eliminadasReporte;
    }

    public void setEliminadasReporte(ArrayList<String> eliminadasReporte) {
        this.eliminadasReporte = eliminadasReporte;
    }

    public ArrayList<String> getCategoriasReporte() {
        return this.categoriasReporte;
    }

    public void setCategoriasReporte(ArrayList<String> categoriasReporte) {
        this.categoriasReporte = categoriasReporte;
    }

    public String getEstadoReporte() {
        return this.estadoReporte;
    }

    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public String getInvalidaReporte() {
        return this.invalidaReporte;
    }

    public void setInvalidaReporte(String invalidaReporte) {
        this.invalidaReporte = invalidaReporte;
    }

    public String getEliminadaReporte() {
        return this.eliminadaReporte;
    }

    public void setEliminadaReporte(String eliminadaReporte) {
        this.eliminadaReporte = eliminadaReporte;
    }

    public String getCategoriaReporte() {
        return this.categoriaReporte;
    }

    public void setCategoriaReporte(String categoriaReporte) {
        this.categoriaReporte = categoriaReporte;
    }

    public int getNumeroNecesidaes() {
        return this.numeroNecesidaes;
    }

    public void setNumeroNecesidaes(int numeroNecesidaes) {
        this.numeroNecesidaes = numeroNecesidaes;
    }

    public int getNumeroOfertas() {
        return this.numeroOfertas;
    }

    public void setNumeroOfertas(int numeroOfertas) {
        this.numeroOfertas = numeroOfertas;
    }

    public int getNumeroTotales() {
        return this.numeroTotales;
    }

    public void setNumeroTotales(int numeroTotales) {
        this.numeroTotales = numeroTotales;
    }

    public HorizontalBarChartModel getGraphic() {
        return this.graphic;
    }

    public void setGraphic(HorizontalBarChartModel graphic) {
        this.graphic = graphic;
    }

    public NeedsServices getNeedsServices() {
        return this.needsServices;
    }

    public void setNeedsServices(NeedsServices needsServices) {
        this.needsServices = needsServices;
    }

    public OffersServices getOffersServices() {
        return this.offersServices;
    }

    public void setOffersServices(OffersServices offersServices) {
        this.offersServices = offersServices;
    }

}
