package edu.eci.cvds.view;

import javax.faces.bean.ApplicationScoped;

import com.google.inject.Inject;

import edu.eci.cvds.services.UserServices;

@javax.faces.bean.ManagedBean(name = "UserServices")
@ApplicationScoped
public class UserServicesBean extends BasePageBean{

    @Inject
    private UserServices userServices;

    public void login(String username, String password){
        
    }
}
