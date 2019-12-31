package jazapp.section;

public class SectionRequest {
    private Long id;
    private String name;

    public SectionRequest(){
    }
    public SectionRequest(Long id, String name){
        this.id = id;
        this.name=name;
    }

    public SectionRequest(SectionEntity section) {
        this.id = section.getSection_id();
        this.name=section.getName();
    }

    public Long getId() {
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
