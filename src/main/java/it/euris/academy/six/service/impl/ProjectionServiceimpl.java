package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.ProjectionDto;
import it.euris.academy.six.data.model.Projection;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.exception.IdMustNotBeNullException;
import it.euris.academy.six.repository.ProjectionRepository;
import it.euris.academy.six.service.ProjectionService;


@Service
public class ProjectionServiceimpl implements ProjectionService {

  @Autowired
  private ProjectionRepository projectionRepository;
  
  @Override
  public ProjectionDto getById(Long id) {
    return projectionRepository.findById(id).orElse(new Projection()).toDto();
  }

  @Override
  public List<ProjectionDto> getAll() {
    return projectionRepository.findAll()
        .stream().map(curProduct -> curProduct.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ProjectionDto add(ProjectionDto projectionDto) {
    if (projectionDto.getIdProjection() != null) {
      throw new IdMustBeNullException();
    }
    return projectionRepository.save(projectionDto.toModel()).toDto();
  }

  @Override
  public ProjectionDto update(ProjectionDto projectionDto) {
    if (projectionDto.getIdProjection() != null) {
      throw new IdMustNotBeNullException();
    }
    return projectionRepository.save(projectionDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    projectionRepository.deleteById(id);
    return projectionRepository.findById(id).isEmpty();
  }

}
