package auth;

import javax.persistence.*;

@Entity
@Table(name = "profile", schema = "public")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="surrname")
    private String surrname;
    @Column(name="email")
    private String email;
    @Column(name="dateOfBirth")
    private String dateOfBirth;

    public ProfileEntity()
    {
        this.name = "";
        this.surrname = "";
        this.username = "";
        this.password = "";
        this.email = "";
        this.dateOfBirth = "";
    }
    public ProfileEntity(String username,String password,String name,String surrname,String email, String dateOfBirth){
        this.username=username;
        this.password=password;
        this.name = name;
        this.surrname=surrname;
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

    public String getSurrname() {
        return surrname;
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

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
