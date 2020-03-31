package dhbw.vorlesungsplaner.vorlesungen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VorlesungenRepository extends JpaRepository<Vorlesungen, Integer> {
}
