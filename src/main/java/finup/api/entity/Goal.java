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
public class Goal {

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;
    private String Name;
    private String Description;
    private Date StartDate;
    private Date FinishDate;
    private double Amount;
    private String Status;

}
