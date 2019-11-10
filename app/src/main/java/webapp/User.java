package webapp;

import java.util.UUID;

public class User {
    private static String name,surname,username,passwd,cpsswd,bdate,email,token;
    public User(String name,String surname, String username, String passwd, String cpsswd, String bdate, String email){
        this.name = name;
        this.surname=surname;
        this.username=username;
        this.passwd=passwd;
        this.cpsswd=cpsswd;
        this.bdate=bdate;
        this.email=email;
        generateToken();
    }

    public static String getUsername() {
        return username;
    }

    public String getBdate() {
        return bdate;
    }

    public String getCpsswd() {
        return cpsswd;
    }

    public static String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public static String getSurrname() {
        return surname;
    }

    public String getEmail() {
        return email;
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

    public static String getToken(){
        return token;
    }

    public void generateToken(){
        String token = UUID.randomUUID().toString();
        this.token = token;
    }
}
