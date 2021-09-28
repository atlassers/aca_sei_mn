package it.euris.academy.six.data.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import it.euris.academy.six.data.archetype.Model;
import it.euris.academy.six.data.dto.MovieActorDto;
import it.euris.academy.six.data.model.key.MovieActorKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie_actor")
@Entity
public class MovieActor implements Model {

  @EmbeddedId
  private MovieActorKey id;

  @ManyToOne
  @MapsId("actorId")
  @JoinColumn(name = "actor_id")
  private Actor actor;

  @ManyToOne
  @MapsId("movieId")
  @JoinColumn(name = "movie_id")
  private Movie movie;

  @Column(name = "role")
  private String role;

  @Override
  public MovieActorDto toDto() {
    return MovieActorDto.builder().idMA(id).movieMA(movie.getId().toString())
        .actorMA(actor.getId().toString()).roleMA(role).build();
  }



}
