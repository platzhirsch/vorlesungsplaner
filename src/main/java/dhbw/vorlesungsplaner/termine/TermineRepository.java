package dhbw.vorlesungsplaner.termine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TermineRepository extends JpaRepository<Termine, Integer> {


    public List<Termine> findBySemesterSemId(Integer id);

    public List<Termine> findByVorlesungen_Dozenten_DozId(Integer id);
}
