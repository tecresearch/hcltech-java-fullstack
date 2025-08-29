package com.hackerrank.tradingplatform.repository;

import com.hackerrank.tradingplatform.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {
    Optional<Trader> findByEmail(String email);
}
