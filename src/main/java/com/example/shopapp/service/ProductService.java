package com.example.shopapp.service;

import com.example.shopapp.dao.ProductRepository;
import com.example.shopapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public List<Product> getReferenceById(Long id) {
        return productRepository.findById(id).stream().collect(Collectors.toList());
    }

}
