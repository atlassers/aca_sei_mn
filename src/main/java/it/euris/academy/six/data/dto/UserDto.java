package it.euris.academy.six.data.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDto implements Dto{

  private String idUser;
  private String nameUser;
  @JsonIgnore
  private List<TicketDto> ticketsUser;
  @Override
  public User toModel() {
    return User.builder().id(idUser==null?null:Long.parseLong(idUser)).name(nameUser).build();
  }

}
