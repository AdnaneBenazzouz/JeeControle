package ma.adnane.ticketmatch.mappers;

import ma.adnane.ticketmatch.dtos.responses.MatchResponseDto;
import ma.adnane.ticketmatch.dtos.responses.TicketResponseDto;
import ma.adnane.ticketmatch.entities.Match;
import ma.adnane.ticketmatch.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public MatchResponseDto fromMatch(Match math){
        MatchResponseDto matchResponseDto = new MatchResponseDto();
        BeanUtils.copyProperties(math, matchResponseDto);
        return  matchResponseDto;
    }

    public TicketResponseDto fromTicket(Ticket ticket){
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        BeanUtils.copyProperties(ticket, ticketResponseDto);
        ticketResponseDto.setMatchResponseDto(fromMatch(ticket.getMatch()));
        return ticketResponseDto;
    }

}
