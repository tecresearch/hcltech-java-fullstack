// com.cts.dto.HotelDTO
package com.cts.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {
    private Long id;
    private String name;
    private String location;
    private String amenities;
    private Double rating;
    private String description;
    private Long managerId;
    private String image;
    private Double cheapestPrice;
    @Builder.Default
    private Set<RoomDTO> rooms = new HashSet<>();
    @Builder.Default
    private Set<ReviewDTO> reviews = new HashSet<>();
}