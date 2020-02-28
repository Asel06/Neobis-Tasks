package Entity;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping(path = "/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping
    public Products create(@RequestBody Products products) {
        return productsRepository.save(products);
    }



    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public @ResponseBody String addNewProduct (@RequestParam String nameOfFruit,
                                                @RequestParam int priceOfProduct) {
        Products product = new Products();
        product.setNameOfFruit(nameOfFruit);
        product.setPriceOfProduct(priceOfProduct);

        productsRepository.save(product);
        return "Saved :)";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
        return productsRepository.findById(id)
                .map(record -> {
                    productsRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Products> updateProduct(@PathVariable("id") long id,
                                                   @RequestBody Products product) {
        return productsRepository.findById(id)
                .map(record -> {
                    record.setNameOfFruit(product.getNameOfFruit());
                    record.setPriceOfProduct(product.getPriceOfProduct());

                    Products updated = productsRepository.save(product);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public @ResponseBody Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}

