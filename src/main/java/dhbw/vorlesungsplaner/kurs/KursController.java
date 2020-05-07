package dhbw.vorlesungsplaner.kurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "https://dhbw-organizer.herokuapp.com")
public class KursController {
    @Autowired
    private KursServiceClass kursServiceClass;

    @GetMapping("/kurs/0") //GetAll
    public List<Kurs> list() {
        return kursServiceClass.listAll();
    }


    @GetMapping("/kurs/{id}") //GetByID
    public ResponseEntity<Kurs> get(@PathVariable Integer id){
        try {
            Kurs kurs = kursServiceClass.get(id);
            return new ResponseEntity<Kurs>(kurs, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Kurs>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/kurs")
    public void add(@RequestBody Kurs kurs) {
        kursServiceClass.save(kurs);
    }

    @PutMapping("/kurs/{id}") //Put
    public ResponseEntity<?> update(@RequestBody Kurs kurs, @PathVariable Integer id) {
        try {
            Kurs existKurs = kursServiceClass.get(id);
            kursServiceClass.save(kurs);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/kurs/{id}") //Delete
    public void delete(@PathVariable Integer id) {
        kursServiceClass.delete(id);
    }
}
