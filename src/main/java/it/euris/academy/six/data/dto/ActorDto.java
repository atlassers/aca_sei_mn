package it.euris.academy.six.data.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorDto implements Dto {

  private String idActor;
  private String nameActor;
  @JsonIgnore
  private List<MovieActorDto> moviesActor;
  @Override
  public Actor toModel() {
    return Actor.builder().id(idActor==null?null:Long.parseLong(idActor)).name(nameActor).build();
    
  }

}
