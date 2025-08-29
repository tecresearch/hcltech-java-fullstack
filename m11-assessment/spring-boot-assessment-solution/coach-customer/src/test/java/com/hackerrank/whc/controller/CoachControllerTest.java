package com.hackerrank.whc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.whc.model.Coach;
import com.hackerrank.whc.repository.CoachRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CoachControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CoachRepository coachRepository;

    private Coach coach1;
    private Coach coach2;

    @BeforeEach
    public void setup() {
        coach1 = new Coach(1, "Coach 1", null);
        coach2 = new Coach(2, "Coach 2", null);
    }

    @Test
    public void testAddRecord() throws Exception {
        when(coachRepository.save(any(Coach.class))).thenReturn(coach1);

        mockMvc.perform(post("/api/coach")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(coach1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(coach1.getId()))
                .andExpect(jsonPath("$.name").value(coach1.getName()));
    }

    @Test
    public void testGetRecords() throws Exception {
        when(coachRepository.findAll(any(Sort.class))).thenReturn(Arrays.asList(coach1, coach2));

        mockMvc.perform(get("/api/coach")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(coach1.getId()))
                .andExpect(jsonPath("$[0].name").value(coach1.getName()))
                .andExpect(jsonPath("$[1].id").value(coach2.getId()))
                .andExpect(jsonPath("$[1].name").value(coach2.getName()));
    }

    @Test
    public void testGetRecordsById() throws Exception {
        when(coachRepository.findById(coach1.getId())).thenReturn(Optional.of(coach1));

        mockMvc.perform(get("/api/coach/{id}", coach1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(coach1.getId()))
                .andExpect(jsonPath("$.name").value(coach1.getName()));
    }
}
