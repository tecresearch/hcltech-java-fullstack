// com.cts.Service.impl.RoomServiceImpl

package com.cts.Service.impl;
 
import com.cts.Entity.Hotel;

import com.cts.Entity.Room;
import com.cts.dto.*;

import com.cts.Repository.HotelRepository;

import com.cts.Repository.RoomRepository;

import com.cts.Service.RoomService;

import com.cts.dto.BookingDTO;

import com.cts.dto.RoomDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Service;
 
import java.util.List;

import java.util.stream.Collectors;
 
@Service

@RequiredArgsConstructor

public class RoomServiceImpl implements RoomService {
 
    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;
 
    private Room dtoToEntity(RoomDTO dto) {

        Hotel hotel = hotelRepository.findById(dto.getHotelId())

                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + dto.getHotelId()));
 
        Room.RoomBuilder builder = Room.builder()

                .roomId(dto.getId())

                .roomNumber(dto.getRoomNumber())

                .type(dto.getType())

                .price(dto.getPrice())

                .features(dto.getFeatures())

                .hotel(hotel);
 
        if (dto.getAvailability() != null) {

            try {

                builder.availability(Room.Availability.valueOf(dto.getAvailability().toUpperCase()));

            } catch (IllegalArgumentException e) {

                throw new RuntimeException("Invalid availability value: " + dto.getAvailability());

            }

        } else {

            builder.availability(Room.Availability.UNAVAILABLE);

        }
 
        return builder.build();

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

                                .paymentId(booking.getPayment() != null ? booking.getPayment().getPaymentId() : null)

                                .build())

                        .collect(Collectors.toSet()) : null)

                .build();

    }
 
    @Override

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")

    public RoomDTO addRoom(RoomDTO roomDTO) {

        if (roomDTO.getRoomNumber() == null || roomDTO.getRoomNumber().isEmpty()) {

            throw new RuntimeException("Room number cannot be null or empty");

        }

        if (roomRepository.existsByRoomNumberAndHotelHotelId(roomDTO.getRoomNumber(), roomDTO.getHotelId())) {

            throw new RuntimeException("Room number already exists for hotel ID: " + roomDTO.getHotelId());

        }

        Room room = dtoToEntity(roomDTO);

        return entityToDTO(roomRepository.save(room));

    }
 
    @Override

    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")

    public List<RoomDTO> getAllRooms() {

        return roomRepository.findAll().stream()

                .map(this::entityToDTO)

                .collect(Collectors.toList());

    }
 
    @Override

    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")

    public RoomDTO getRoomById(Long id) {

        Room room = roomRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + id));

        return entityToDTO(room);

    }
 
    @Override

    @PreAuthorize("hasRole('MANAGER')")

    public RoomDTO updateRoom(RoomDTO roomDTO) {

        Room existingRoom = roomRepository.findById(roomDTO.getId())

                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomDTO.getId()));
 
        if (roomDTO.getRoomNumber() == null || roomDTO.getRoomNumber().isEmpty()) {

            throw new RuntimeException("Room number cannot be null or empty");

        }

        if (!existingRoom.getRoomNumber().equals(roomDTO.getRoomNumber()) &&

                roomRepository.existsByRoomNumberAndHotelHotelId(roomDTO.getRoomNumber(), roomDTO.getHotelId())) {

            throw new RuntimeException("Room number already exists for hotel ID: " + roomDTO.getHotelId());

        }
 
        existingRoom.setRoomNumber(roomDTO.getRoomNumber());

        existingRoom.setType(roomDTO.getType());

        existingRoom.setPrice(roomDTO.getPrice());

        existingRoom.setFeatures(roomDTO.getFeatures());

        existingRoom.setHotel(hotelRepository.findById(roomDTO.getHotelId())

                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + roomDTO.getHotelId())));
 
        if (roomDTO.getAvailability() != null) {

            try {

                existingRoom.setAvailability(Room.Availability.valueOf(roomDTO.getAvailability().toUpperCase()));

            } catch (IllegalArgumentException e) {

                throw new RuntimeException("Invalid availability value: " + roomDTO.getAvailability());

            }

        } else {

            existingRoom.setAvailability(Room.Availability.UNAVAILABLE);

        }
 
        return entityToDTO(roomRepository.save(existingRoom));

    }
 
    @Override

    @PreAuthorize("hasRole('ADMIN')")

    public void deleteRoomById(Long id) {

        if (!roomRepository.existsById(id)) {

            throw new RuntimeException("Room not found with ID: " + id);

        }

        roomRepository.deleteById(id);

    }
 
    @Override

    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")

    public List<RoomDTO> getRoomsByHotelId(Long hotelId) {

        return roomRepository.findByHotelHotelId(hotelId).stream()

                .map(this::entityToDTO)

                .collect(Collectors.toList());

    }
 
    public List<RoomDTO> getRoomsByHotelIdAndRoomType(Long hotelId, String roomType) {

        return roomRepository.findByHotelHotelIdAndType(hotelId, roomType.toUpperCase()).stream()

                .map(this::entityToDTO)

                .collect(Collectors.toList());

    }

}
 