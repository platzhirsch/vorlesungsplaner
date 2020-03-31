package dhbw.vorlesungsplaner.semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SemesterServiceClass {
    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> listAll() {
        return semesterRepository.findAll();
    }

    public void save(Semester semester) {
        semesterRepository.save(semester);
    }

    public Semester get(Integer id){
        return semesterRepository.findById(id).get();
    }

    public void delete(Integer id){
        semesterRepository.deleteById(id);
    }
}

