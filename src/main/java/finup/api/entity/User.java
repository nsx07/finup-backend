package finup.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long Id;
    @Column(nullable = false)
    private String Name;
    @Column(unique = true, nullable = false)
    private String Email;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Date DateBirth;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getDateBirth() {
        return DateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        DateBirth = dateBirth;
    }
}
