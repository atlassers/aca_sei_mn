package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.MovieActorDto;
import it.euris.academy.six.data.model.MovieActor;
import it.euris.academy.six.repository.MovieActorRepository;
import it.euris.academy.six.service.MovieActorService;

@Service
public class MovieActorServiceImpl implements MovieActorService {

  @Autowired
  private MovieActorRepository movieActorRepository;

  @Override
  public MovieActorDto getById(Long movieId, Long actorId) {
    return movieActorRepository.findByMovieAndActor(movieId, actorId).toDto();
  }

  @Override
  public List<MovieActorDto> getAll() {
    return movieActorRepository.findAll().stream().map(hall -> hall.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public MovieActorDto add(MovieActorDto dto) {
    return movieActorRepository.save(dto.toModel()).toDto();
  }

  @Override
  public MovieActorDto update(MovieActorDto dto) {
    return movieActorRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long idMovie, Long idActor) {
    MovieActor toDelete = movieActorRepository.findByMovieAndActor(idMovie, idActor);
    movieActorRepository.delete(toDelete);
    return movieActorRepository.findById(toDelete.getId()).isEmpty();
  }
}
