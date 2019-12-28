package jazapp.session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegistrationRequest {
    private String name,surname,username,passwd,cpsswd,bdate,email;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getBdate() {
        return bdate;
    }

    public String getCpsswd() {
        return cpsswd;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSurname() {
        return surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public void setCpsswd(String cpsswd) {
        this.cpsswd = cpsswd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
