package com.hcl.service.impl;

import com.hcl.entity.dto.ProductDto;
import com.hcl.entity.Product;
import com.hcl.exception.ProductNotFoundException;
import com.hcl.repository.ProductRepository;
import com.hcl.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private  ProductRepository repository;
    @Autowired
    private ModelMapper modelMapper;
@Override
    public ProductDto productToDto(Product product) {
//            ProductDto productDto = new ProductDto();
//            productDto.setName(product.getName());
//            productDto.setPrice(product.getPrice());
    return modelMapper.map(product,ProductDto.class  );
    }
    @Override
    public Product dtoToProduct(ProductDto productDto) {
//        Product product=new Product();
//        product.setName(productDto.getName());
//        product.setPrice(productDto.getPrice());
        return modelMapper.map(productDto,Product.class);
    }

    @Override
    public void saveProduct(ProductDto productDto) {
           repository.save(dtoToProduct(productDto));
    }
    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product not found: "+id));
    }
    @Override
    public List<Product> getProducts(){
       return repository.findAll();
    }
    @Override
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    @Override
    public void updateProduct(Product toBeUpdateProduct) {
        Product oldProduct=getProduct(toBeUpdateProduct.getId());
        oldProduct.setId(toBeUpdateProduct.getId());
        oldProduct.setName(toBeUpdateProduct.getName());
        oldProduct.setPrice(toBeUpdateProduct.getPrice());
        repository.save(oldProduct);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return repository.findByName(name);
    }


}
