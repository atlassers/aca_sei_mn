package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.ProjectionDto;

public interface ProjectionService {

  public ProjectionDto getById(Long id);

  public List<ProjectionDto> getAll();

  public ProjectionDto add(ProjectionDto dto);

  public ProjectionDto update(ProjectionDto dto);

  public Boolean delete(Long id);
}
