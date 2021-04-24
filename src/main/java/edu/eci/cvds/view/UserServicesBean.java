package edu.eci.cvds.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@javax.faces.bean.ManagedBean(name = "userBean")
@SessionScoped
public class UserServicesBean extends BasePageBean {

    @Inject
    private UserServices userServices;
    private String correo;
    private String password;
    private static int id;
    private String fullname;
    private String username;
    private int rol;
    private boolean isactive = false;

    /**
     * Es usado para controlar la funcionalidad de iniciar sesion desde la interfaz
     * 
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    public void IngresarSesion() throws Exception {
        try {
            List<User> datos = userServices.IngresarSesion(username);
            if (!datos.isEmpty()) {
                if (password.equals(datos.get(0).getPasswd())) {
                    isactive = datos.get(0).getIsactive();
                    System.out.println(isactive);
                    if (isactive) {
                        id = datos.get(0).getId();
                        fullname = datos.get(0).getFullName();
                        rol = datos.get(0).getRol();
                        correo = datos.get(0).getCorreo();
                        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
                    }else{
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario esta inactivo"));
                        new ServicesException("Usuario inactivo");
                    }
                } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Wrong Password"));
                    new ServicesException("Contraseña equivocada");
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario no existe"));
                new ServicesException("Usuario inexistente");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Ha ocurrido un error interno"));
            throw new ServicesException("Error al ingresar sesion", ex);
        }
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public UserServices getUserServices() {
        return this.userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
