package hu.unideb.webdev.spring_data.controller;

import hu.unideb.webdev.spring_data.controller.dto.CategoryDeleteRequestDto;
import hu.unideb.webdev.spring_data.controller.dto.CategoryDto;
import hu.unideb.webdev.spring_data.controller.dto.CategoryRecordRequestDto;
import hu.unideb.webdev.spring_data.exception.UnknownCategoryException;
import hu.unideb.webdev.spring_data.model.Category;
import hu.unideb.webdev.spring_data.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category")
    public Collection<CategoryDto> listCategories() {
        return categoryService.getAllCategory()
                .stream()
                .map(model -> CategoryDto.builder()
                        .name(model.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping("/category")
    public void recordCategory(@RequestBody CategoryRecordRequestDto categoryRecordRequestDto) {
        categoryService.recordCategory(new Category(
                categoryRecordRequestDto.getName()
        ));
    }

    @DeleteMapping("/category")
    public void deleteCategory(@RequestBody CategoryDeleteRequestDto categoryDeleteRequestDto) {
        try {
            categoryService.deleteCategory(new Category(
                    categoryDeleteRequestDto.getName()
            ));
        } catch (UnknownCategoryException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
