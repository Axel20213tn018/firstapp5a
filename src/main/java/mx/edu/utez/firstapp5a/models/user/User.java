package mx.edu.utez.firstapp5a.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.person.Person;
import mx.edu.utez.firstapp5a.models.role.Role;

import javax.persistence.*;
import java.util.Set;

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
    //@Column(columnDefinition = "TIMESTAMP NULL ")
    private String lastAccess;
    private Boolean blocked;
    private String token;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    @JsonIgnore
    private Person person;
    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;
}
