package ma.adnane.ticketmatch.services.Match;

import ma.adnane.ticketmatch.dtos.requests.MatchRequestDto;
import ma.adnane.ticketmatch.dtos.responses.MatchResponseDto;

import java.util.List;

public interface MatchService {
    MatchResponseDto ajouterMatch(MatchRequestDto matchRequestDtos);

    List<MatchResponseDto> gamesList();
}
