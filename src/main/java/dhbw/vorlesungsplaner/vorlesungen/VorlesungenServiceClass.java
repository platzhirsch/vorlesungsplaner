package dhbw.vorlesungsplaner.vorlesungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VorlesungenServiceClass {
    @Autowired
    private VorlesungenRepository vorlesungenRepository;

    public List<Vorlesungen> listAll() {
        return vorlesungenRepository.findAll();
    }

    public void save(Vorlesungen vorlesungen){
        vorlesungenRepository.save(vorlesungen);
    }

    public Vorlesungen get(Integer id){
        return vorlesungenRepository.findById(id).get();
    }

    public void delete(Integer id){
        vorlesungenRepository.deleteById(id);
    }
}

