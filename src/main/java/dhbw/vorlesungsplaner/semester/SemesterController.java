package dhbw.vorlesungsplaner.semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "https://dhbw-organizer.herokuapp.com")
public class SemesterController {

    @Autowired
    private SemesterServiceClass semesterServiceClass;


    @GetMapping("/semester/0") //GetAll
    public List<Semester> list() {
        return semesterServiceClass.listAll();
    }

    @GetMapping("/semester/{id}") //GetByID
    public ResponseEntity<Semester> get(@PathVariable Integer id){
        try {
            Semester semester = semesterServiceClass.get(id);
            return new ResponseEntity<Semester>(semester, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Semester>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/semester")
    public void add(@RequestBody Semester semester) {
        semesterServiceClass.save(semester);
    }


    @PutMapping("/semester/{id}") //Put
    public ResponseEntity<?> update(@RequestBody Semester semester, @PathVariable Integer id) {
        try {
            Semester existSemester = semesterServiceClass.get(id);
            semesterServiceClass.save(semester);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/semester/{id}") //Delete
    public void delete(@PathVariable Integer id) {
        semesterServiceClass.delete(id);
    }
}

