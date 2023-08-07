package syncronzr.api.entity;

import jakarta.persistence.*;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private long Id;
    @Column(unique = true, nullable = false)
    private String Code;
    @Column(nullable = false)
    private String Description;
    @Column(nullable = true)
    private String Note;
    @Column(nullable = false)
    private double Price;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ServiceType ServiceType;

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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public ServiceType getServiceType() {
        return ServiceType;
    }

    public void setServiceType(ServiceType serviceType) {
        ServiceType = serviceType;
    }
}
