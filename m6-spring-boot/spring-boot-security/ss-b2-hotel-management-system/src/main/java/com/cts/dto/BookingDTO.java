package com.cts.dto;

import lombok.*;
import com.cts.Entity.Booking.Status;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long roomId;
    private Long paymentId; 
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Status status;
    private String hotelName;
}

