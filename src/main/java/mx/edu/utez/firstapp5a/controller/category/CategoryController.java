package mx.edu.utez.firstapp5a.controller.category;

import mx.edu.utez.firstapp5a.services.category.CategoryService;
import mx.edu.utez.firstapp5a.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-firstapp/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {
    @Autowired
    public CategoryService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
}