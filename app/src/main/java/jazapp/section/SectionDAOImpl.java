package jazapp.section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SectionDAOImpl implements SectionDAO{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<SectionEntity> getSectionList(){
        return entityManager.createQuery("FROM SectionEntity ORDER BY section_id ASC").getResultList();
    }

    @Override
    @Transactional
    public SectionRequest getSection() {
        return null;
    }

    @Override
    @Transactional
    public Optional<SectionEntity> getSectionById(Long sectionId)
    {
        var section = entityManager.find(SectionEntity.class, sectionId);
        return Optional.ofNullable(section);
    }

    @Override
    @Transactional
    public void save(SectionEntity sectionEntity)
    {
        if (sectionEntity.getSection_id() == null)
        {
            entityManager.persist(sectionEntity);
        } else {
            entityManager.merge(sectionEntity);
        }
    }

    @Override
    @Transactional
    public void delete(SectionEntity sectionEntity)
    {
        if (sectionEntity.getSection_id() != null)
        {
            var section = entityManager.find(SectionEntity.class,sectionEntity.getSection_id());
            entityManager.remove(section);
        }
        else
        {
            System.out.println("lel");
        }
    }
}
