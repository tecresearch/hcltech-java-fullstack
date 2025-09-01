package com.cts.Service.impl;
 
import com.cts.Entity.Booking;

import com.cts.Entity.Hotel;

import com.cts.Entity.Room;

import com.cts.Repository.BookingRepository;

import com.cts.Repository.HotelRepository;

import com.cts.Repository.RoomRepository;

import com.cts.Service.ManagerService;

import com.cts.dto.BookingDTO;

import com.cts.dto.HotelDTO;

import com.cts.dto.ReviewDTO;

import com.cts.dto.RoomDTO;

import com.cts.security.UserPrincipal;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.AccessDeniedException;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;

import java.util.Optional;

import java.util.Set;

import java.util.stream.Collectors;

import java.util.Arrays;

import java.util.Base64;
 
@Service

@RequiredArgsConstructor

@Slf4j

public class ManagerServiceImpl implements ManagerService {
 
    private final RoomRepository roomRepository;

    private final BookingRepository bookingRepository;

    private final HotelRepository hotelRepository;
 
    private Long getAuthenticatedManagerId() {

        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return principal.getUserId();

    }
 
    private void verifyRoomBelongsToManagerHotel(Long managerId, Long roomId) {
 
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId);

        if (managedHotels.isEmpty()) {

            throw new RuntimeException("No hotel found for manager ID: " + managerId);

        }

        Hotel managedHotel = managedHotels.get(0); // Assuming one manager per hotel
 
        Room room = roomRepository.findById(roomId)

                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));
 
        if (!room.getHotel().getHotelId().equals(managedHotel.getHotelId())) {

            throw new AccessDeniedException("Room with ID " + roomId + " does not belong to your managed hotel.");

        }

    }
 
    private void verifyBookingBelongsToManagerHotelRooms(Long managerId, Long bookingId) {
 
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId);

        if (managedHotels.isEmpty()) {

            throw new RuntimeException("No hotel found for manager ID: " + managerId);

        }

        Hotel managedHotel = managedHotels.get(0); // Assuming one manager per hotel
 
        Booking booking = bookingRepository.findById(bookingId)

                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingId));
 
        if (!booking.getRoom().getHotel().getHotelId().equals(managedHotel.getHotelId())) {

            throw new AccessDeniedException("Booking with ID " + bookingId + " is not for a room in your managed hotel.");

        }

    }
 
    // DTO to Entity and Entity to DTO
 
    private Room dtoToEntity(RoomDTO dto) {

        Hotel hotel = hotelRepository.findById(dto.getHotelId())

                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + dto.getHotelId()));

        return Room.builder()

                .roomId(dto.getId())

                .roomNumber(dto.getRoomNumber())

                .type(dto.getType())

                .price(dto.getPrice())

                .availability(dto.getAvailability() != null ? Room.Availability.valueOf(dto.getAvailability()) : null)

                .features(dto.getFeatures())

                .hotel(hotel)

                .build();

    }
 
    private RoomDTO entityToDTO(Room room) {

        return RoomDTO.builder()

                .id(room.getRoomId())

                .roomNumber(room.getRoomNumber())

                .type(room.getType())

                .price(room.getPrice())

                .availability(room.getAvailability() != null ? room.getAvailability().name() : null)

                .features(room.getFeatures())

                .hotelId(room.getHotel().getHotelId())

                .bookings(room.getBookings() != null ? room.getBookings().stream()

                        .map(booking -> BookingDTO.builder()

                                .id(booking.getBookingId())

                                .userId(booking.getUser().getUserId())

                                .roomId(booking.getRoom().getRoomId())

                                .checkInDate(booking.getCheckInDate())

                                .checkOutDate(booking.getCheckOutDate())

                                .status(booking.getStatus())

                                .build())

                        .collect(Collectors.toSet()) : null)

                .build();

    }
 
    private BookingDTO mapToDto(Booking booking) {

        return BookingDTO.builder()

                .id(booking.getBookingId())

                .userId(booking.getUser().getUserId())

                .roomId(booking.getRoom().getRoomId())

                .checkInDate(booking.getCheckInDate())

                .checkOutDate(booking.getCheckOutDate())

                .status(booking.getStatus())

                .paymentId(booking.getPayment() != null ? booking.getPayment().getPaymentId() : null)

                .build();

    }
 
    private Booking mapToEntity(BookingDTO dto) {
 
        Room room = roomRepository.findById(dto.getRoomId())

                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + dto.getRoomId()));
 
        return Booking.builder()

                .bookingId(dto.getId())
 
                .room(room)

                .checkInDate(dto.getCheckInDate())

                .checkOutDate(dto.getCheckOutDate())

                .status(dto.getStatus())

                .build();

    }
 
    private HotelDTO hotelEntityToDTO(Hotel hotel) {

        Set<RoomDTO> roomDTOs = hotel.getRooms() != null ?

                hotel.getRooms().stream()

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

                        .collect(Collectors.toSet()) : null;

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
 
        String amenitiesString = hotel.getAmenities();

        return HotelDTO.builder()

                .id(hotel.getHotelId())

                .name(hotel.getName())

                .location(hotel.getLocation())

                .amenities(amenitiesString) 

                .rating(hotel.getRating())

                .description(hotel.getDescription())

                .managerId(hotel.getManager() != null ? hotel.getManager().getUserId() : null)

                .image(hotel.getImage())

                .rooms(roomDTOs)

                .reviews(reviewDTOs)

                .build();

    }
 
    private Hotel hotelDtoToEntity(HotelDTO dto) {
 
        return Hotel.builder()

                .hotelId(dto.getId())

                .name(dto.getName())

                .location(dto.getLocation())

                .amenities(dto.getAmenities() != null ? String.join(", ", dto.getAmenities()) : null) // Corrected: join Set<String> to String

                .rating(dto.getRating())

                .description(dto.getDescription())

                .image(dto.getImage())

                .build();

    }

    // Room Operations

    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public RoomDTO addRoom(Long managerId, RoomDTO roomDTO) {
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId);
        if (managedHotels.isEmpty()) {
            throw new RuntimeException("No hotel found for manager ID: " + managerId);
        }
        Hotel managedHotel = managedHotels.get(0); // Assuming one manager per hotel
 
        if (!managedHotel.getHotelId().equals(roomDTO.getHotelId())) {
            throw new AccessDeniedException("You can only add rooms to your managed hotel.");
        }
 
        if (roomRepository.existsByRoomNumber(roomDTO.getRoomNumber())) {
            throw new RuntimeException("Room number already exists: " + roomDTO.getRoomNumber());
        }
        Room room = dtoToEntity(roomDTO);
        return entityToDTO(roomRepository.save(room));
    }
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public RoomDTO updateRoom(Long managerId, RoomDTO roomDTO) {
        verifyRoomBelongsToManagerHotel(managerId, roomDTO.getId());
 
        Room existingRoom = roomRepository.findById(roomDTO.getId())
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomDTO.getId()));
 
        if (!existingRoom.getRoomNumber().equals(roomDTO.getRoomNumber()) &&
                roomRepository.existsByRoomNumber(roomDTO.getRoomNumber())) {
            throw new RuntimeException("Room number already exists: " + roomDTO.getRoomNumber());
        }
        existingRoom.setRoomNumber(roomDTO.getRoomNumber());
        existingRoom.setType(roomDTO.getType());
        existingRoom.setPrice(roomDTO.getPrice());
        existingRoom.setAvailability(roomDTO.getAvailability() != null ? Room.Availability.valueOf(roomDTO.getAvailability()) : null);
        existingRoom.setFeatures(roomDTO.getFeatures());
 
        return entityToDTO(roomRepository.save(existingRoom));
    }
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public RoomDTO getRoomById(Long managerId, Long roomId) {
        verifyRoomBelongsToManagerHotel(managerId, roomId);
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));
        return entityToDTO(room);
    }
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @Transactional(readOnly = true)
    public List<RoomDTO> getAllRoomsByManager(Long managerId) {
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId); // Changed here
        if (managedHotels.isEmpty()) {
            throw new RuntimeException("No hotel found for manager ID: " + managerId);
        }
        Hotel managedHotel = managedHotels.get(0); // Assuming one manager per hotel
 
        return managedHotel.getRooms().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
 
