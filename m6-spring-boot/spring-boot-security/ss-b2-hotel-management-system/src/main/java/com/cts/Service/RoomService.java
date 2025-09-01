package com.cts.Service;

import com.cts.dto.RoomDTO;
import java.util.List;

public interface RoomService {
	RoomDTO addRoom(RoomDTO roomDTO);
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(Long id);
    RoomDTO updateRoom(RoomDTO roomDTO);
    void deleteRoomById(Long id);
    List<RoomDTO> getRoomsByHotelId(Long hotelId);
    List<RoomDTO> getRoomsByHotelIdAndRoomType(Long hotelId, String roomType);
}