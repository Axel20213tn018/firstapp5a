package mx.edu.utez.firstapp5a.controller.person;

import mx.edu.utez.firstapp5a.models.person.Person;
import mx.edu.utez.firstapp5a.models.person.PersonDto;
import mx.edu.utez.firstapp5a.services.person.PersonService;
import mx.edu.utez.firstapp5a.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-firstapp/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Person>>>
    getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<CustomResponse<Person>> insert(
            @Valid @RequestBody PersonDto person
    ){
        return new ResponseEntity<>(
            this.service.insert(person.getPerson()),
            HttpStatus.CREATED
        );

    }
}

/*
        if (result.hasFieldErrors()){
            return  new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(person.getPerson()),
                HttpStatus.CREATED
        );
        */
