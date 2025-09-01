package com.cts.Controller;

import com.cts.Service.UserService;
import com.cts.Service.BookingService;
import com.cts.dto.UserDTO;
import com.cts.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_USER')")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserDTO userDto) {
        if (!id.equals(userDto.getUserId())) {
            throw new RuntimeException("User ID mismatch");
        }
        return userService.updateUser(userDto);
    }

    @GetMapping("/{id}/bookings")
    public ResponseEntity<List<BookingDTO>> getUserBookings(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(id));
    }
}