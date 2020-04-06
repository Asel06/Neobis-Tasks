package com.fruitshop.things;

import com.fruitshop.things.Products;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<Products, Integer> {

}