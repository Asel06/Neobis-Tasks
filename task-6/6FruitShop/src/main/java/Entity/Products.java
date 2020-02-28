package Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;


@Data
@Entity
@Table (name = "products", schema = "fruitshop")
class Products {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NameOfFruit", nullable = false)
    private String nameOfFruit;

    @Column(name = "PriceOfProduct", nullable = false)
    private int priceOfProduct;
Products() {}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfFruit() {
        return nameOfFruit;
    }

    public void setNameOfFruit(String nameOfFruit) {
        this.nameOfFruit = nameOfFruit;
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(int priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }
}