package com.Products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ApplicationTest.class)
public class ProductsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }


    @Test
    public void addNewProduct() {
        Products product = new Products();
        product.setName("Orange");
        product.setPrice(121);
        ResponseEntity<Products> postResponse = restTemplate.postForEntity(getRootUrl() + "/products/addProduct", product, Products.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void updateProduct(){
        Products product = restTemplate.getForObject(getRootUrl() + "/products/updateProduct/{id}", Products.class);
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        restTemplate.put(getRootUrl() + "/product/updateProduct/{id}", product);
        Products updateProduct = restTemplate.getForObject(getRootUrl() + "/product/updateProduct/{id}", Products.class);
        assertNotNull(updateProduct);
    }
    @Test
    public void deleteProduct(){
        Products product = restTemplate.getForObject(getRootUrl() + "/product/deleteProduct/{id}", Products.class);
        assertNotNull(product);
        restTemplate.delete(getRootUrl() + "/product/deleteProduct/{id}");
        try {
            product = restTemplate.getForObject(getRootUrl() + "/product/deleteCpu/deleteProduct/{id}", Products.class);
        } catch (final HttpClientErrorException exception){
            assertEquals(exception.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
    @Test
    public void getAllProducts() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() +"/products/allProducts",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}