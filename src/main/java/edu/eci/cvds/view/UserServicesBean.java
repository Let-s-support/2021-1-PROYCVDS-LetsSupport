package edu.eci.cvds.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;

import org.slf4j.LoggerFactory;

import edu.eci.cvds.entities.User;
import edu.eci.cvds.services.ServicesException;
import edu.eci.cvds.services.UserServices;

import org.slf4j.LoggerFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import java.util.logging.Level;

import java.io.IOException;
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
    public static int id;
    private String fullname;
    private String username;
    private static int rol;
    private boolean isactive = false;
    Subject subject;
    private String redirectUrl = "/app/login.xhtml";
    /**
     * Es usado para controlar la funcionalidad de iniciar sesion desde la interfaz
     * 
     * @return String
     * @throws ServicesException controlador de excepciones
     */
    public void IngresarSesion() throws Exception {
        Logger log = LoggerFactory.getLogger(UserServicesBean.class);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject = SecurityUtils.getSubject();
        try {
            //comprobar si está activo
            List<User> datos = userServices.IngresarSesion(username);
            if (!datos.isEmpty())isactive= datos.get(0).getIsactive();
            if (isactive){
                    id = datos.get(0).getId();
                    fullname = datos.get(0).getFullName();
                    rol = datos.get(0).getRol();
                    correo = datos.get(0).getCorreo();
                    subject.login(token);//crear token activo
                    FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");       
                }
            else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El usuario esta inactivo"));
                    new ServicesException("Usuario inactivo");
            }
        }catch (UnknownAccountException ex) {
                messageError("La cuenta no existe !");
                log.error(ex.getMessage(), ex);
        }catch (IncorrectCredentialsException ex) {
                System.err.println("Wrong password");
                messageError("Contraseña incorrecta, intenta de nuevo.");
                log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
                messageError("Cuenta Bloqueada por Administracion");
                log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
                messageError("Error desconocido: " + ex.getMessage());
                log.error(ex.getMessage(), ex);
        } catch (NullPointerException e) {
                System.err.println("Ni idea , muy demalas");
        } finally {
                token.clear();
        }

    }

    public void cerrarSesion() {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UserServicesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void messageError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
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

    public static int getRol() {
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
