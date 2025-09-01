package com.cts.Service;

import com.cts.dto.PaymentDTO;
import java.util.List;

public interface PaymentService {
    PaymentDTO addPayment(PaymentDTO paymentDTO);
    List<PaymentDTO> getAllPayments();
    PaymentDTO getPaymentById(Long id);
    PaymentDTO updatePayment(PaymentDTO paymentDTO);
    void deletePaymentById(Long id);
}