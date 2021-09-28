package it.euris.academy.six.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.euris.academy.six.data.model.MovieActor;
import it.euris.academy.six.data.model.key.MovieActorKey;

public interface MovieActorRepository extends JpaRepository<MovieActor, MovieActorKey> {

  @Query(value = "select ma.* from movie_actor ma where ma.movie_id=:movieId and ma.actor_id=:actorId",nativeQuery = true)
  MovieActor findByMovieAndActor(@Param("movieId")Long movieId,@Param("actorId")Long actorId);
}
