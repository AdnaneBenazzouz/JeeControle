package ma.adnane.ticketmatch.repositories;

import ma.adnane.ticketmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
