package finup.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notification {

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;
    private String Type;
    private String Message;
}
