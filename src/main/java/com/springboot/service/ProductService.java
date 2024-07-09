package com.springboot.service;

import com.springboot.entity.Product;
import com.springboot.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = "products")
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @CachePut(cacheNames = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        log.info("Making connection with database::ProductService.saveProduct()");
        return repository.save(product);
    }

    @Cacheable(cacheNames = "products")
    public List<Product> getProducts() {
        log.info("Making connection with database::ProductService.getProducts()");
        return repository.findAll();
    }


    @Cacheable(cacheNames = "products", key = "#id")
    public Product getProductById(int id) {
        log.info("Making connection with database::ProductService.getProductById()");
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

    @CachePut(cacheNames = "products", key = "#id")
    public Product updateProduct(int id, Product productRequest) {
        // get the product from DB by id
        // update with new value getting from request
        Product existingProduct = repository.findById(id).get(); // DB
        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setProductType(existingProduct.getProductType());

        log.info("Making connection with database::ProductService.updateProduct()");
        return repository.save(existingProduct);
    }


    @CacheEvict(cacheNames = "products", key = "#id")
    public long deleteProduct(int id) {
        log.info("Making connection with database::ProductService.deleteProduct()");
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


    //SORTING

    public List<Product> getProductsWithSorting(String fieldName) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, fieldName));
    }

    //PAGINATION

    public Page<Product> getProductsWithPageResponse(int offset, int limit) {
        // return repository.findAll(PageRequest.of(offset, limit)).getContent();
        return repository.findAll(PageRequest.of(offset, limit));
    }


    public Page<Product> getProductsWihSortingAndPagination(int offset, int limit, String fieldName) {
        return repository.findAll(
                PageRequest.of(offset, limit)
                        .withSort(Sort.by(fieldName)));
    }

}
