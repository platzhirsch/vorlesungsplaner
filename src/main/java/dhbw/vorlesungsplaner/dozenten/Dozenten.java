package dhbw.vorlesungsplaner.dozenten;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Dozenten {

    @Id
    @GeneratedValue
    private Integer dozId; //PrimaryKey
    private String dozVorname;
    private String dozNachname;
    private String dozMail;
    private Integer dozTel;
    private Integer dozMobil;
}
