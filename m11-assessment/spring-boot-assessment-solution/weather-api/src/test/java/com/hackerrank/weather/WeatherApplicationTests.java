package com.hackerrank.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class WeatherApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WeatherRepository weatherRepository;

    @BeforeEach
    public void setup() {
        weatherRepository.deleteAll();
    }

    @Test
    public void shouldCreateRecord() throws Exception {
        Weather weather = new Weather(new Date(), "Nashville", "Tennessee", 36.1189f, -86.6892f, 37.3);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        weather.setDateRecorded(simpleDateFormat.parse("1985-01-01"));

        String requestJson = objectMapper.writeValueAsString(weather);
        MockHttpServletResponse response = mockMvc.perform(post("/weather")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(7)))
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(jsonPath("$.city").value(weather.getCity()))
                .andExpect(jsonPath("$.state").value(weather.getState()))
                .andExpect(jsonPath("$.lat").value(weather.getLat()))
                .andExpect(jsonPath("$.lon").value(weather.getLon()))
                .andExpect(jsonPath("$.temperature").value(weather.getTemperature()))
                .andExpect(status().isCreated()).andReturn().getResponse();

        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");
        assertEquals(true, weatherRepository.findById(id).isPresent());

    }

    @Test
    public void shouldGetAll() throws Exception {
        Weather weather = new Weather(new Date(), "Nashville", "Tennessee", 36.1189f, -86.6892f, 37.3);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        weather.setDateRecorded(simpleDateFormat.parse("1985-01-01"));

        String requestJson = objectMapper.writeValueAsString(weather);
        MockHttpServletResponse response = mockMvc.perform(post("/weather")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse();
        Integer firstId = JsonPath.parse(response.getContentAsString()).read("$.id");

        response = mockMvc.perform(post("/weather")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse();
        Integer secondId = JsonPath.parse(response.getContentAsString()).read("$.id");


        mockMvc.perform(get("/weather")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(firstId))
                .andExpect(jsonPath("$[1].id").value(secondId))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetById() throws Exception {
        Weather weather = new Weather(new Date(), "Nashville", "Tennessee", 36.1189f, -86.6892f, 37.3);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        weather.setDateRecorded(simpleDateFormat.parse("1985-01-01"));

        String requestJson = objectMapper.writeValueAsString(weather);
        MockHttpServletResponse response = mockMvc.perform(post("/weather")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse();
        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");

        mockMvc.perform(get("/weather/" + id))
                .andDo(print())
                .andExpect(jsonPath("$.*", hasSize(7)))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.city").value(weather.getCity()))
                .andExpect(jsonPath("$.state").value(weather.getState()))
                .andExpect(jsonPath("$.lat").value(weather.getLat()))
                .andExpect(jsonPath("$.lon").value(weather.getLon()))
                .andExpect(jsonPath("$.temperature").value(weather.getTemperature()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/weather/" + Integer.MAX_VALUE))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Weather weather = new Weather(new Date(), "Nashville", "Tennessee", 36.1189f, -86.6892f, 37.3);
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        weather.setDateRecorded(simpleDateFormat.parse("1985-01-01"));

        String requestJson = objectMapper.writeValueAsString(weather);
        MockHttpServletResponse response = mockMvc.perform(post("/weather")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse();
        Integer id = JsonPath.parse(response.getContentAsString()).read("$.id");

        mockMvc.perform(delete("/weather/" + id))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertEquals(false, weatherRepository.findById(id).isPresent());

        mockMvc.perform(delete("/weather" + Integer.MAX_VALUE))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
