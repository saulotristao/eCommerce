package main.calm.eCommerce.model;

public class PPP {

    int id;
    int product_id;
    int platform_id;
    double price;

    public PPP(int id, int product_id, int platform_id, double price) {
        this.id = id;
        this.product_id = product_id;
        this.platform_id = platform_id;
        this.price = price;
    }

    public PPP(int product_id, int platform_id, double price) {
        this.product_id = product_id;
        this.platform_id = platform_id;
        this.price = price;
    }

    public PPP() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(int platform_id) {
        this.platform_id = platform_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ppp{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", platform_id=" + platform_id +
                ", price=" + price +
                '}';
    }
}
