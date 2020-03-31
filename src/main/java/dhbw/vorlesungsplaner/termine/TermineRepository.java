package dhbw.vorlesungsplaner.termine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermineRepository extends JpaRepository<Termine, Integer> {

}
