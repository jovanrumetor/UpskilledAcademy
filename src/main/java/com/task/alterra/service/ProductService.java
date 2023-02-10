package com.task.alterra.service;

import com.task.alterra.entity.ProductEntity;
import com.task.alterra.entity.ResponseMessage;
import com.task.alterra.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ProductService {
    @Autowired(required = false)
    ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productRepository.findById(productEntity.getId()).get();
    }

    public ResponseMessage deleteProduct(Integer productId){
        productRepository.deleteById(productId);
        return new ResponseMessage("Product Deleted");
    }

}
