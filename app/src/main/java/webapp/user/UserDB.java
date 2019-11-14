package webapp.user;

import auth.ProfileEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserDB {
    @PersistenceContext
    private EntityManager em;

    public UserDB(){

    }

    @Transactional
    public void addUser(String username, String password, String name, String surrname, String email, String dateOfBirth){
        var profile = new ProfileEntity(username, password, name, surrname,email, dateOfBirth);
        //add profile to the database
        em.persist(profile);
    }

    @Transactional
    public String getUsername(String inputUsername){
        try
        {
            var username = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                    .setParameter("username", inputUsername).getSingleResult().getUsername();
            return username;
        }
        catch (NoResultException e)
        {
            return "notFound";
        }
        catch (RollbackException e)
        {
            return "notFound";
        }
    }

    @Transactional
    public String getPassword(String inputUsername){
        try{
            final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);
            var password = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                    .setParameter("username", inputUsername).getSingleResult().getPassword();
            return password;
        }
        catch (NoResultException e){
            return "notFound";
        }
        catch(RollbackException e){
            return "notFound";
        }
    }

    @Transactional
    public Boolean checkifUsernameIsUnique(String inputUsername){
        try{
            var list = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                    .setParameter("username", inputUsername).getSingleResult().getUsername();
            return false;
        }
        catch (NoResultException e){
            return true;
        }
        catch (RollbackException e){
            return true;
        }
    }
}
