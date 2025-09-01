package com.cts.Repository;

import com.cts.Entity.Hotel;
import com.cts.Entity.Room;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByHotelHotelId(Long hotelId);
	List<Room> findByHotelHotelIdAndType(Long hotelId, String type);
	boolean existsByRoomNumberAndHotelHotelId(String roomNumber, Long hotelId);
	boolean existsByRoomNumber(String roomNumber);
}