package it.euris.academy.six.data.dto;

import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Projection;
import it.euris.academy.six.data.model.Ticket;
import it.euris.academy.six.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDto implements Dto {

  private String idTicket;
  private String seatTicket;
  private String userTicket;
  private String projectionTicket;
  @Override
  public Ticket toModel() {
    return Ticket.builder().id(idTicket == null ? null : Long.parseLong(idTicket))
        .seat(seatTicket).user(new User(userTicket)).projection(new Projection(projectionTicket)).build();
  }
}
