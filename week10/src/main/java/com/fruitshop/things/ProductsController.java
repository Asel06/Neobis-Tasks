package com.fruitshop.things;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;


    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Products addNewProduct (@RequestParam (value = "name")  String name,
                                   @RequestParam  (value = "price") int price) {
        Products product = new Products();
        product.setName(name);
        product.setPrice(price);

        return productsRepository.save(product);
    }


    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        return productsRepository.findById(id)
                .map(record -> {
                    productsRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Products> updateProduct(@PathVariable("id") int id,
                                                  @RequestBody Products product) {
        return productsRepository.findById(id)
                .map(record -> {
                    record.setName(product.getName());
                    record.setPrice(product.getPrice());

                    Products updated = productsRepository.save(product);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}