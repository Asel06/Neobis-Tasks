package Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody String addNewProduct (@RequestParam (value = "name")  String NameOfFruit,
                                               @RequestParam  (value = "price") int PriceOfProduct) {
        Products product = new Products();
        product.setName(NameOfFruit);
        product.setPrice(PriceOfProduct);

        productsRepository.save(product);
        return "Done";
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
    public @ResponseBody Iterable<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}
