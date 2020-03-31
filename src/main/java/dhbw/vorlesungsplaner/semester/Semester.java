package dhbw.vorlesungsplaner.semester;

import dhbw.vorlesungsplaner.kurs.Kurs;
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
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer semId; //Primary Key

    //private Integer kursID;

    private Integer sem_bez;

    @ManyToOne
    private Kurs kurs;
}