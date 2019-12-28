package jazapp.section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jazapp.ParamRetriever;

import java.util.List;

@Named
@RequestScoped
public class SectionController {
    private SectionRequest sectionRequest;

    @Inject
    SectionDAO sectionDAO;

    @Inject
    ParamRetriever paramRetriver;

    public List<SectionEntity> getSectionList(){
        return sectionDAO.getSectionList();
    }

    private SectionRequest createSectionRequest()
    {
        if (paramRetriver.contains("sectionId"))
        {
            var sectionId = paramRetriver.getLong("sectionId");
            var section = sectionDAO.getSectionById(sectionId).orElseThrow();
            return new SectionRequest(section);
        }
        return new SectionRequest();
    }

    public SectionRequest getSectionRequest() {
        if (sectionRequest == null) {
            sectionRequest = createSectionRequest();
        }
        return sectionRequest;
    }

    public String save(){
        var section = new SectionEntity(sectionRequest.getId(),sectionRequest.getName());
        sectionDAO.save(section);
        return "/list-section.xhtml?faces-redirect=true";
    }

    public String delete(){
        var section = new SectionEntity(sectionRequest.getId(),sectionRequest.getName());
        sectionDAO.delete(section);
        return "/list-section.xhtml?faces-redirect=true";
    }
}
