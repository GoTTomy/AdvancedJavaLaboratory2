package jazapp.auction;

import jazapp.photo.PhotoEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequest
{
    private Long id;
    private String title;
    private String description;
    private double price;
    private Long profileId;
    private Long categoryId;
    private String photo;
    private String photoTwo;
    private String thirdPhoto;
    private List<PhotoEntity> photoEntity;

    public AuctionRequest()
    {
    }

    public AuctionRequest(Long id, String title, double price, Long profileId, Long auctionId, String description, String photo)
    {
        this.id = id;
        this.title = title;
        this.price = price;
        this.profileId = profileId;
        this.categoryId = auctionId;
        this.description= description;
        this.photo = photo;
    }

    public AuctionRequest(AuctionEntity auction) {
        this.id = auction.getAuction_id();
        this.title = auction.getTitle();
        this.price = auction.getPrice();
        this.profileId = auction.getProfile_id();
        this.categoryId = auction.getCategory_id();
        this.description = auction.getDescription();
        this.photo = auction.getPhoto_id();
        this.photoEntity = auction.getPhotoEntities();
        this.photoTwo = auction.getPhotoEntities().get(1).getPhoto();
        this.thirdPhoto = auction.getPhotoEntities().get(2).getPhoto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<PhotoEntity> getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(List<PhotoEntity> photoEntity) {
        this.photoEntity = photoEntity;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
    }

    public String getThirdPhoto() {
        return thirdPhoto;
    }

    public void setThirdPhoto(String thirdPhoto) {
        this.thirdPhoto = thirdPhoto;
    }
}