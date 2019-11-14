package webapp.login;
import login.LoginRequest;
import session.SessionUtils;
import webapp.user.User;
import webapp.user.UserDB;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
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
    UserDB userDB = new UserDB();

    public String login() {
        String username = userDB.getUsername(loginRequest.getUsername());
        String password = userDB.getPassword(loginRequest.getPassword());
        if((!"notFound".equalsIgnoreCase(username) && !"notFound".equalsIgnoreCase(password))) {
            if (username.equals(loginRequest.getUsername()) && password.equals(loginRequest.getPassword())) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", loginRequest.getUsername());
                var tryLogin = "User: " + loginRequest.getUsername() + " tried to login with pass: " + loginRequest.getPassword() + " [SUCCESS] ";
                System.out.println(tryLogin);
                return "true";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect data",
                                "Username or password seems invalid"));
                var tryLogin = "User: " + loginRequest.getUsername() + " tried to login with pass: " + loginRequest.getPassword() + " [FAILURE] ";
                System.out.println(tryLogin);
                return "false";
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect data",
                            "User does not exist"));
            return "false";
        }
    }

    public String logout(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "true";
    }

}