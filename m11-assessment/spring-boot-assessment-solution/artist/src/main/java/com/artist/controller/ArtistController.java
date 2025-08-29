package com.artist.controller;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;
import com.artist.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping()
    public ResponseEntity<Artist> createPlayList(@RequestBody ArtistRequest artistRequest){
        return null;
    }

    @GetMapping("/{artistId}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long artistId){
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(){
        return null;
    }

    @DeleteMapping("/{artistId}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long artistId){
        return null;
    }
}
