package com.cts.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
@EqualsAndHashCode(exclude = {"hotel", "bookings"})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false)
    private String type;
    
    private String roomNumber;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private String features;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    //ALTER TABLE rooms MODIFY COLUMN availability VARCHAR(20) NOT NULL;
    public enum Availability {
        AVAILABLE, BOOKED, UNAVAILABLE
    }
}