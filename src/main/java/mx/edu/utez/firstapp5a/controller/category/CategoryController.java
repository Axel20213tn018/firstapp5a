package mx.edu.utez.firstapp5a.controller.category;

import mx.edu.utez.firstapp5a.models.category.Category;
import mx.edu.utez.firstapp5a.models.category.CategoryDto;
import mx.edu.utez.firstapp5a.services.category.CategoryService;
import mx.edu.utez.firstapp5a.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-firstapp/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    public CategoryService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Category>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Category>> insert(
            @RequestBody CategoryDto category, @Valid BindingResult result
    ){
        if (result.hasFieldErrors()){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(category.getCategories()),
                HttpStatus.CREATED
        );
    }
}