package com.springboot.service;

import com.springboot.entity.Product;
import com.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).get();
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> getProductsByType(String productType) {
        return repository.findByProductType(productType);
    }

    public List<Product> getProductWithPriceAndType(double price, String productType) {
        return repository.findByPriceAndProductType(price, productType);
    }

    public List<Product> getProductsByPrice(double price) {
       return repository.getProductByPrice(price);
    }

    public Product updateProduct(int id, Product productRequest) {
        // get the product from DB by id
        // update with new value getting from request
        Product existingProduct = repository.findById(id).get(); // DB
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setProductType(existingProduct.getProductType());
        return repository.save(existingProduct);
    }

    public long deleteProduct(int id) {
        repository.deleteById(id);
        return repository.count();
    }


    //OPERATORS
    public List<Product> getProductsByMultiplePriceValue(List<Double> prices) {
        return repository.findByPriceIn(prices);
    }

    public List<Product> getProductsWithinPriceRange(double minPrice, double maxPrice) {
        return repository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductsWithHigherPrice(double price) {
        return repository.findByPriceGreaterThan(price);
    }

    public List<Product> getProductsWithLessPrice(double price) {
        return repository.findByPriceLessThan(price);
    }

    public List<Product> getProductsWithLike(String name) {
        return repository.findByNameContaining(name);
    }

}
