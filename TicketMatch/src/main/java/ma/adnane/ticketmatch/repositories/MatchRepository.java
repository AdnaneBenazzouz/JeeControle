package ma.adnane.ticketmatch.repositories;

import ma.adnane.ticketmatch.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
