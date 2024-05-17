package com.scaler.products.services;

import com.scaler.products.dtos.GetproductDto;
import com.scaler.products.exceptions.NotFoundException;
import com.scaler.products.models.Product;
import com.scaler.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public GetproductDto getproductById(Long id) throws NotFoundException {
//      calling the third party api
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);
//      converting it to dto object
        if(product==null){
            throw new NotFoundException(id);
        }
        return convertToDto(product);
    }

    public List<GetproductDto> getAllProducts() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/";
        Product[] productArray = restTemplate.getForObject(url, Product[].class);

       // List<Product> productList = restTemplate.getForObject(url, List.class);

        List<GetproductDto> getproductDtoList = Arrays.stream(productArray).
                toList().stream().collect(Collectors.toList())
                .stream().map(e -> convertToDto(e)
                ).collect(Collectors.toList());
        return getproductDtoList;
    }

    GetproductDto convertToDto(Product product) {
        GetproductDto getproductDto = new GetproductDto();
        getproductDto.setName(product.getTitle());
        getproductDto.setPrice(product.getPrice());
        getproductDto.setImageUrl(product.getImage());
        return getproductDto;
    }

    public List<Product> saveAllProduct() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/";
        Product[] productArray = restTemplate.getForObject(url, Product[].class);
        List<Product> products=Arrays.stream(productArray).
                toList().stream().collect(Collectors.toList());
        productRepository.saveAll(products);

        return products;
    }
}
