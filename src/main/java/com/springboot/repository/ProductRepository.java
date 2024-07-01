package com.springboot.repository;

import com.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product> findByPriceAndProductType(double price, String productType);

    @Query(value = "SELECT * FROM PRODUCT_TABLE WHERE price = ?1", nativeQuery = true) //This is native query:
    //@Query("from Product p where p.price = ?1")//This is JPQL, and position based param
    // @Query("from PRODUCT_TABLE p where p.price = :price") //This is also JPQL, but named parameter base index
    List<Product> getProductByPrice(double price);

}
