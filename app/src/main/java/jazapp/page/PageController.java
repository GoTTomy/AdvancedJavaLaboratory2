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

    public Boolean isUserAnAdmin(){
        String username = SessionUtils.getUsername();
        if(username.equals("Halfdead")){
            return true;
        }
        else{
            return false;
        }
    }

    public String adminAccess()
    {
        if(isUserAnAdmin())
        {
            System.out.println("Redirecting...");
            return "/panel.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("Access wasn't granted.");
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String editCategory()
    {
        if(isUserAnAdmin())
        {
            System.out.println("Redirecting...");
            return "/list-category.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("Access wasn't granted.");
            return "/index.xhtml?faces-redirect=true";
        }
    }

    public String editSection()
    {
        if(isUserAnAdmin())
        {
            System.out.println("Redirecting...");
            return "/list-section.xhtml?faces-redirect=true";
        }
        else
        {
            System.out.println("Access wasn't granted.");
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
