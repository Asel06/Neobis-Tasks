package Entity;

public class ProductsNotFoundException extends RuntimeException {

    ProductsNotFoundException(Long id) {
        super("Could not find product " + id);
    }
}