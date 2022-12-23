package ma.adnane.ticketmatch.services.Ticket;

import ma.adnane.ticketmatch.dtos.requests.TicketRequestDto;
import ma.adnane.ticketmatch.dtos.responses.TicketResponseDto;

public interface TicketService {
    TicketResponseDto buyTicket(TicketRequestDto ticketInputDto);

    void validateTicket(Long id);
}
