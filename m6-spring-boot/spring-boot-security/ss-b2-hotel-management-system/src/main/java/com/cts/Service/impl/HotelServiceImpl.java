package com.cts.Service.impl;
 
import com.cts.Entity.Hotel;

import com.cts.Entity.MyUser;

import com.cts.Repository.HotelRepository;

import com.cts.Repository.UserRepository;

import com.cts.Service.HotelService;

import com.cts.Entity.Room;

import com.cts.dto.HotelDTO;

import com.cts.dto.RoomDTO;

import com.cts.dto.ReviewDTO;

import com.cts.dto.BookingDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Arrays;

import java.util.Base64;

import java.util.HashSet;

import java.util.Set;

import java.util.List;

import java.util.Optional;

import java.util.stream.Collectors;
 
@Service

@RequiredArgsConstructor

public class HotelServiceImpl implements HotelService {
 
    private final HotelRepository hotelRepository;

    private final UserRepository userRepository;
 
    private HotelDTO entityToDTO(Hotel hotel) {

    	Set<RoomDTO> roomDTOs = null;

        Double cheapestPrice = null;
 
        if (hotel.getRooms() != null && !hotel.getRooms().isEmpty()) {
 
        	Optional<Double> minPrice = hotel.getRooms().stream()

                    .map(Room::getPrice)

                    .filter(price -> price != null) 

                    .min(Double::compare);
 
            if (minPrice.isPresent()) {

                cheapestPrice = minPrice.get();

            }
 
            roomDTOs = hotel.getRooms().stream()

                    .map(room -> {

                        Set<BookingDTO> bookingDTOs = room.getBookings() != null ?

                                room.getBookings().stream()

                                        .map(booking -> BookingDTO.builder()

                                                .id(booking.getBookingId())

                                                .userId(booking.getUser().getUserId())

                                                .roomId(booking.getRoom().getRoomId())

                                                .checkInDate(booking.getCheckInDate())

                                                .checkOutDate(booking.getCheckOutDate())

                                                .status(booking.getStatus())

                                                .build())

                                        .collect(Collectors.toSet()) : null;

                            return RoomDTO.builder()

                                    .id(room.getRoomId())

                                    .roomNumber(room.getRoomNumber())

                                    .type(room.getType())

                                    .price(room.getPrice())

                                    .availability(room.getAvailability() != null ? room.getAvailability().name() : null)

                                    .features(room.getFeatures())

                                    .hotelId(room.getHotel().getHotelId())

                                    .bookings(bookingDTOs)

                                    .build();

                        })

                        .collect(Collectors.toSet());

        }

        Set<ReviewDTO> reviewDTOs = hotel.getReviews() != null ?

                hotel.getReviews().stream()

                        .map(review -> ReviewDTO.builder()

                                .id(review.getReviewId())

                                .userId(review.getUser().getUserId())

                                .hotelId(review.getHotel().getHotelId())

                                .comment(review.getComment())

                                .rating(review.getRating())

                                .timestamp(review.getTimestamp())

                                .build())

                        .collect(Collectors.toSet()) : null;
 
        return HotelDTO.builder()

                .id(hotel.getHotelId())

                .name(hotel.getName())

                .location(hotel.getLocation())

//                .amenities(hotel.getAmenities() != null && !hotel.getAmenities().isEmpty() ?
//
//                		new HashSet<>(Arrays.asList(hotel.getAmenities().split(","))) :
//
//                		new HashSet<>())
                .amenities(hotel.getAmenities())
                
                .rating(hotel.getRating())

                .description(hotel.getDescription())

                .managerId(hotel.getManager() != null ? hotel.getManager().getUserId() : null)

                .image(hotel.getImage())

                .rooms(roomDTOs)

                .reviews(reviewDTOs)

                .cheapestPrice(cheapestPrice)

                .build();

    }

    private Hotel dtoToEntity(HotelDTO dto) {

        MyUser manager = null;

        if (dto.getManagerId() != null) {

            manager = userRepository.findById(dto.getManagerId())

                    .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + dto.getManagerId()));

        }
 
        return Hotel.builder()

                .hotelId(dto.getId())

                .name(dto.getName())

                .location(dto.getLocation())

                .amenities(dto.getAmenities())

                .rating(dto.getRating())

                .description(dto.getDescription())

                .manager(manager)

                .image(dto.getImage())

                .build();

    }
 
