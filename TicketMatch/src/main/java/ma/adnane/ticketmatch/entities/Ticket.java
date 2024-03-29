package ma.adnane.ticketmatch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adnane.ticketmatch.enums.Statut;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 16, unique = true, nullable = false)
    private String ref;
    private double price;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @ManyToOne
    private Match match;

}

