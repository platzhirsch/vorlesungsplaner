package dhbw.vorlesungsplaner.dozenten;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DozentenRepository extends JpaRepository<Dozenten, Integer> {
    Dozenten findAllByDozMail(String dozMail);
}