//    @Override
//
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//
//    public HotelDTO addHotel(HotelDTO hotelDTO) {
//
//        Hotel hotel = dtoToEntity(hotelDTO);
//
//        return entityToDTO(hotelRepository.save(hotel));
//
//    }
    
    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HotelDTO addHotel(HotelDTO hotelDTO) {
        System.out.println("Received HotelDTO for addHotel: " + hotelDTO);
        Hotel hotel = dtoToEntity(hotelDTO);
        System.out.println("Converted Hotel entity before saving: " + hotel);
        Hotel savedHotel = hotelRepository.save(hotel);
        System.out.println("Saved Hotel entity: " + savedHotel);
        return entityToDTO(savedHotel);
    }
 
    @Override

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN')")

    @Transactional(readOnly = true)

    public List<HotelDTO> getAllHotels() {

        List<Hotel> hotels = hotelRepository.findAll();

        return hotels.stream()

                .map(this::entityToDTO)

                .collect(Collectors.toList());

    }
 
    @Override

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN')")

    @Transactional(readOnly = true)

    public HotelDTO getHotelById(Long id) {

        Hotel hotel = hotelRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + id));

        return entityToDTO(hotel);

    }
 
    @Override

    @PreAuthorize("hasRole('ROLE_MANAGER')")

    public HotelDTO updateHotel(HotelDTO hotelDTO) {

        Hotel existingHotel = hotelRepository.findById(hotelDTO.getId())

                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + hotelDTO.getId()));

        existingHotel.setName(hotelDTO.getName());

        existingHotel.setLocation(hotelDTO.getLocation());

        existingHotel.setAmenities(hotelDTO.getAmenities() != null && !hotelDTO.getAmenities().isEmpty() ? hotelDTO.getAmenities() : null);

        existingHotel.setRating(hotelDTO.getRating());

        existingHotel.setDescription(hotelDTO.getDescription());

        if (hotelDTO.getManagerId() != null) {

            MyUser manager = userRepository.findById(hotelDTO.getManagerId())

                    .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + hotelDTO.getManagerId()));

            existingHotel.setManager(manager);

        }

        existingHotel.setImage(hotelDTO.getImage());

        return entityToDTO(hotelRepository.save(existingHotel));

    }
 
    @Override

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public void deleteHotelById(Long id) {

        if (!hotelRepository.existsById(id)) {

            throw new RuntimeException("Hotel not found with ID: " + id);

        }

        hotelRepository.deleteById(id);

    }

    @Override

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MANAGER', 'ROLE_ADMIN')")

    @Transactional(readOnly = true)

    public List<HotelDTO> getHotelsByLocation(String location) {

        List<Hotel> hotels = hotelRepository.findByLocation(location);
 
        return hotels.stream()

                .map(this::entityToDTO)

                .collect(Collectors.toList());

    }
    
    @Override
    public List<HotelDTO> findHotelsByLocation(String location) {

        return hotelRepository.findByLocationContainingIgnoreCase(location).stream()
                .map(this::convertToDto) 
                .collect(Collectors.toList());
    }
    
    @Override
    public List<HotelDTO> findAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private HotelDTO convertToDto(Hotel hotel) {
        if (hotel == null) return null;
        HotelDTO dto = new HotelDTO();
        dto.setId(hotel.getHotelId());
        dto.setName(hotel.getName());
        dto.setLocation(hotel.getLocation());
        dto.setDescription(hotel.getDescription());

        dto.setAmenities(hotel.getAmenities());
        dto.setRating(hotel.getRating());
        if (hotel.getManager() != null) {
            dto.setManagerId(hotel.getManager().getUserId());
        }
        
        dto.setImage(hotel.getImage()); 
        
        dto.setCheapestPrice(hotel.getCheapestPrice());

        // Option 2: If cheapestPrice needs to be calculated from associated rooms
        // You'd need to fetch rooms for this hotel and find the minimum price.
        // This would require injecting RoomRepository or a RoomService here.
        /*
        if (hotel.getRooms() != null && !hotel.getRooms().isEmpty()) {
            Double minPrice = hotel.getRooms().stream()
                                  .mapToDouble(Room::getPrice) // Assuming Room entity has getPrice()
                                  .min()
                                  .orElse(0.0); // Default if no rooms or price is 0
            dto.setCheapestPrice(minPrice);
        } else {
            dto.setCheapestPrice(0.0); // Or handle as null, based on your logic
        }
        */

        return dto;
    }

}
 