package syncronzr.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceType {

    @Id
    @GeneratedValue
    private long Id;

    @Column(unique = true, nullable = false)
    private String Code;

    @Column(nullable = false)
    private String Description;
    @OneToMany
    @JsonIgnore
    private List<Service> Services;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Service> getServices() {
        return Services;
    }

    public void setServices(List<Service> services) {
        Services = services;
    }
}
