package webapp.login;
import login.LoginRequest;
import webapp.User;
import webapp.UserMapBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    User user = new User("Krzysztof","Krawczyk","admin","admin","admin","28/06/2019","krzysiu@gmail.com");

    @Inject
    private LoginRequest loginRequest;

    @Inject
    UserMapBean userMapBean;



    public String login() {
        userMapBean.add(user);
            if (userMapBean.ifThereIs(loginRequest.getUsername())) {
                if (userMapBean.doesPasswordMatch(loginRequest.getUsername(), loginRequest.getPassword())) {
                    return "true";
                } else {
                    return "false";
                }
            } else {
                return "false";
            }

        }
    }