package edu.eci.cvds.view;

import java.io.IOException;
import java.io.Serializable;  

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "navigationController", eager = true)
@SessionScoped
public class NavigationController implements Serializable {

    private boolean showOffers = true;

    public String loginScreen() {
        return "login.xhtml";
    }

    public String Home(){
        return "home.xhtml";
    }

    public String showMessage(String msg){
        return null;
    }


    public boolean isShowOffers() {
        return this.showOffers;
    }

    public boolean getShowOffers() {
        return this.showOffers;
    }

    public void setShowOffers(boolean showOffers) {
        try {
            this.showOffers = showOffers;
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}