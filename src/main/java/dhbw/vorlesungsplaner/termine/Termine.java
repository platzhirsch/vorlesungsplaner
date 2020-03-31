package dhbw.vorlesungsplaner.termine;

import dhbw.vorlesungsplaner.semester.Semester;
import dhbw.vorlesungsplaner.vorlesungen.Vorlesungen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Termine {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer terId; //Primary Key
    private Date terDatum;
    private Time terVonUhrzeit;
    private Time terBisUhrzeit;
    private Integer raumNr;
    private Boolean verfügbar;

    @ManyToOne
    private Vorlesungen vorlesungen; //Foreign key -> Vorlesungen



    @ManyToOne
    private Semester semester; //Foreign key -> Semester
    }


