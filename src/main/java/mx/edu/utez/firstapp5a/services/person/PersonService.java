package mx.edu.utez.firstapp5a.services.person;

import mx.edu.utez.firstapp5a.models.person.Person;
import mx.edu.utez.firstapp5a.models.person.PersonRepository;
import mx.edu.utez.firstapp5a.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Person>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }
}
