package com.cts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
