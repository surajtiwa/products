package com.scaler.products.controllers;


import com.scaler.products.dtos.GetproductDto;
import com.scaler.products.exceptions.NotFoundException;
import com.scaler.products.models.Product;
import com.scaler.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public GetproductDto getProductId(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getproductById(id);
    }

    @GetMapping("")
    public List<GetproductDto> getProducts() {
        return productService.getAllProducts();
    }

    // @requestBody converts the recievd json to java object
    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return product;
    }

    @PostMapping("/thirdparty")
    public List<Product> saveDataFromThirdParty() {
        return productService.saveAllProduct();
    }
}
