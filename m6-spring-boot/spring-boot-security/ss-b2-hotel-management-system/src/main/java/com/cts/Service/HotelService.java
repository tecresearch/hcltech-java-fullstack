package com.cts.Service;

import com.cts.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    HotelDTO addHotel(HotelDTO hotelDTO); 

    List<HotelDTO> getAllHotels();

    HotelDTO getHotelById(Long id);

    HotelDTO updateHotel(HotelDTO hotelDTO);

    void deleteHotelById(Long id);
    
    List<HotelDTO> getHotelsByLocation(String location);
    
    List<HotelDTO> findHotelsByLocation(String location); 
    List<HotelDTO> findAllHotels();
}