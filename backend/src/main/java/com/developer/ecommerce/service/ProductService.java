package com.developer.ecommerce.service;

import com.developer.ecommerce.model.Product;
import com.developer.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public Product addProduct(Product product, MultipartFile imagefile) throws IOException {
        product.setImageName(imagefile.getOriginalFilename());
        product.setImageType(imagefile.getContentType());
        product.setImageData(imagefile.getBytes());
        return productRepo.save(product);
    }

    public Product update(int id, Product product, MultipartFile imagefile) throws IOException {
        product.setImageData(imagefile.getBytes());
        product.setImageName(imagefile.getOriginalFilename());
        product.setImageType(imagefile.getContentType());
        return productRepo.save(product);
    }

    public void delete(int id) {
        productRepo.deleteById(id);
    }
}
