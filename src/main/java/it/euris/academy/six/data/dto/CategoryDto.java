package it.euris.academy.six.data.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Dto {

  private String idCategory;
  private String nameCategory;
  @JsonIgnore
  private List<MovieDto> moviesCategory;
  
  
  @Override
  public Category toModel() {
    return Category.builder().id(idCategory==null?null:Long.parseLong(idCategory)).name(nameCategory).build();
  }
  
}
