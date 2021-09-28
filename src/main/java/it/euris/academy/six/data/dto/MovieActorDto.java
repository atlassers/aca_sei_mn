package it.euris.academy.six.data.dto;

import it.euris.academy.six.data.archetype.Dto;
import it.euris.academy.six.data.model.Actor;
import it.euris.academy.six.data.model.Movie;
import it.euris.academy.six.data.model.MovieActor;
import it.euris.academy.six.data.model.key.MovieActorKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorDto implements Dto {

  private MovieActorKey idMA;
  private String actorMA;
  private String movieMA;
  private String roleMA;

  @Override
  public MovieActor toModel() {
    return MovieActor.builder()
        .id(new MovieActorKey(Long.parseLong(actorMA), Long.parseLong(movieMA)))
        .movie(new Movie(movieMA)).actor(new Actor(actorMA)).role(roleMA).build();
  }
}
