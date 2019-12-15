package jazapp.section.list;

import jazapp.section.SectionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ListSectionController {
    public List<SectionEntity> getSection(){
        var sections = new ArrayList<SectionEntity>();
        sections.add(new SectionEntity(1L,"Section1"));
        sections.add(new SectionEntity(2L,"Section2"));
        sections.add(new SectionEntity(3L,"Section3"));
        sections.add(new SectionEntity(4L,"Section4"));
        return sections;
    }
}
