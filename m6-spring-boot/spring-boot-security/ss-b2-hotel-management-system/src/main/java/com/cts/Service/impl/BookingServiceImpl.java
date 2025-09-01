package com.cts.Service.impl;

import com.cts.dto.BookingDTO;
import com.cts.Entity.Booking;
import com.cts.Entity.Room;
import com.cts.Entity.MyUser;
import com.cts.Entity.Payment;
import com.cts.Entity.Booking.Status;
import com.cts.Repository.BookingRepository;
import com.cts.Repository.RoomRepository;
import com.cts.Repository.UserRepository;
import com.cts.Repository.PaymentRepository;
import com.cts.Service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
// Import HotelRepository if you have one, or access hotel through room.getHotel().getName()
// import com.cts.Repository.HotelRepository; // uncomment if needed

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final PaymentRepository paymentRepository;
    // private final HotelRepository hotelRepository; // uncomment if you need to fetch Hotel explicitly

    private BookingDTO mapToDto(Booking booking) {
        // Retrieve hotel name from the room associated with the booking
        String hotelName = "Unknown Hotel"; // Default value
        if (booking.getRoom() != null && booking.getRoom().getHotel() != null) {
            hotelName = booking.getRoom().getHotel().getName();
        }

        return BookingDTO.builder()
                .id(booking.getBookingId())
                .userId(booking.getUser().getUserId())
                .roomId(booking.getRoom().getRoomId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .status(booking.getStatus())
                .paymentId(booking.getPayment() != null ? booking.getPayment().getPaymentId() : null)
                .hotelName(hotelName) // <--- POPULATE THIS FIELD
                .build();
    }

    private Booking mapToEntity(BookingDTO dto) {
        MyUser user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + dto.getRoomId()));
        Payment payment = dto.getPaymentId() != null ?
                paymentRepository.findById(dto.getPaymentId())
                        .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + dto.getPaymentId())) : null;
        return Booking.builder()
                .bookingId(dto.getId())
                .user(user)
                .room(room)
                .checkInDate(dto.getCheckInDate())
                .checkOutDate(dto.getCheckOutDate())
                .status(dto.getStatus())
                .payment(payment)
                .build();
    }

    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER')")
    public BookingDTO addBooking(BookingDTO bookingDTO) {
        log.info("Inside add Booking");
        if (bookingDTO.getPaymentId() == null) {
            throw new RuntimeException("Payment ID is required for booking");
        }
        Booking booking = bookingRepository.save(mapToEntity(bookingDTO));
        return mapToDto(booking);
    }

    @Override
    @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public BookingDTO getBookingById(Long id) {
        return mapToDto(bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id)));
    }

    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public List<BookingDTO> getBookingsByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findByUserUserId(userId);
        return bookings.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public BookingDTO updateBooking(BookingDTO dto) {
        Booking existing = bookingRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + dto.getId()));
        Booking updated = mapToEntity(dto);
        updated.setPayment(dto.getPaymentId() != null ?
                paymentRepository.findById(dto.getPaymentId())
                        .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + dto.getPaymentId())) :
                existing.getPayment());
        updated.setStatus(dto.getStatus() != null ? dto.getStatus() : existing.getStatus());
        return mapToDto(bookingRepository.save(updated));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public String cancelBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
        booking.setStatus(Status.CANCELLED);
        bookingRepository.save(booking);
        log.info("Booking canceled");
        System.out.println("Booking canceled"); // Fallback console log
        return "Booking canceled";
    }
}