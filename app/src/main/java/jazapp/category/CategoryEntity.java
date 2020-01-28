package jazapp.category;

import javax.inject.Named;
import javax.persistence.*;

@Named
@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;

    private String name,description;

    private Long section_id;

    public CategoryEntity(){

    }
    public CategoryEntity(Long category_id, String name, String description){
        this.category_id = category_id;
        this.name=name;
        this.description=description;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getSection_id() {
        return section_id;
    }

    public void setCategory_id(Long id) {
        this.category_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }
}
