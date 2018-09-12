package nimbus.zipzap;

public class Barang {
    public int id;
    public String name;
    public String price;
    public String category;
    public String seller;
    public int stats;
    public int image;

    public Barang(int id, String name, String price, String category, String seller, int stats, int image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.stats = stats;
        this.image = image;
    }
}
