package com.hcl.service;

import com.hcl.entity.dto.ProductDto;
import com.hcl.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public ProductDto productToDto(Product product);
    public Product dtoToProduct(ProductDto productDto);
    public void saveProduct(ProductDto productDto);
    public Product getProduct(Long id);
    public List<Product> getProducts();
    public void  deleteProduct(Long id);
    public void updateProduct(Product toBeUpdateProduct);
    public List<Product> getProductsByName(String name);
}
