package program.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.dto.category.CategoryCreateDTO;
import program.dto.category.CategoryUpdateDTO;
import program.entities.CategoryEntity;
import program.repositories.CategoryRepository;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/foto")
public class FotoController {
    private final FotoRepository fotoRepository;

    @GetMapping
    public ResponseEntity<List<FotoEntity>> index() {
        var list = fotoRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<FotoEntity> create(CategoryCreateDTO model) {
        CategoryEntity category = new CategoryEntity();
        category.setName(model.getName());
        categoryRepository.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<FotoEntity> get(@PathVariable("id") Integer categoryId) {
        var extCategory = categoryRepository.findById(categoryId);
        return new ResponseEntity<>(extCategory.get(), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<FotoEntity> update(@PathVariable("id") Integer categoryId,
                                                 CategoryUpdateDTO model) {
        CategoryEntity category = categoryRepository.findById(categoryId).get();
        category.setName(model.getName());
        var upatedCategory = categoryRepository.save(category);
        return new ResponseEntity<>(upatedCategory, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer categoryId) {
        fotoRepository.deleteById(categoryId);
        return new ResponseEntity<>("Cateogory Delete", HttpStatus.OK);
    }
}
