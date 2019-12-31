package jazapp.photo;

import jazapp.auction.AuctionEntity;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class PhotoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photo_id;

    private String photo;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private AuctionEntity auctionEntity;

    public PhotoEntity()
    {
    }

    public PhotoEntity(PhotoEntity photoEntity)
    {
        this.photo_id = photoEntity.getPhoto_id();
        this.photo = photoEntity.getPhoto();
        this.auctionEntity = photoEntity.getAuctionEntity();
    }

    public PhotoEntity(Long photo_id, String photo)
    {
        this.photo_id = photo_id;
        this.photo = photo;
    }

    public Long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Long id) {
        this.photo_id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AuctionEntity getAuctionEntity()
    {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }


}
