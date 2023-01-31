package mx.edu.utez.firstapp5a.models.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.user.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDto {
    private Long id;
    @NotEmpty(message = "Campo Obligatorio")
    @Size(min = 3, max = 50)
    private String name;
    @NotEmpty(message = "Campo Obligatorio")
    @Size(min = 3, max = 50)
    private String surname;
    private String lastname;
    @NotEmpty(message = "Campo Obligatorio")
    private String birthday;
    @NotEmpty(message = "Campo Obligatorio")
    @Pattern(regexp = "^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0\\d|1[0-2])(?:[0-2]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$")
    @Size(min = 18, max = 18)
    private String curp;
    private Boolean status = true;
    @NotEmpty
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
