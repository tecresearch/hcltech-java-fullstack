package com.cts.Service.impl;

import com.cts.security.UserPrincipal;
import com.cts.Entity.Review;
import com.cts.Entity.MyUser;

import com.cts.Entity.Hotel;
import com.cts.Repository.ReviewRepository;
import com.cts.Repository.UserRepository;
import com.cts.Repository.HotelRepository;
import com.cts.Service.ReviewService;
import com.cts.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    // DTO to Entity
    private Review dtoToEntity(ReviewDTO dto) {
        MyUser user = userRepository.findById(dto.getUserId())

                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + dto.getHotelId()));
        return Review.builder()
                .reviewId(dto.getId())
                .user(user)
                .hotel(hotel)
                .rating(dto.getRating())
                .comment(dto.getComment())
                .timestamp(LocalDateTime.now())
                .build();
    }

    // Entity to DTO
    private ReviewDTO entityToDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getReviewId())
                .userId(review.getUser().getUserId())
                .hotelId(review.getHotel().getHotelId())
                .comment(review.getComment())
                .rating(review.getRating())
                .timestamp(LocalDateTime.now())
                .build();
    }

    // Add Review
    @Override
    @PreAuthorize("hasRole('USER')")
    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        Review review = dtoToEntity(reviewDTO);
        return entityToDTO(reviewRepository.save(review));
    }

    // Get All Reviews
    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public List<ReviewDTO> getAllReview() {
        return reviewRepository.findAll().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    // Get Review by ID
    @Override
    @PreAuthorize("hasAnyRole('USER', 'MANAGER', 'ADMIN')")
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        return entityToDTO(review);
    }

    // Update Review
    @Override
    @PreAuthorize("hasRole('USER')")
    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        Review existingReview = reviewRepository.findById(reviewDTO.getId())
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + reviewDTO.getId()));
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!existingReview.getUser().getUserId().equals(principal.getUserId())) {
            throw new RuntimeException("You can only update your own reviews");
        }
        existingReview.setRating(reviewDTO.getRating());
        existingReview.setComment(reviewDTO.getComment());
        existingReview.setTimestamp(LocalDateTime.now());
        return entityToDTO(reviewRepository.save(existingReview));
    }

    // Delete Review by ID
    @Override
    @PreAuthorize("hasRole('USER')")
    public void deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!review.getUser().getUserId().equals(principal.getUserId())) {
            throw new RuntimeException("You can only delete your own reviews");
        }
        reviewRepository.deleteById(id);
    }
}