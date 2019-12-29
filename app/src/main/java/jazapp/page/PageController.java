package jazapp.page;

import jazapp.auction.AuctionRequest;
import jazapp.session.SessionUtils;
import jazapp.user.FindUserDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PageController
{
    @Inject
    FindUserDAO findUserDAO;

    @Inject
    AuctionRequest auctionRequest;

    public String showProfileForm()
    {
        return  "/profile-form.xhtml?faces-redirect=true";
    }

    public String showAuctionForm()
    {
        return  "/auction-form.xhtml?faces-redirect=true";
    }

    public String welcomeForm()
    {
        return  "/index.xhtml?faces-redirect=true";
    }

    public String adminAccess()
    {
        String session = SessionUtils.getUsername();
        System.out.println("############# " + findUserDAO.getUserByUsername(session));
        if(session.equals("kepes12"))
        {
            System.out.println("REDIRECTING TO ADMIN PAGE");
            return "/admin-panel.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("NONONONO NO ACCESITO PANIE!");
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String editCategory()
    {
        String session = SessionUtils.getUsername();
        System.out.println("############# " + session);
        if(session.equals("kepes12"))
        {
            System.out.println("REDIRECTING TO ADMIN PAGE");
            return "/list-category.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("NONONONO NO ACCESITO PANIE!");
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String editSection()
    {
        String session = SessionUtils.getUsername();
        System.out.println("############# " + session);
        if(session.equals("kepes12"))
        {
            System.out.println("REDIRECTING TO ADMIN PAGE");
            return "/list-section.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("NONONONO NO ACCESITO PANIE!");
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String editAuction()
    {
        return "/edit-list-auction.xhtml?faces-redirect=true";
    }

    public String canEditAuction()
    {
        String session = SessionUtils.getUsername();
        if(findUserDAO.getUserByUsername(session).equals(auctionRequest.getProfileId()))
        {
            return "/edit-list-auction.xhtml?faces-redirect=true";
        }
        else
        {
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String getUserName()
    {
        return SessionUtils.getUsername();
    }

}
