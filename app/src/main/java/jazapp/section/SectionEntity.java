package jazapp.section;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long section_id;

    private String name;

    public SectionEntity(){
    }

    public SectionEntity(Long section_id, String name){
        this.section_id = section_id;
        this.name=name;
    }

    public Long getSection_id(){
        return section_id;
    }

    public String getName() {
        return name;
    }

    public void setSection_id(Long id) {
        this.section_id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
