package com.hcl.test.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.test.model.Item;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final List<Item> items = new ArrayList<>();
    
    
    
   

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
    	  items.add(new Item("Item 1"));
    	    items.add(new Item("Item 2"));
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return items.stream()  
                    .filter(item -> item.getId().equals(id))  
                    .findFirst()  
                    .map(ResponseEntity::ok)  
                    .orElse(ResponseEntity.notFound().build());  
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item newItem) {
        Optional<Item> existingItem = items.stream()
            .filter(item -> item.getId().equals(id))
            .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setName(newItem.getName());
            return ResponseEntity.ok(existingItem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        items.removeIf(item -> item.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}