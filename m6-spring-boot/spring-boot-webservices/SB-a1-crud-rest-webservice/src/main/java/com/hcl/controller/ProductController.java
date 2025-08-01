package com.hcl.controller;
import com.hcl.controller.dto.SavedProductResponse;
import com.hcl.entity.dto.ProductDto;
import com.hcl.entity.Product;
import com.hcl.exception.ProductNotFoundException;
import com.hcl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api/v2")
public class ProductController {
    @Autowired
    private  ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
        SavedProductResponse savedProductResponse=new SavedProductResponse();
        savedProductResponse.setHttpStatus("CREATED");
        savedProductResponse.setResponse(201);
        savedProductResponse.setMessage("Product added successfully");
        savedProductResponse.setProductDto(productDto);
        savedProductResponse.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductResponse);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product=productService.getProduct(id);
        if(product!=null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products=productService.getProducts();
        if(products!=null){
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        Product product=productService.getProduct(id);
        if(product!=null){
            productService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }else{
           throw new ProductNotFoundException("Product not found");
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct( @RequestBody Product toBeUpdateProduct){
        productService.updateProduct(toBeUpdateProduct);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/by-name:product-name")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam("product-name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByName(name));
    }

}
