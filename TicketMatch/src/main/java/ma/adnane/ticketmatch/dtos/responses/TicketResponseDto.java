package ma.adnane.ticketmatch.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {
    private Long id;
    private Double price;
    private String ref;
    private MatchResponseDto matchResponseDto;
}
