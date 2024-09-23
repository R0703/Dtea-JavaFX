package menu;

// new package and class buat store apa aja yang bakal ke display di katalog menu
public class Menu {
    private String name;
    private String linkToImageFile;
    private double price;
    private int stock;
    private String description;

    // init
    public Menu(String name, String linkToImageFile, double price, int stock, String description) {
        this.name = name;
        this.linkToImageFile = linkToImageFile;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    // setter & getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkToImageFile() {
        return linkToImageFile;
    }

    public void setLinkToImageFile(String linkToImageFile) {
        this.linkToImageFile = linkToImageFile;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString untuk mempermudah display
    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", linkToImageFile='" + linkToImageFile + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                '}';
    }

}
