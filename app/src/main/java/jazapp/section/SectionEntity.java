package jazapp.section;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class SectionEntity {
    @Id
    @Column(name="section_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    public SectionEntity(){
    }

    public SectionEntity(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
