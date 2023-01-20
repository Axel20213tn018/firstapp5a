package mx.edu.utez.firstapp5a.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    //Auto-Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Boolean status;
    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person person;
}
