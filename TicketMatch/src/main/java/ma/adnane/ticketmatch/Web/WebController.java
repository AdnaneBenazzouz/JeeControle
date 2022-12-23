package ma.adnane.ticketmatch.Web;

import lombok.AllArgsConstructor;
import ma.adnane.ticketmatch.dtos.requests.MatchRequestDto;
import ma.adnane.ticketmatch.dtos.requests.TicketRequestDto;
import ma.adnane.ticketmatch.dtos.responses.MatchResponseDto;
import ma.adnane.ticketmatch.dtos.responses.TicketResponseDto;
import ma.adnane.ticketmatch.services.Match.MatchService;
import ma.adnane.ticketmatch.services.Ticket.TicketService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private MatchService matchService;
    private TicketService ticketService;

    @MutationMapping
    private MatchResponseDto addGame(@Argument MatchRequestDto gameInputDto) {
        return matchService.ajouterMatch(gameInputDto);
    }

    @QueryMapping
    private List<MatchResponseDto> getGames(){
        return matchService.gamesList();
    }


    @MutationMapping
    private TicketResponseDto getTicket(@Argument TicketRequestDto ticketInputDto) {
        return ticketService.buyTicket(ticketInputDto);
    }

    @MutationMapping
    private void updateTicket(@Argument Long id) {
        ticketService.validateTicket(id);
    }
}
