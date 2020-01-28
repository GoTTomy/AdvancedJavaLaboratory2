package jazapp.user;

import javax.persistence.*;

@Entity
@Table(name = "profile", schema = "public")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;

    private String dateOfBirth;

    public ProfileEntity()
    {
        this.name = "";
        this.surname = "";
        this.username = "";
        this.password = "";
        this.email = "";
        this.dateOfBirth = "";
    }
    public ProfileEntity(String username, String password, String name, String surname, String email, String dateOfBirth){
        this.username=username;
        this.password=password;
        this.name = name;
        this.surname = surname;
        this.email=email;
        this.dateOfBirth=dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
