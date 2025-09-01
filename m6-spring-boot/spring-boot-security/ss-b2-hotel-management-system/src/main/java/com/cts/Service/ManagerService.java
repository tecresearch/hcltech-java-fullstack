package com.cts.Service;

import com.cts.dto.BookingDTO;
import com.cts.dto.HotelDTO;
import com.cts.dto.RoomDTO;

import java.util.List;

public interface ManagerService {
	
	//Room OPerations
	RoomDTO addRoom(Long managerId, RoomDTO roomDTO);
    RoomDTO updateRoom(Long managerId, RoomDTO roomDTO);
    RoomDTO getRoomById(Long managerId, Long roomId);
    List<RoomDTO> getAllRoomsByManager(Long managerId);
    String deleteRoomById(Long managerId, Long roomId);

    //BOoking Operation
    List<BookingDTO> getAllBookingsByManager(Long managerId);
    BookingDTO updateBooking(Long managerId, BookingDTO bookingDTO);
    
    //Hotel Operation
    HotelDTO updateHotel(Long managerId, HotelDTO hotelDTO);
}