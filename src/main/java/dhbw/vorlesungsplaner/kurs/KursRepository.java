package dhbw.vorlesungsplaner.kurs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursRepository extends JpaRepository<Kurs, Integer> {
}
