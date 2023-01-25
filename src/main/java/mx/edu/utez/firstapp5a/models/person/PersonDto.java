package mx.edu.utez.firstapp5a.models.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDto {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String birthday;
    private String curp;
    private Boolean status;
    private String sex;
    private User user;

    public Person getPerson(){
        return new Person(
                getId(),
                getName(),
                getSurname(),
                getLastname(),
                getBirthday(),
                getCurp(),
                getStatus(),
                getSex(),
                getUser()
        );
    }
}
