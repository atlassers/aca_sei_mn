package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.ActorDto;

public interface ActorService {

  public ActorDto getById(Long id);

  public List<ActorDto> getAll();

  public ActorDto add(ActorDto dto);

  public ActorDto update(ActorDto dto);

  public Boolean delete(Long id);

}