//    @Override
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    public void deleteRoomById(Long managerId, Long roomId) {
//        verifyRoomBelongsToManagerHotel(managerId, roomId);
//        roomRepository.deleteById(roomId);
//    }
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String deleteRoomById(Long managerId, Long roomId) {
        Room roomToDelete = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));
        String roomNumber = roomToDelete.getRoomNumber();
        Long hotelId = null;
        if (roomToDelete.getHotel() != null) {
            hotelId = roomToDelete.getHotel().getHotelId();
        }
        verifyRoomBelongsToManagerHotel(managerId, roomId);
        roomRepository.deleteById(roomId);
        return "Room number " + roomNumber + " deleted in hotel " + hotelId;
    }
 
    //Booking Operations
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @Transactional(readOnly = true)
    public List<BookingDTO> getAllBookingsByManager(Long managerId) {
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId); // Changed here
        if (managedHotels.isEmpty()) {
            throw new RuntimeException("No hotel found for manager ID: " + managerId);
        }
        Hotel managedHotel = managedHotels.get(0); // Assuming one manager per hotel

        Set<Room> managedRooms = managedHotel.getRooms();

        List<Booking> allBookings = bookingRepository.findAll();
        return allBookings.stream()
                .filter(booking -> managedRooms.contains(booking.getRoom()))
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public BookingDTO updateBooking(Long managerId, BookingDTO bookingDTO) {
        verifyBookingBelongsToManagerHotelRooms(managerId, bookingDTO.getId());
 
        Booking existing = bookingRepository.findById(bookingDTO.getId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + bookingDTO.getId()));
 
        if (bookingDTO.getStatus() != null) {
            existing.setStatus(bookingDTO.getStatus());
        }
 
        return mapToDto(bookingRepository.save(existing));
    }
 
    //Hotel Operations
 
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public HotelDTO updateHotel(Long managerId, HotelDTO hotelDTO) {
        List<Hotel> managedHotels = hotelRepository.findAllByManagerUserId(managerId); // Changed here
        if (managedHotels.isEmpty()) {
            throw new RuntimeException("No hotel found for manager ID: " + managerId);
        }
        Hotel existingHotel = managedHotels.get(0); // Assuming one manager per hotel
 
 
        if (!existingHotel.getHotelId().equals(hotelDTO.getId())) {
            throw new AccessDeniedException("You can only update your managed hotel.");
        }
 
        existingHotel.setName(hotelDTO.getName());
        existingHotel.setLocation(hotelDTO.getLocation());
        existingHotel.setAmenities(hotelDTO.getAmenities() != null ? String.join(", ", hotelDTO.getAmenities()) : null);
        existingHotel.setRating(hotelDTO.getRating());
        existingHotel.setDescription(hotelDTO.getDescription());
 
        existingHotel.setImage(hotelDTO.getImage());
 
        return hotelEntityToDTO(hotelRepository.save(existingHotel));
    }
}
 