package mx.edu.utez.firstapp5a.models.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.user.User;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    //Auto-Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String birthday;
    private String curp;
    private String sex;
    private Boolean status;
    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private User user;
}
