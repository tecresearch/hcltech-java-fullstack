package com.cts.Repository;

import com.cts.Entity.Hotel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @EntityGraph(attributePaths = {"rooms", "reviews", "manager"})
    List<Hotel> findAll();

    @EntityGraph(attributePaths = {"rooms", "reviews", "manager"})
    Optional<Hotel> findById(Long id);
    
    @EntityGraph(attributePaths = {"rooms", "reviews", "manager"})
    List<Hotel> findByLocation(String location);
    
    @EntityGraph(attributePaths = {"rooms", "reviews", "manager"})
    List<Hotel> findAllByManagerUserId(Long managerId);
    
    List<Hotel> findByLocationIgnoreCase(String location);
    
    List<Hotel> findByLocationContainingIgnoreCase(String location);


}