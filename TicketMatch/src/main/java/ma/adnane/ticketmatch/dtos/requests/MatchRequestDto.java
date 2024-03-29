package ma.adnane.ticketmatch.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class MatchRequestDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;
    private String equipe1;
    private String equipe2;
    private Integer NombreTickets;
    private String lieux;
}