package mx.edu.utez.firstapp5a.models.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.subcategory.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    //Auto-Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 150)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories;
}
