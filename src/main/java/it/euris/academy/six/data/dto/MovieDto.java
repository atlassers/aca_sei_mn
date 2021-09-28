package it.euris.academy.six.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDto implements Dto {

  private String idMovie;
  private String nameMovie;
  private List<ProjectionDto> projectionsMovie;
  private List<ActorDto> actorsMovie;
  private List<CategoryDto> categoriesMovie;
  @Override
  public Movie toModel() {
  
    Movie entity = Movie.builder().id(idMovie==null?null:Long.parseLong(idMovie)).name(nameMovie).build();
    
    if (this.getCategoriesMovie() != null) {
      entity.getCategoryMovie().addAll(this.getCategoriesMovie().stream().map(CategoryDto::toModel).collect(Collectors.toList()));
    }
    return entity;
  }
  


}
