package mx.edu.utez.firstapp5a.services.person;

import mx.edu.utez.firstapp5a.models.person.Person;
import mx.edu.utez.firstapp5a.models.person.PersonRepository;
import mx.edu.utez.firstapp5a.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Person> insert(Person person){
        Optional<Person> exist = this.repository.findByCurp(person.getCurp());
        if (exist.isPresent()){
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "La persona ya se encuentra regitrada"
            );
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(person),
                false,
                200,
                "Persona Registrada correctamente"
        );
    }
}
