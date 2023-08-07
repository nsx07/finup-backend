package syncronzr.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private long Id;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime StartDateTime;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime FinishDateTime;
    @Column(nullable = false)
    private double Price;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User Employee;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User Customer;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Service Service;
    @Column(nullable = true)
    private String Note;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public LocalDateTime getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        StartDateTime = startDateTime;
    }

    public LocalDateTime getFinishDateTime() {
        return FinishDateTime;
    }

    public void setFinishDateTime(LocalDateTime finishDateTime) {
        FinishDateTime = finishDateTime;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public User getEmployee() {
        return Employee;
    }

    public void setEmployee(User employee) {
        Employee = employee;
    }

    public User getCustomer() {
        return Customer;
    }

    public void setCustomer(User customer) {
        Customer = customer;
    }

    public syncronzr.api.entity.Service getService() {
        return Service;
    }

    public void setService(syncronzr.api.entity.Service service) {
        Service = service;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
