package it.euris.academy.six.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.academy.six.data.dto.MovieActorDto;
import it.euris.academy.six.service.MovieActorService;

@RestController
@RequestMapping("/movieactors")
public class MovieActorController {
  @Autowired
  MovieActorService movieActorService;

  @GetMapping("/v6")
  public List<MovieActorDto> getAll() {
      return movieActorService.getAll();
  }

  @GetMapping("/v6/{idMovie}/{idActor}")
  public MovieActorDto getById(@PathVariable("idMovie") Long idMovie,@PathVariable("idActor") Long idActor) {
      return movieActorService.getById(idMovie,idActor);
  }

  @DeleteMapping("/v6/{idMovie}/{idActor}")
  public Boolean delete(@PathVariable("idMovie") Long idMovie,@PathVariable("idActor") Long idActor) {
      return movieActorService.delete(idMovie,idActor);
  }

  @PostMapping("/v6")
  public MovieActorDto insert(@RequestBody MovieActorDto dto) {
      return movieActorService.add(dto);
  }

  @PutMapping("/v6")
  public MovieActorDto update(@RequestBody MovieActorDto dto) {
      return movieActorService.update(dto);
  }

}
