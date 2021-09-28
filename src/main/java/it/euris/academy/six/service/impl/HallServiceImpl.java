package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.HallDto;
import it.euris.academy.six.data.model.Hall;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.exception.IdMustNotBeNullException;
import it.euris.academy.six.repository.HallRepository;
import it.euris.academy.six.service.HallService;

@Service
public class HallServiceImpl implements HallService{

  @Autowired
  private HallRepository hallRepository;
  
  @Override
  public HallDto getById(Long id) {
    return hallRepository.findById(id).orElse(new Hall()).toDto();
  }

  @Override
  public List<HallDto> getAll() {
    return hallRepository.findAll().stream().map(hall->hall.toDto()).collect(Collectors.toList());
  }

  @Override
  public HallDto add(HallDto dto) {
    if (dto.getIdHall()!=null) {
      throw new IdMustBeNullException();
    }
    Hall modelHall=dto.toModel();
    Hall savHall=hallRepository.save(modelHall);
    return savHall.toDto();
  }

  @Override
  public HallDto update(HallDto dto) {
    if (dto.getIdHall()==null) {
      throw new IdMustNotBeNullException();
    }
    return hallRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    hallRepository.deleteById(id);
    return hallRepository.findById(id).isEmpty();
  }

}
