package Data;

/**
 * Created by Amit on 9/20/2016.
 */

public class Sale {

    private String saleName;
    private String saleDescription;
    private int salePhotoId;

    public Sale(String name, String saledescription, int photoId) {
        this.saleName = name;
        this.saleDescription = saledescription;
        this.salePhotoId = photoId;
    }

    public String getName() {
        return saleName;
    }

    public void setName(String name) {
        this.saleName = name;
    }

    public String getSaledescription() {
        return saleDescription;
    }

    public void setSaledescription(String saledescription) {
        this.saleDescription = saledescription;
    }

    public int getPhotoId() {
        return salePhotoId;
    }

    public void setPhotoId(int photoId) {
        this.salePhotoId = photoId;
    }
}
