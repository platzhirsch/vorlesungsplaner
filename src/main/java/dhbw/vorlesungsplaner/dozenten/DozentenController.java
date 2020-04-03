package dhbw.vorlesungsplaner.dozenten;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class DozentenController {

    @Autowired
    private DozentenServiceClass dozentenServiceClass;


    @GetMapping("/dozenten/0") //GetAll
    public List<Dozenten> list() {
        return dozentenServiceClass.listAll();
    }


    @GetMapping("/dozenten/{id}") //GetByID
    public ResponseEntity<Dozenten> get(@PathVariable Integer id){
        try {
            Dozenten dozenten = dozentenServiceClass.get(id);
            return new ResponseEntity<Dozenten>(dozenten, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Dozenten>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/dozenten/{id}") //Put
    public ResponseEntity<?> update(@RequestBody Dozenten dozenten, @PathVariable Integer id) {
        try {
            Dozenten existDozenten = dozentenServiceClass.get(id);
            dozentenServiceClass.save(dozenten);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dozenten/{id}") //Delete
    public void delete(@PathVariable Integer id) {
        dozentenServiceClass.delete(id);
    }
}
