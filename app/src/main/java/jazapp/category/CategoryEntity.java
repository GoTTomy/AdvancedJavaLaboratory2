package jazapp.category;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name,description;
    private Long section_id;

    public CategoryEntity(){

    }

    public CategoryEntity(Long id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
