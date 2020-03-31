package dhbw.vorlesungsplaner.kurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class KursServiceClass {
    @Autowired
    private KursRepository kursRepository;

    public List<Kurs> listAll() {
        return kursRepository.findAll();
    }

    public void save(Kurs kurs) {
        kursRepository.save(kurs);
    }

    public Kurs get(Integer id) {
        return kursRepository.findById(id).get();
    }

    public void delete(Integer id) {
        kursRepository.deleteById(id);
    }
}
