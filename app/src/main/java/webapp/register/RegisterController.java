package webapp.register;

import register.RegistrationRequest;
import webapp.User;
import webapp.UserMapBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;


@Named
@RequestScoped
public class RegisterController
{
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    private RegistrationRequest registrationRequest;

    @Inject
    UserMapBean userMapBean;

    public void register()
    {
        User user = new User(registrationRequest.getName(),registrationRequest.getSurname(),registrationRequest.getUsername(),registrationRequest.getPasswd(),registrationRequest.getCpsswd(),registrationRequest.getEmail(),registrationRequest.getBdate());
        userMapBean.add(user);

        try
        {
            context.getExternalContext().redirect("login.xhtml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}