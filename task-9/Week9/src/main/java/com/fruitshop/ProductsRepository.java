package com.fruitshop;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<Products, Integer> {

}
