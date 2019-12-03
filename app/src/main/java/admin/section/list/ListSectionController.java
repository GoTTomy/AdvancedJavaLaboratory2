package admin.section.list;

import admin.section.SectionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ListSectionController {
    public List<SectionEntity> getSection(){
        return new ArrayList<>();
    }
}
