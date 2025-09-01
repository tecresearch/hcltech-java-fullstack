package com.cts.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    private Long id;
    private String roomNumber;
    private String type;
    private Double price;
//    private String roomType;
    private String availability;
    private String features;
    private Long hotelId;
    private Set<BookingDTO> bookings = new HashSet<>();
}