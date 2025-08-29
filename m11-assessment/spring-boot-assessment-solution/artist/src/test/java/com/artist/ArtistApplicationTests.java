package com.artist;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;
import com.artist.repository.ArtistRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class ArtistApplicationTests {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private MockMvc mockMvc;
    private static final ObjectMapper om = new ObjectMapper();

    @BeforeEach
    public  void setup() {
        artistRepository.deleteAll();
    }

    private ArtistRequest createSamplePlayListRequest() {
        return new ArtistRequest(
                "Henry",
                "Kaldera"
        );
    }

    @Test
    void testCreatePlayList() throws Exception {
        ArtistRequest sampleArtistRequest = createSamplePlayListRequest();
        Artist actualRecord = om.readValue(mockMvc.perform(post("/v1/artists")
                        .contentType("application/json")
                        .content(om.writeValueAsString(sampleArtistRequest)))
                .andDo(print())
                .andExpect(jsonPath("$.id", greaterThan(0)))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Artist.class);
        assertTrue(artistRepository.findById(actualRecord.getId()).isPresent());
    }

    @Test
    void testListOfTracks() throws Exception {
        ArtistRequest sampleArtistRequest = createSamplePlayListRequest();

        for (int i = 0; i < 5; i++) {
            om.readValue(mockMvc.perform(post("/v1/artists")
                            .contentType("application/json")
                            .content(om.writeValueAsString(sampleArtistRequest)))
                    .andDo(print())
                    .andExpect(jsonPath("$.id", greaterThan(0)))
                    .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Artist.class);
        }

        List<Artist> actualResult = om.readValue(mockMvc.perform(get("/v1/artists"))
                .andDo(print())
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), new TypeReference<List<Artist>>() {
        });

        assertEquals(5, actualResult.size());
    }

    @Test
    void testListOfTracksEmpty() throws Exception {
        mockMvc.perform(get("/v1/artists"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    void testPlayListDeleteById() throws Exception {
        ArtistRequest sampleArtistRequest = createSamplePlayListRequest();
        Artist expectedRecord = om.readValue(mockMvc.perform(post("/v1/artists")
                        .contentType("application/json")
                        .content(om.writeValueAsString(sampleArtistRequest)))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Artist.class);

        mockMvc.perform(delete("/v1/artists/" + expectedRecord.getId())
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertFalse(artistRepository.findById(expectedRecord.getId()).isPresent());
    }

    @Test
    void testGetPlayListById() throws Exception {
        ArtistRequest sampleArtistRequest = createSamplePlayListRequest();
        Artist actualRecord = om.readValue(mockMvc.perform(post("/v1/artists")
                        .contentType("application/json")
                        .content(om.writeValueAsString(sampleArtistRequest)))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString(), Artist.class);

        Artist expectedRecord = om.readValue(mockMvc.perform(get("/v1/artists/" + actualRecord.getId())
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), Artist.class);

        assertTrack(actualRecord, expectedRecord);
    }

    @Test
    void testGetPlayListByID_NotFound() throws Exception {
        long nonExistentId = 999L;
        mockMvc.perform(get("/v1/artists/" + nonExistentId)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    private void assertTrack(Artist actualRecord, Artist expectedRecord) {
        Assertions.assertTrue(new ReflectionEquals(actualRecord).matches(expectedRecord));
    }
}
