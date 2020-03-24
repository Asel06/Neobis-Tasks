package com.Products;

import com.fruitshop.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Applicationn.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ProductsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;;

    @Test
    public void testAddNewProduct() {
        Products product = new Products();
        product.setName("Orange");
        product.setPrice(121);
        ResponseEntity<Products> postResponse = restTemplate.postForEntity( "/products/addProduct", product, Products.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void updateProduct(){
        Products product = restTemplate.getForObject("/products/updateProduct/{id}", Products.class);
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        restTemplate.put( "/product/updateProduct/{id}", product);
        Products updateProduct = restTemplate.getForObject("/product/updateProduct/{id}", Products.class);
        assertNotNull(updateProduct);
    }
    @Test
    public void deleteProduct(){
        Products product = restTemplate.getForObject("/product/deleteProduct/{id}", Products.class);
        assertNotNull(product);
        restTemplate.delete("/product/deleteProduct/{id}");
        try {
            product = restTemplate.getForObject("/product/deleteCpu/deleteProduct/{id}", Products.class);
        } catch (final HttpClientErrorException exception){
            assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
    @Test
    public void getAllProducts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8888/products/allProducts" ,
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}