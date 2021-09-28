package it.euris.academy.six.data.dto;

import java.util.List;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Hall;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HallDto implements Dto {

  private String idHall;
  private String nameHall;
  private String capacityHall;
  private List<ProjectionDto> projectionsHall;
  @Override
  public Hall toModel() {
    return Hall.builder().id(idHall==null?null:Long.parseLong(idHall)).name(nameHall).capacity(Integer.parseInt(capacityHall)).build();
  }

}
