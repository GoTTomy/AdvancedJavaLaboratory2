package jazapp.register;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jazapp.user.UserDB;

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
    UserDB userDB = new UserDB();

    public void register()
    {
        if(userDB.checkifUsernameIsUnique(registrationRequest.getUsername())) {
            if(registrationRequest.getPasswd().equals(registrationRequest.getCpsswd())) {
                var passwordEncoder = new BCryptPasswordEncoder();
                final String hashedPasswd = passwordEncoder.encode(registrationRequest.getPasswd());

                userDB.addUser(registrationRequest.getUsername(), hashedPasswd, registrationRequest.getName(),
                        registrationRequest.getSurname(),
                        registrationRequest.getEmail(), registrationRequest.getBdate());
                try {
                    context.getExternalContext().redirect("login.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Passwords doesn't match!");
            }
        }
        else{
            System.out.println("This username is already taken!");
        }
    }
}