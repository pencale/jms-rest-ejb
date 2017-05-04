package jms.ee.ejb;

/**
 * Created by apenchukov on 5/4/2017.
 */
public class AdProduct {
    private String name;
    private Long price;
    private String imageUrl;

    public AdProduct(String name, Long price, String imageurl) {
        setImageUrl(imageurl);
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}