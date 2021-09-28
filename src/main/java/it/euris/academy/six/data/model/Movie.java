package it.euris.academy.six.data.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "movie")
public class Movie implements Model {

  @Id
  @Column(name = "id_movie")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name_movie")
  private String name;

  @OneToMany(mappedBy = "movie") // fetch = FetchType.EAGER?
  @Builder.Default
  private List<Projection> projections = new ArrayList<Projection>();

  @OneToMany(mappedBy = "movie")
  @Builder.Default
  private Set<MovieActor> movieActors = new HashSet<MovieActor>();

  @ManyToMany
  @JoinTable(name = "category_movie", joinColumns = @JoinColumn(name = "movie_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  @Builder.Default
  List<Category> categoryMovie = new ArrayList<Category>();



  public Movie(String movieId) {
    if (movieId != null) {
      this.id = Long.parseLong(movieId);
    }

  }



  @Override
  public MovieDto toDto() {
    return MovieDto.builder().idMovie(id==null?null:id.toString())
        .nameMovie(name).categoriesMovie(categoryMovie.stream().map(x -> x.toDto()).collect(Collectors.toList()))
        .projectionsMovie(projections.stream().map(x -> x.toDto()).collect(Collectors.toList()))  
        .build();
  }

}


