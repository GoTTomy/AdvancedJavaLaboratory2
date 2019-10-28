package webapp.login;

import login.LoginRequest;
import register.RegistrationRequest;
import webapp.User;
import webapp.UserMapBean;
import webapp.register.RegisterController;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginController {
    FacesContext context = FacesContext.getCurrentInstance();
    User user = new User("Krzysztof","Krawczyk","admin","admin","admin","28/06/2019","krzysiu@gmail.com");

    @Inject
    private LoginRequest loginRequest;

    @Inject
    UserMapBean userMapBean;



    public void login() {
        userMapBean.add(user);
        if(userMapBean.ifThereIs(loginRequest.getUsername())){
            if(userMapBean.doesPasswordMatch(loginRequest.getUsername(),loginRequest.getPassword())){
                System.out.println("/index.xhtml?faces-redirect=true");
            }
        }

    }
}