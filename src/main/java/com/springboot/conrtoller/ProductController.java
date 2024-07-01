package com.springboot.conrtoller;

import com.springboot.entity.Product;
import com.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/type/{productType}")
    public List<Product> getProductsByType(@PathVariable String productType) {
        return productService.getProductsByType(productType);
    }

    @GetMapping("/price/{price}/type/{productType}")
    public List<Product> getProductWithPriceAndType(@PathVariable double price, @PathVariable String productType) {
        return productService.getProductWithPriceAndType(price, productType);
    }

    @GetMapping("/search/{price}")
    public List<Product> getProductByPrice(@PathVariable double price) {
        return productService.getProductsByPrice(price);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}