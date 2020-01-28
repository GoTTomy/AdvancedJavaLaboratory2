package jazapp.category;

import jazapp.ParamRetriever;
import jazapp.section.SectionRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class CategoryController {
    private CategoryRequest categoryRequest;

    @Inject
    CategoryDAO categoryDAO;

    @Inject
    ParamRetriever paramRetriever;

    public List<CategoryEntity> getCategoryList()
    {
        return categoryDAO.getCategoryList();
    }

    public CategoryRequest getCategoryRequest()
    {
        if (categoryRequest == null)
        {
            categoryRequest = createCategoryRequest();
        }
        return categoryRequest;
    }

    private CategoryRequest createCategoryRequest()
    {
        if (paramRetriever.contains("category_id"))
        {
            var categoryId = paramRetriever.getLong("category_id");
            var category = categoryDAO.getCategoryById(categoryId).orElseThrow();
            return new CategoryRequest(category);
        }
        return new CategoryRequest();
    }

    public String save()
    {
        var category = new CategoryEntity(categoryRequest.getId(), categoryRequest.getName(), categoryRequest.getDescription());
        category.setSection_id(categoryRequest.getSection_id());
        categoryDAO.save(category);
        return "/list-category.xhtml?faces-redirect=true";
    }

    public String delete()
    {
        var section = categoryDAO.getCategoryById(categoryRequest.getId()).get();
        categoryDAO.delete(section);
        return "/list-category.xhtml?faces-redirect=true";
    }
}
