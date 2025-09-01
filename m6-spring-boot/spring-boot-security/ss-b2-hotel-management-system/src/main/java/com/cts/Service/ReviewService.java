package com.cts.Service;

import com.cts.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {
    ReviewDTO addReview(ReviewDTO reviewDTO);
    List<ReviewDTO> getAllReview();
    ReviewDTO getReviewById(Long id);
    ReviewDTO updateReview(ReviewDTO reviewDTO);
    void deleteReviewById(Long id);
}