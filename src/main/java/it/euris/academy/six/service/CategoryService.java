package it.euris.academy.six.service;

import java.util.List;
import it.euris.academy.six.data.dto.CategoryDto;

public interface CategoryService {

  public CategoryDto getById(Long id);

  public List<CategoryDto> getAll();

  public CategoryDto add(CategoryDto dto);

  public CategoryDto update(CategoryDto dto);

  public Boolean delete(Long id);
}
