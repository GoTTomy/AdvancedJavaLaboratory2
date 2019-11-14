package webapp.login;
import login.LoginRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        String password = userDB.getPassword(loginRequest.getUsername());
        if((!"notFound".equalsIgnoreCase(username) && !"notFound".equalsIgnoreCase(password))) {
            var passwordEncoder = new BCryptPasswordEncoder();
            if (username.equals(loginRequest.getUsername()) && passwordEncoder.matches(loginRequest.getPassword(),password)) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", loginRequest.getUsername());
                var tryLogin = "User: " + loginRequest.getUsername() + " tried to login with pass: " + passwordEncoder.encode(loginRequest.getPassword()) + " [SUCCESS] ";
                System.out.println(tryLogin);
                return "true";
            } else {
                var tryLogin = "User: " + loginRequest.getUsername() + " tried to login with pass: " + passwordEncoder.encode(loginRequest.getPassword()) + " [FAILURE] ";
                System.out.println(tryLogin);
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect data",
                                "Username or password seems invalid"));
                return "false";
            }
        }
        else{
            var passwordEncoder = new BCryptPasswordEncoder();
            var tryLogin = "User: " + loginRequest.getUsername() + " tried to login with pass: " + passwordEncoder.encode(loginRequest.getPassword()) + " [FAILURE] ";
            System.out.println(tryLogin);
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