package main.calm.eCommerce.model;

/**
 * pojo for Plaforms
 *
 */
public class Platform {

    int id;
    String name;
    String url;
    double sales_fee;

    public Platform(int id, String name, String url, double sales_fee) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.sales_fee = sales_fee;
    }

    public Platform(String name, String url, double sales_fee) {
        this.name = name;
        this.url = url;
        this.sales_fee = sales_fee;
    }

    public Platform() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getSales_fee() {
        return sales_fee;
    }

    public void setSales_fee(double sales_fee) {
        this.sales_fee = sales_fee;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sales_fee=" + sales_fee +
                '}';
    }

    public String getName() {
        return name;
    }
}
