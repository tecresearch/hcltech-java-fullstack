package com.hcl.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.test.model.Item;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
  
  
    
    @Test
    public void testGetAllItems() throws Exception {
        mockMvc.perform(get("/api/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))) // Expect the size of items
                .andExpect(jsonPath("$[0].name", is("Item 1")))
                .andExpect(jsonPath("$[1].name", is("Item 2")));  // Verify content
    }

    @Test
    public void testCreateItem() throws Exception {
        String itemJson = "{ \"name\": \"Item 3\" }";
        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(".name", is("Item 3")));  // Check created content
    }

    @Test
    public void testGetItemById() throws Exception {
        // Assuming Item 1 has an ID of 1
        mockMvc.perform(get("/api/items/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath(".name", is("Item 1")));  // Match content
    }

    @Test
    public void testUpdateItem() throws Exception {
    	
        // Update existing item with ID 1
        String updatedJson = "{ \"name\": \"Updated Item 1\" }";
        mockMvc.perform(put("/api/items/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath(".name", is("Updated Item 1")));  // Verify updated content
    }

    @Test
    public void testDeleteItem() throws Exception {
        // Delete item with ID 1
        mockMvc.perform(delete("/api/items/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());  // Expect no content response

        // Verify it was deleted
        mockMvc.perform(get("/api/items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))  // Check new size
                .andExpect(jsonPath("$[0].name", is("Item 2")));  // Verify remaining item
    }

   
}