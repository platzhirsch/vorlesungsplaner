package dhbw.vorlesungsplaner.kurs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Kurs {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer kurId; //Primary Key
    private String kurBezeichnung;



}
