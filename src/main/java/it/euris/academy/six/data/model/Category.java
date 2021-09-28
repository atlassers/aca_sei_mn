package it.euris.academy.six.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_category")
  private Long id;

  @Column(name = "name_category")
  private String name;

  @ManyToMany(mappedBy = "categoryMovie")
  @Builder.Default
  List<Movie>movie = new ArrayList<Movie>();

  @Override
  public CategoryDto toDto() {
    return CategoryDto.builder().idCategory(id==null?null:id.toString()).nameCategory(name).build();
  }

}


