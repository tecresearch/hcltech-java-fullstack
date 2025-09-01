package com.cts.dto;

import com.cts.Entity.Payment.PaymentMethod;
import com.cts.Entity.Payment.PaymentStatus;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long userId;
    private Double amount;
    private PaymentStatus status;
    private PaymentMethod paymentMethod;
}
