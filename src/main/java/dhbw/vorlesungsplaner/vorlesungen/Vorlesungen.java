package dhbw.vorlesungsplaner.vorlesungen;

import dhbw.vorlesungsplaner.dozenten.Dozenten;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Vorlesungen {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer vorId; //Pirmary Key
    private String vorName;
    @ManyToOne
    private Dozenten dozenten;



}