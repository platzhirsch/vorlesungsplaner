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
}
