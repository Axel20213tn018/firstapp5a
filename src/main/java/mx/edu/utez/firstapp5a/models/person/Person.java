package mx.edu.utez.firstapp5a.models.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.user.User;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String birthday;
    private String curp;
    private Boolean status;
    private String sex;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, optional = false)
    private User user;

    public Person(Long id, String name, String surname, String lastname, String birthday, String curp, Boolean status, String sex, User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.curp = curp;
        this.status = status;
        this.sex = sex;
        this.user = user;
        this.user.setPerson(this);
    }
}
