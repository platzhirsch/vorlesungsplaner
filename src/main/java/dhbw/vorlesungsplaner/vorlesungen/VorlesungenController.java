package dhbw.vorlesungsplaner.vorlesungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class VorlesungenController {
    @Autowired
    private VorlesungenServiceClass vorlesungenServiceClass;


    @GetMapping("/vorlesungen/0") //GetAll
    public List<Vorlesungen> list() {
        return vorlesungenServiceClass.listAll();
    }


    @GetMapping("/vorlesungen/{id}") //GetByID
    public ResponseEntity<Vorlesungen> get(@PathVariable Integer id){
        try {
            Vorlesungen vorlesungen = vorlesungenServiceClass.get(id);
            return new ResponseEntity<Vorlesungen>(vorlesungen, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vorlesungen>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/vorlesungen")
    public void add(@RequestBody Vorlesungen vorlesungen) {
        vorlesungenServiceClass.save(vorlesungen);
    }


    @PutMapping("/vorlesungen/{id}") //Put
    public ResponseEntity<?> update(@RequestBody Vorlesungen vorlesungen, @PathVariable Integer id) {
        try {
            Vorlesungen existVorlesung = vorlesungenServiceClass.get(id);
            vorlesungenServiceClass.save(vorlesungen);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vorlesungen/{id}") //Delete
    public void delete(@PathVariable Integer id) {
        vorlesungenServiceClass.delete(id);
    }
}

