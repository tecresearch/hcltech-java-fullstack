package com.cts.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
@EqualsAndHashCode(exclude = {"rooms", "reviews", "manager"})
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private MyUser manager;
    private Double cheapestPrice;
    private String amenities;
    private Double rating;
    private String description;
    
//    @Lob
//    @Column(name="image", columnDefinition = "LONGBLOB")
//    private byte[] image;
    private String image;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Room> rooms = new HashSet<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "hotel-reviews")
    private Set<Review> reviews = new HashSet<>();
}