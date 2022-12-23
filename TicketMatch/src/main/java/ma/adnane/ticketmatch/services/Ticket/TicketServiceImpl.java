package ma.adnane.ticketmatch.services.Ticket;

import lombok.AllArgsConstructor;
import ma.adnane.ticketmatch.dtos.requests.TicketRequestDto;
import ma.adnane.ticketmatch.dtos.responses.TicketResponseDto;
import ma.adnane.ticketmatch.entities.Match;
import ma.adnane.ticketmatch.entities.Ticket;
import ma.adnane.ticketmatch.enums.Statut;
import ma.adnane.ticketmatch.mappers.MapperService;
import ma.adnane.ticketmatch.repositories.MatchRepository;
import ma.adnane.ticketmatch.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private MapperService mapperService;
    private MatchRepository matchRepository;
    private TicketRepository ticketRepository;

    @Override
    public TicketResponseDto buyTicket(TicketRequestDto ticketInputDto){
        if (ticketInputDto.getMatchId() == null||
                ticketInputDto.getPrice().isNaN() || ticketInputDto.getPrice() <= 0)
            throw new RuntimeException("Field missing");
        Match match = matchRepository.findById(ticketInputDto.getMatchId())
                .orElseThrow(
                        () -> new RuntimeException("Id not found")
                );
        if (match.getNombreTickets() == 0)
            throw new RuntimeException("Ticket sold out");
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketInputDto.getPrice());
        ticket.setStatut(Statut.ACTIVE);
        ticket.setRef(UUID.randomUUID().toString().substring(0,16));
        ticket.setMatch(match);

        match.setNombreTickets(match.getNombreTickets() - 1);
        matchRepository.save(match);
        return mapperService.fromTicket(ticketRepository.save(ticket));
    }

    @Override
    public void validateTicket(Long id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id Not Found"));
        if (ticket.getStatut()== Statut.DESACTIVE)
            throw new RuntimeException("Ticket deja valider");
        ticket.setStatut(Statut.DESACTIVE);
        ticketRepository.save(ticket);
    }
}

