package dhbw.vorlesungsplaner.dozenten;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Dozenten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dozId; //PrimaryKey
    private String dozVorname;
    private String dozNachname;
    @Column
    private String dozMail;
    private String dozTel;
    private String dozMobil;
    @Column
    @JsonIgnore
    private String password;


    public String getDozMail() {
        return dozMail;
    }

    public void setDozMail(String dozMail) {
        this.dozMail = dozMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDozVorname() {
        return dozVorname;
    }

    public void setDozVorname(String dozVorname) {
        this.dozVorname = dozVorname;
    }

    public String getDozNachname() {
        return dozNachname;
    }

    public void setDozNachname(String dozNachname) {
        this.dozNachname = dozNachname;
    }

    public String getDozTel() {
        return dozTel;
    }

    public void setDozTel(String dozTel) {
        this.dozTel = dozTel;
    }

    public String getDozMobil() {
        return dozMobil;
    }

    public void setDozMobil(String dozMobil) {
        this.dozMobil = dozMobil;
    }
}
