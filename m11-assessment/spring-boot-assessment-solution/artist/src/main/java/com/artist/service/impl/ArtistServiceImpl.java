package com.artist.service.impl;

import com.artist.dto.ArtistRequest;
import com.artist.model.Artist;
import com.artist.repository.ArtistRepository;
import com.artist.service.ArtistService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(ArtistRequest artistRequest) {
        return null;
    }

    @Override
    public List<Artist> getArtists() {
        return null;
    }

    @Override
    public Artist getArtistByID(Long id) {
        return null;
    }

    @Override
    public void deleteArtist(Long id) {
    }
}
