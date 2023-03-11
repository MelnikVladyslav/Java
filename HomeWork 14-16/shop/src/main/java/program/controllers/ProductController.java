package program.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.dto.category.ProductCreateDTO;
import program.dto.category.ProductItemDTO;
import program.dto.category.ProductUpdateDTO;
import program.entities.ProductEntity;
import program.interfaces.ProductService;
import program.mapper.ProductMapper;
import program.repositories.ProductRepository;
import program.storage.StorageService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/productes")
public class ProductController {
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<CategoryItemDTO>> index() {
        var model = productService.get();
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CategoryItemDTO> create(@ModelAttribute ProductCreateDTO model) {
        var result = productService.create(model);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryItemDTO> get(@PathVariable("id") Integer categoryId) {
        var cat = productService.get(categoryId);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
    @PutMapping(value = "{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CategoryItemDTO> update(@PathVariable("id") Integer categoryId,
                                                  @ModelAttribute ProductUpdateDTO model) {
        var result = productService.update(categoryId, model);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer categoryId) {
        productService.delete(categoryId);
        return new ResponseEntity<>("Category Delete", HttpStatus.OK);
    }
}
