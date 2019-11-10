package webapp.login;
import login.LoginRequest;
import session.SessionUtils;
import webapp.User;
import webapp.UserMapBean;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    UserMapBean userMapBean;

    public String login() {
        if (userMapBean.ifThereIs(loginRequest.getUsername())) {
            if (userMapBean.doesPasswordMatch(loginRequest.getUsername(), loginRequest.getPassword())) {
                HttpSession session= SessionUtils.getSession();
                session.setAttribute("username",User.getUsername());
                session.setAttribute("name",User.getName());
                session.setAttribute("surrname",User.getSurrname());
                session.setAttribute("token",User.getToken());
                session.setAttribute("fullName",SessionUtils.getFullName());
                return "true";
            } else {
                return "false";
            }
        } else {
            return "false";
        }
    }

    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "true";
    }

}