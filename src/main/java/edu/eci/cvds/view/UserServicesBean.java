package edu.eci.cvds.view;

import javax.faces.bean.ApplicationScoped;

import com.google.inject.Inject;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

@javax.faces.bean.ManagedBean(name = "userBean")
@ApplicationScoped
public class UserServicesBean extends BasePageBean{

    @Inject
    private UserServices userServices;
    private String correo;
    private String password;
    private int id;
    private String fullname;
    private String username;
    private String passwd;
    private int rol;
    private boolean isactive;

    /**
     * Es usado para controlar la funcionalidad de iniciar sesion desde la interfaz
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    public String IngresarSesion() throws ServicesException {
        try {
            return userServices.IngresarSesion(correo);
        } catch (ServicesException ex) {
            throw new ServicesException("Error al ingresar sesion",ex);
        }
    }

    public int getId() {
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
