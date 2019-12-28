package jazapp.category;

import jazapp.section.SectionDAO;

public class CategoryRequest {
    private Long id;
    private Long sectionId;
    private String name;
    private String description;

    public CategoryRequest(){

    }
    public CategoryRequest(Long id, Long sectionId, String name, String description){
        this.id=id;
        this.sectionId=sectionId;
        this.name=name;
        this.description=description;
    }

    public CategoryRequest(CategoryEntity category) {
        this.id=category.getId();
        this.sectionId=category.getSection_id();
        this.name=category.getName();
        this.description=category.getDescription();
    }

    public Long getId() {
        return id;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
