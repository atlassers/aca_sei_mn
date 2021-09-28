package it.euris.academy.six.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.academy.six.data.dto.CategoryDto;
import it.euris.academy.six.data.model.Category;
import it.euris.academy.six.exception.IdMustBeNullException;
import it.euris.academy.six.exception.IdMustNotBeNullException;
import it.euris.academy.six.repository.CategoryRepository;
import it.euris.academy.six.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CategoryRepository categoryRepository;
  
  @Override
  public CategoryDto getById(Long id) {
    return categoryRepository.findById(id).orElse(new Category()).toDto();
  }

  @Override
  public List<CategoryDto> getAll() {
    return categoryRepository.findAll().stream().map(category->category.toDto()).collect(Collectors.toList());
  }

  @Override
  public CategoryDto add(CategoryDto dto) {
    if (dto.getIdCategory()!=null) {
      throw new IdMustBeNullException();
    }
    Category model=dto.toModel();
    Category saveCategory=categoryRepository.save(model);
    return saveCategory.toDto();
  }

  @Override
  public CategoryDto update(CategoryDto dto) {
    if (dto.getIdCategory()==null) {
      throw new IdMustNotBeNullException();
    }
    return categoryRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    categoryRepository.deleteById(id);
    return categoryRepository.findById(id).isEmpty();
  }
  

}
