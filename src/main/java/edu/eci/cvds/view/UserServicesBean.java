package edu.eci.cvds.view;

import javax.faces.bean.SessionScoped;
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
    public String IngresarSesion() throws ServicesException {
        String res = "";
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
                        res = "home.xhtml";
                    }else{
                        new ServicesException("Usuario inactivo");
                        res = "login.xhtml";
                    }
                } else {
                    new ServicesException("Contraseña equivocada");
                    res = "login.xhtml";
                }
            } else {
                new ServicesException("Usuario inexistente");
                res = "login.xhtml";
            }
        } catch (ServicesException ex) {
            ex.printStackTrace();
            throw new ServicesException("Error al ingresar sesion", ex);
        }

        System.out.println(res);
        return res;
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
