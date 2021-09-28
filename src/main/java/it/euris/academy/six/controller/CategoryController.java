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
import it.euris.academy.six.data.dto.CategoryDto;
import it.euris.academy.six.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
  @Autowired
  CategoryService categoryService;

  @GetMapping("/v6")
  public List<CategoryDto> getAll() {
      return categoryService.getAll();
  }

  @GetMapping("/v6/{id}")
  public CategoryDto getById(@PathVariable("id") Long id) {
      return categoryService.getById(id);
  }

  @DeleteMapping("/v6/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return categoryService.delete(id);
  }

  @PostMapping("/v6")
  public CategoryDto insert(@RequestBody CategoryDto CategoryDto) {
      return categoryService.add(CategoryDto);
  }

  @PutMapping("/v6")
  public CategoryDto update(@RequestBody CategoryDto CategoryDto) {
      return categoryService.update(CategoryDto);
  }

}
