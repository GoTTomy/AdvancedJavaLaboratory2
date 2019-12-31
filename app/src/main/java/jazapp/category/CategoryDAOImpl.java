package jazapp.category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryDAOImpl implements CategoryDAO{
    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional
    public List<CategoryEntity> getCategoryList()
    {
        return em.createQuery("FROM CategoryEntity ORDER BY category_id ASC ").getResultList();
    }

    @Override
    @Transactional
    public Optional<CategoryEntity> getCategoryById(Long categoryId)
    {
        var category = em.find(CategoryEntity.class,categoryId);
        return Optional.ofNullable(category);
    }

    @Override
    @Transactional
    public void save(CategoryEntity categoryEntity)
    {
        if (categoryEntity.getCategory_id() == null)
        {
            em.persist(categoryEntity);
        } else {
            em.merge(categoryEntity);
        }
    }

    @Override
    @Transactional
    public void delete(CategoryEntity categoryEntity)
    {
        if (categoryEntity.getCategory_id() != null)
        {
            var category = em.find(CategoryEntity.class, categoryEntity.getCategory_id());
            em.remove(category);
        }
        else
        {
            System.out.println("lel");
        }
    }
}
