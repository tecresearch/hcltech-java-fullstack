//package com.cts.Controller;
//
//import com.cts.Service.ManagerService;
//import com.cts.dto.BookingDTO;
//import com.cts.dto.HotelDTO;
//import com.cts.dto.RoomDTO;
//import com.cts.security.UserPrincipal;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.context.SecurityContextHolder; 
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/manager")
//@PreAuthorize("hasRole('ROLE_MANAGER')")
//@RequiredArgsConstructor
//public class ManagerController {
//
//    private final ManagerService managerService; 
//
//    private Long getAuthenticatedManagerId() {
//        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return principal.getUserId();
//    }
//
//    @PostMapping("/rooms")
//    public ResponseEntity<RoomDTO> addRoom(@RequestBody RoomDTO roomDTO) {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.addRoom(managerId, roomDTO));
//    }
//
//    @PutMapping("/rooms/{roomId}")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO) {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.updateRoom(managerId, roomDTO));
//    }
//
//    @GetMapping("/rooms/{roomId}")
//    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long roomId) {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.getRoomById(managerId, roomId));
//    }
//
//    @GetMapping("/rooms/all") 
//    public ResponseEntity<List<RoomDTO>> getAllRoomsByManager() {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.getAllRoomsByManager(managerId));
//    }
//
//    @DeleteMapping("/rooms/{roomId}")
//    public ResponseEntity<String> deleteRoom(@PathVariable Long roomId) {
//        Long managerId = getAuthenticatedManagerId();
//        String successMessage = managerService.deleteRoomById(managerId, roomId);
//        return ResponseEntity.ok(successMessage);
//
//    }
//
//    @GetMapping("/bookings")
//    public ResponseEntity<List<BookingDTO>> getAllBookings() {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.getAllBookingsByManager(managerId));
//    }
//
//    @PutMapping("/bookings")
//    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO bookingDTO) {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.updateBooking(managerId, bookingDTO));
//    }
//
//    @PutMapping("/hotels")
//    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
//        Long managerId = getAuthenticatedManagerId();
//        return ResponseEntity.ok(managerService.updateHotel(managerId, hotelDTO));
//    }
//}

package com.cts.Controller;

import com.cts.Service.ManagerService;
import com.cts.dto.BookingDTO;
import com.cts.dto.HotelDTO;
import com.cts.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    // Room Operations
    @PostMapping("/{managerId}/rooms")
    public ResponseEntity<RoomDTO> addRoom(@PathVariable Long managerId, @RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(managerService.addRoom(managerId, roomDTO));
    }

    @PutMapping("/{managerId}/rooms")
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long managerId, @RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(managerService.updateRoom(managerId, roomDTO));
    }

    @GetMapping("/{managerId}/rooms/{roomId}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long managerId, @PathVariable Long roomId) {
        return ResponseEntity.ok(managerService.getRoomById(managerId, roomId));
    }

    @GetMapping("/{managerId}/rooms")
    public ResponseEntity<List<RoomDTO>> getAllRoomsByManager(@PathVariable Long managerId) {
        return ResponseEntity.ok(managerService.getAllRoomsByManager(managerId));
    }

    @DeleteMapping("/{managerId}/rooms/{roomId}")
    public ResponseEntity<String> deleteRoomById(@PathVariable Long managerId, @PathVariable Long roomId) {
        return ResponseEntity.ok(managerService.deleteRoomById(managerId, roomId));
    }

    // Booking Operations
    @GetMapping("/{managerId}/bookings") 
    public ResponseEntity<List<BookingDTO>> getAllBookingsByManager(@PathVariable Long managerId) {
        return ResponseEntity.ok(managerService.getAllBookingsByManager(managerId));
    }

    @PutMapping("/{managerId}/bookings")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long managerId, @RequestBody BookingDTO bookingDTO) {
        return ResponseEntity.ok(managerService.updateBooking(managerId, bookingDTO));
    }

    // Hotel Operations
    @PutMapping("/{managerId}/hotels")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable Long managerId, @RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(managerService.updateHotel(managerId, hotelDTO));
    }
}