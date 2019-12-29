package jazapp.auction;

import jazapp.photo.PhotoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="auction")
public class AuctionEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auction_id;

    private String title;

    private double price;

    private String description;

    private Long profile_id;

    private Long category_id;

    private String photo_id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="auctionEntity",
            cascade= {CascadeType.ALL})
    private List<PhotoEntity> photoEntities;

    public AuctionEntity()
    {
    }

    public AuctionEntity(Long auction_id, String title, double price, String description, String photo_id)
    {
        this.auction_id = auction_id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.photo_id = photo_id;
    }

    public Long getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(Long id) {
        this.auction_id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profileId) {
        this.profile_id = profileId;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long categoryId) {
        this.category_id = categoryId;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo) {
        this.photo_id = photo;
    }

    public List<PhotoEntity> getPhotoEntities() {
        return photoEntities;
    }

    public void setPhotoEntities(List<PhotoEntity> photoEntities) {
        this.photoEntities = photoEntities;
    }

    public void addPhoto(PhotoEntity pE)
    {
        if(photoEntities == null)
        {
            photoEntities = new ArrayList<>();
        }
        photoEntities.add(pE);
    }

}
