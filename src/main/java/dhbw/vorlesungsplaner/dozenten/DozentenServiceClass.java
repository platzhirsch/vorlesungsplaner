package dhbw.vorlesungsplaner.dozenten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DozentenServiceClass {
    @Autowired
    private DozentenRepository dozentenRepository;

    private String dozMail;
    private String password;
    private String dozVorname;
    private String dozNachname;
    private String dozTel;
    private String dozMobil;

    public List<Dozenten> listAll() {
        return  dozentenRepository.findAll();
    }

    public void save(Dozenten dozenten){
        dozentenRepository.save(dozenten);
    }

    public Dozenten get(Integer id) {
        return dozentenRepository.findById(id).get();
    }

    public void delete(Integer id) {
        dozentenRepository.deleteById(id);
    }

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

    public DozentenRepository getDozentenRepository() {
        return dozentenRepository;
    }

    public void setDozentenRepository(DozentenRepository dozentenRepository) {
        this.dozentenRepository = dozentenRepository;
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
