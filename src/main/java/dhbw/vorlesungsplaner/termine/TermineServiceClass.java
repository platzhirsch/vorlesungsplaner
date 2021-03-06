package dhbw.vorlesungsplaner.termine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TermineServiceClass {
    @Autowired
    private TermineRepository termineRepository;

    public List<Termine> listAll() {
        return termineRepository.findAll();
    }

    public void save(Termine termine){
        termineRepository.save(termine);
    }

    public Termine get(Integer id){
        return termineRepository.findById(id).get();
    }

    public void delete(Integer id){
        termineRepository.deleteById(id);
    }

    public List<Termine> getBySemId(Integer id) {
        return termineRepository.findBySemesterSemId(id);
    }

    public List<Termine> getByDozId(Integer id) {
        return termineRepository.findByVorlesungen_Dozenten_DozId(id);
    }

}
