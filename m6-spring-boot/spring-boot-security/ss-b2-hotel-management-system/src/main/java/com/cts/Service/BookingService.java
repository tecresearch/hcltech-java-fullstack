package com.cts.Service;

import com.cts.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    BookingDTO addBooking(BookingDTO bookingDTO);
    List<BookingDTO> getAllBookings();
    BookingDTO getBookingById(Long id);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    void deleteBookingById(Long id);
    List<BookingDTO> getBookingsByUserId(Long userId);
    String cancelBookingById(Long id);
}