package dhbw.vorlesungsplaner.termine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin
public class TermineController {
    @Autowired
    private TermineServiceClass termineServiceClass;


    @GetMapping("/termine/0") //GetAll
    public List<Termine> list() {
        return termineServiceClass.listAll();
    }


    @GetMapping("/termine/{id}") //GetByID
    public ResponseEntity<Termine> get(@PathVariable Integer id){
        try {
            Termine termine = termineServiceClass.get(id);
            return new ResponseEntity<Termine>(termine, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Termine>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/termine/semid/{id}")
    public List<Termine> getBySemId(@PathVariable Integer id) {
        return termineServiceClass.getBySemId(id);
    }

    @GetMapping("/termine/dozenten/{id}")
    public List<Termine> getByDozId(@PathVariable Integer id) {
        return termineServiceClass.getByDozId(id);
    }


    @PostMapping("/termine")
    public void add(@RequestBody Termine termine) {
        termineServiceClass.save(termine);
    }


    @PutMapping("/termine/{id}") //Put
    public ResponseEntity<?> update(@RequestBody Termine termine, @PathVariable Integer id) {
        try {
            Termine existTermine = termineServiceClass.get(id);
            termineServiceClass.save(termine);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/termine/{id}") //Delete
    public void delete(@PathVariable Integer id) {
        termineServiceClass.delete(id);
    }
}
