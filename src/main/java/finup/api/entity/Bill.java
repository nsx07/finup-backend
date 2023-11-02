package finup.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Bill {

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;
    private double Amount;
    private String Description;
    private Date ExpirationDate;
    private String Status;
}
