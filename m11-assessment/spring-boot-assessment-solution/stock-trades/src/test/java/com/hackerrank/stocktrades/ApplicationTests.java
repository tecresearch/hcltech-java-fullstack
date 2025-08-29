package com.hackerrank.stocktrades;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.stocktrades.model.StockTrade;
import com.hackerrank.stocktrades.repository.StockTradeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ApplicationTests {
    ObjectMapper om = new ObjectMapper();
    @Autowired
    StockTradeRepository stockTradeRepository;
    @Autowired
    MockMvc mockMvc;

    Map<String, StockTrade> testData;

    @Before
    public void setup() {
        stockTradeRepository.deleteAll();
        testData = getTestData();
    }

    @Test
    public void testTradeCreationWithValidData() throws Exception {
        StockTrade expectedRecord = testData.get("user23ABX");
        StockTrade actualRecord = om.readValue(mockMvc.perform(post("/trades")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), StockTrade.class);

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "id").matches(actualRecord));
        assertEquals(true, stockTradeRepository.findById(actualRecord.getId()).isPresent());

        expectedRecord = testData.get("user23AAC");
        actualRecord = om.readValue(mockMvc.perform(post("/trades")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), StockTrade.class);

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "id").matches(actualRecord));
        assertEquals(true, stockTradeRepository.findById(actualRecord.getId()).isPresent());

    }

    @Test
    public void testGetAllTrades() throws Exception {
        Map<String, StockTrade> testData = getTestData().entrySet().stream().filter(kv -> "user23ABX,user23AAC".contains(kv.getKey())).collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()));

        List<StockTrade> expectedRecords = new ArrayList<>();
        for (Map.Entry<String, StockTrade> kv : testData.entrySet()) {
            expectedRecords.add(om.readValue(mockMvc.perform(post("/trades")
                    .contentType("application/json")
                    .content(om.writeValueAsString(kv.getValue())))
                    .andDo(print())
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), StockTrade.class));
        }
        Collections.sort(expectedRecords, Comparator.comparing(StockTrade::getId));

        List<StockTrade> actualRecords = om.readValue(mockMvc.perform(get("/trades"))
                .andDo(print())
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(expectedRecords.size())))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), new TypeReference<List<StockTrade>>() {
        });

        for (int i = 0; i < expectedRecords.size(); i++) {
            Assert.assertTrue(new ReflectionEquals(expectedRecords.get(i)).matches(actualRecords.get(i)));
        }
    }

    @Test
    public void testGetTradeRecordWithId() throws Exception {
        StockTrade expectedRecord = getTestData().get("user23ABX");

        expectedRecord = om.readValue(mockMvc.perform(post("/trades")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), StockTrade.class);

        StockTrade actualRecord = om.readValue(mockMvc.perform(get("/trades/" + expectedRecord.getId()))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(), StockTrade.class);

        Assert.assertTrue(new ReflectionEquals(expectedRecord).matches(actualRecord));

        //non existing record test
        mockMvc.perform(get("/trades/" + Integer.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testNotAllowedMethod() throws Exception {
        StockTrade expectedRecord = getTestData().get("user23ABX");

        StockTrade actualRecord = om.readValue(mockMvc.perform(post("/trades")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), StockTrade.class);

        mockMvc.perform(put("/trades/" + actualRecord.getId()))
                .andExpect(status().isMethodNotAllowed());

        mockMvc.perform(patch("/trades/" + actualRecord.getId()))
                .andExpect(status().isMethodNotAllowed());

        mockMvc.perform(delete("/trades/" + actualRecord.getId()))
                .andExpect(status().isMethodNotAllowed());
    }

    private Map<String, StockTrade> getTestData() {
        Map<String, StockTrade> data = new HashMap<>();

        StockTrade user23ABX = new StockTrade(
                "buy",
                23,
                "ABX",
                30,
                134,
                1591522701000l);
        data.put("user23ABX", user23ABX);

        StockTrade user23AAC = new StockTrade(
                "buy",
                23,
                "AAC",
                12,
                133,
                1591572701000l);
        data.put("user23AAC", user23AAC);

        StockTrade user24AAC = new StockTrade(
                "buy",
                24,
                "AAC",
                12,
                133,
                1591572791000l);
        data.put("user24AAC", user24AAC);

        StockTrade user25AAC = new StockTrade(
                "buy",
                25,
                "AAC",
                12,
                111,
                1571572791000l);
        data.put("user25AAC", user25AAC);


        return data;
    }
}
