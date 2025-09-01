package com.cts.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private Long id;
    private Long userId;
    private Long hotelId;
    private String comment;
    private Integer rating;
    private LocalDateTime timestamp;
}