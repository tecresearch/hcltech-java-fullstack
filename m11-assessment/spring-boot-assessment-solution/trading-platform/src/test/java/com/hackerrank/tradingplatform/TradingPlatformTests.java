package com.hackerrank.tradingplatform;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.tradingplatform.dto.AddMoneyTraderDTO;
import com.hackerrank.tradingplatform.dto.UpdateTraderDTO;
import com.hackerrank.tradingplatform.model.Trader;
import com.hackerrank.tradingplatform.repository.TraderRepository;
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class TradingPlatformTests {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    ObjectMapper om = new ObjectMapper();
    @Autowired
    TraderRepository traderRepository;
    @Autowired
    MockMvc mockMvc;

    Map<String, Trader> testData;

    @Before
    public void setup() {
        traderRepository.deleteAll();
        testData = getTestData();
    }

    @Test
    public void testRegisterTrader() throws Exception {
        for (Trader trader : testData.values()) {
            mockMvc.perform(post("/trading/traders/register")
                    .contentType("application/json")
                    .content(om.writeValueAsString(trader)))
                    .andDo(print())
                    .andExpect(status().isCreated());
        }

        Trader expectedRecord = testData.get("trader_1");
        Trader actualRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "id", "createdAt", "updatedAt").matches(actualRecord));

        expectedRecord = testData.get("trader_2");
        actualRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "id", "createdAt", "updatedAt").matches(actualRecord));

        //existing
        for (Trader trader : testData.values()) {
            mockMvc.perform(post("/trading/traders/register")
                    .contentType("application/json")
                    .content(om.writeValueAsString(trader)))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }

    @Test
    public void testUpdateTrader() throws Exception {
        //test update by email
        Trader expectedRecord = testData.get("trader_1");
        mockMvc.perform(post("/trading/traders/register")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(status().isCreated());
        expectedRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        UpdateTraderDTO expectedUpdateRecord = new UpdateTraderDTO(expectedRecord.getName() + " X", expectedRecord.getEmail());
        mockMvc.perform(put("/trading/traders")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedUpdateRecord)))
                .andDo(print())
                .andExpect(status().isOk());

        expectedRecord.setName(expectedUpdateRecord.getName());
        Trader actualRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "createdAt", "updatedAt").matches(actualRecord));
    }

    @Test
    public void testAddMoney() throws Exception {
        //test update by email
        Trader expectedRecord = testData.get("trader_2");
        mockMvc.perform(post("/trading/traders/register")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(status().isCreated());
        expectedRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        AddMoneyTraderDTO expectedUpdateRecord = new AddMoneyTraderDTO(expectedRecord.getEmail(), 10.0);
        mockMvc.perform(put("/trading/traders/add")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedUpdateRecord)))
                .andDo(print())
                .andExpect(status().isOk());

        expectedRecord.setBalance(expectedRecord.getBalance() + expectedUpdateRecord.getAmount());
        Trader actualRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();
        Assert.assertTrue(new ReflectionEquals(expectedRecord, "createdAt", "updatedAt").matches(actualRecord));
    }

    @Test
    public void testGetTradersByEmail() throws Exception {
        Trader expectedRecord = testData.get("trader_1");

        mockMvc.perform(post("/trading/traders/register")
                .contentType("application/json")
                .content(om.writeValueAsString(expectedRecord)))
                .andDo(print())
                .andExpect(status().isCreated());

        expectedRecord = traderRepository.findByEmail(expectedRecord.getEmail()).get();

        Trader actualRecord = om.readValue(mockMvc.perform(get("/trading/traders?email=" + expectedRecord.getEmail())
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(), Trader.class);

        Assert.assertTrue(new ReflectionEquals(expectedRecord, "createdAt", "updatedAt").matches(actualRecord));

        //non existing record test
        mockMvc.perform(get("/trading/traders?email=" + Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllTraders() throws Exception {
        Map<String, Long> expectedCreatedAt = new HashMap<>();
        Map<String, Long> expectedUpdatedAt = new HashMap<>();

        //post
        for (Trader trader : testData.values()) {
            expectedCreatedAt.put(trader.getEmail(), getEpochSecond(getCurrentTimestamp()));

            mockMvc.perform(post("/trading/traders/register")
                    .contentType("application/json")
                    .content(om.writeValueAsString(trader)))
                    .andDo(print())
                    .andExpect(status().isCreated());
        }

        //update
        for (Trader trader : testData.values()) {
            UpdateTraderDTO dto = new UpdateTraderDTO(trader.getName() + "X", trader.getEmail());
            expectedUpdatedAt.put(trader.getEmail(), getEpochSecond(getCurrentTimestamp()));

            mockMvc.perform(put("/trading/traders")
                    .contentType("application/json")
                    .content(om.writeValueAsString(dto)))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        List<Trader> expectedRecords = traderRepository.findAll();
        expectedRecords.sort(Comparator.comparing(Trader::getId));

        //get all
        List<Trader> actualRecords = om.readValue(mockMvc.perform(get("/trading/traders/all")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(), new TypeReference<List<Trader>>() {
        });

        for (int i = 0; i < expectedRecords.size(); i++) {
            Assert.assertTrue(new ReflectionEquals(expectedRecords.get(i), "createdAt", "updatedAt").matches(actualRecords.get(i)));

            Assert.assertTrue((getEpochSecond(stringOf(actualRecords.get(i).getCreatedAt())) - expectedCreatedAt.get(expectedRecords.get(i).getEmail())) < 1000);
            Assert.assertTrue((getEpochSecond(stringOf(actualRecords.get(i).getUpdatedAt())) - expectedUpdatedAt.get(expectedRecords.get(i).getEmail())) < 1000);
        }
    }

    private Long getEpochSecond(String timestamp) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            return ZonedDateTime.of(LocalDateTime.parse(timestamp, formatter), ZoneOffset.UTC).toEpochSecond();
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }

        return 0L;
    }

    private String getCurrentTimestamp() {
        return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern(dateFormat));
    }

    private String stringOf(Timestamp timestamp) {
        Date date = new Date();
        date.setTime(timestamp.getTime());
        return new SimpleDateFormat(dateFormat).format(date);
    }

    private Map<String, Trader> getTestData() {
        Map<String, Trader> data = new HashMap<>();

        Trader trader_1 = new Trader(
                "Elizabeth Small",
                "susanchandler.wchurch@buck.com",
                62.0);
        data.put("trader_1", trader_1);

        Trader trader_2 = new Trader(
                "Susan Adams",
                "adkinsjason.paul57@collins.com",
                251.49);
        data.put("trader_2", trader_2);

        return data;
    }
}