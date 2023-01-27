package mx.edu.utez.firstapp5a.models.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.firstapp5a.models.subcategory.SubCategory;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private Boolean status;
    private List<SubCategory> subCategories;

    public List<SubCategory> getCategories(){
        return null;
    }
}
