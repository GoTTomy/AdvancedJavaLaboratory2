package jazapp.category;

public class CategoryRequest {
    private Long category_id;
    private Long section_id;
    private String name;
    private String description;

    public CategoryRequest(){

    }
    public CategoryRequest(Long id, Long sectionId, String name, String description){
        this.category_id=id;
        this.section_id=sectionId;
        this.name=name;
        this.description=description;
    }

    public CategoryRequest(CategoryEntity category) {
        this.category_id=category.getCategory_id();
        this.section_id=category.getSection_id();
        this.name=category.getName();
        this.description=category.getDescription();
    }

    public Long getId() {
        return category_id;
    }

    public Long getSection_Id() {
        return section_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.category_id = id;
    }

    public void setSection_Id(Long sectionId) {
        this.section_id = sectionId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
