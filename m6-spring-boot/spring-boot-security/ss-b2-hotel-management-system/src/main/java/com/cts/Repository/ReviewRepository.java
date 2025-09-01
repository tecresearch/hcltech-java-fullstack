package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
