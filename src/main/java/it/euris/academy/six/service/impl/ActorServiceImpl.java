package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.ActorDto;
import it.euris.academy.six.data.model.Actor;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.exception.IdMustNotBeNullException;
import it.euris.academy.six.repository.ActorRepository;
import it.euris.academy.six.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService{

  @Autowired
  private ActorRepository actorRepository;
  
  @Override
  public ActorDto getById(Long id) {
    return actorRepository.findById(id).orElse(new Actor()).toDto();
  }

  @Override
  public List<ActorDto> getAll() {
    return actorRepository.findAll().stream().map(actor->actor.toDto()).collect(Collectors.toList());
  }

  @Override
  public ActorDto add(ActorDto dto) {
    if (dto.getIdActor()!=null) {
      throw new IdMustBeNullException();
    }
    Actor modelActor = dto.toModel();
    Actor saveActor = actorRepository.save(modelActor);
    return saveActor.toDto();
  }

  @Override
  public ActorDto update(ActorDto dto) {
    if (dto.getIdActor()==null) {
      throw new IdMustNotBeNullException();
    }
    return actorRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    actorRepository.deleteById(id);
    return actorRepository.findById(id).isEmpty();
  }

}
