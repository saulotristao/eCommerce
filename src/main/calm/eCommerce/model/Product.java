package main.calm.eCommerce.model;

public class Product {

    int id;
    String p_name;
    String p_description;

    public Product(int id, String p_name, String p_description) {
        this.id = id;
        this.p_name = p_name;
        this.p_description = p_description;
    }

    public Product() {
    }

    public Product(String p_name, String p_description) {
        this.p_name = p_name;
        this.p_description = p_description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_description() {
        return p_description;
    }

    public void setP_description(String p_description) {
        this.p_description = p_description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", p_name='" + p_name + '\'' +
                ", p_description='" + p_description + '\'' +
                '}';
    }
}
