package jazapp.auction;

import jazapp.ParamRetriever;
import jazapp.photo.PhotoDAO;
import jazapp.photo.PhotoEntity;
import jazapp.session.SessionUtils;
import jazapp.user.FindUserDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionController
{
    @Inject
    FindUserDAO findUserDAO;

    @Inject
    AuctionDAO auctionDAO;

    @Inject
    ParamRetriever paramRetriever;

    @Inject
    PhotoDAO photoDAO;

    private AuctionRequest auctionRequest;

    public List<AuctionEntity> getAuctionList()
    {
        return auctionDAO.getAuctionList();
    }

    public AuctionRequest getAuctionRequest()
    {
        if(auctionRequest == null)
        {
            auctionRequest = createCategoryRequest();
        }
        return auctionRequest;
    }

    private AuctionRequest createCategoryRequest()
    {
        if(paramRetriever.contains("auctionId"))
        {
            var auctionId = paramRetriever.getLong("auctionId");
            var auction = auctionDAO.getAuctionById(auctionId).orElseThrow();
            return new AuctionRequest(auction);
        }
        return new AuctionRequest();
    }

    public String save()
    {
        String username = SessionUtils.getUsername();

        var auction = new AuctionEntity(auctionRequest.getId(),auctionRequest.getTitle(),auctionRequest.getPrice(),
                auctionRequest.getDescription(),auctionRequest.getProfile_id(),auctionRequest.getCategoryId());
        System.out.println("$$$$$$$$$$$$$$$$");
        System.out.println(auctionRequest.getId());
        System.out.println(auctionRequest.getCategoryId());
        List<PhotoEntity> photo = photoDAO.getByAuctionId(auctionRequest.getId());
        System.out.println("%%%%%%%%%%%%%%%%");
        System.out.println(photo);
        if(!photo.isEmpty())
        {
            photo.get(0).setPhoto(auctionRequest.getPhoto());
            photo.get(1).setPhoto(auctionRequest.getPhotoTwo());
            photo.get(2).setPhoto(auctionRequest.getThirdPhoto());

            photo.get(0).setAuctionEntity(auction);
            photo.get(1).setAuctionEntity(auction);
            photo.get(2).setAuctionEntity(auction);
        }
        else
        {
            photo.add(new PhotoEntity());
            photo.add(new PhotoEntity());
            photo.add(new PhotoEntity());

            photo.get(0).setPhoto(auctionRequest.getPhoto());
            photo.get(1).setPhoto(auctionRequest.getPhotoTwo());
            photo.get(2).setPhoto(auctionRequest.getThirdPhoto());

        }

        assert username != null;

        auction.setProfileId(findUserDAO.getUserByUsername(username));
        auction.setCategoryId(auctionRequest.getCategoryId());
        photo.get(0).setAuctionEntity(auction);
        photo.get(1).setAuctionEntity(auction);
        photo.get(2).setAuctionEntity(auction);
        auction.addPhoto(photo.get(0));
        auction.addPhoto(photo.get(1));
        auction.addPhoto(photo.get(2));
        System.out.println("WWWWWWWWWWWWWWW " + auctionRequest.getCategoryId());
        auctionDAO.save(auction);
        System.out.println("%%%%%%%%%%%%%%%%%%");
        return "/auction-form.xhtml?faces-redirect=true";
    }

    public String delete()
    {
        auctionDAO.delete(auctionRequest.getId());
        return "/auction-form.xhtml?faces-redirect=true";
    }
}