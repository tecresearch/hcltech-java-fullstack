package com.cts.Service.impl;

import com.cts.Entity.Payment;
import com.cts.Entity.MyUser;
import com.cts.Repository.PaymentRepository;
import com.cts.Repository.UserRepository;
import com.cts.Service.PaymentService;
import com.cts.dto.PaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    private Payment dtoToEntity(PaymentDTO dto) {
        MyUser user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + dto.getUserId()));
        return Payment.builder()
                .paymentId(dto.getId())
                .user(user)
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .paymentMethod(dto.getPaymentMethod())
                .build();
    }

    private PaymentDTO entityToDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getPaymentId())
                .userId(payment.getUser().getUserId())
                .amount(payment.getAmount())
                .status(payment.getStatus())
                .paymentMethod(payment.getPaymentMethod())
                .build();
    }

    @Override
    public PaymentDTO addPayment(PaymentDTO paymentDTO) {
        Payment payment = dtoToEntity(paymentDTO);
        return entityToDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
        return entityToDTO(payment);
    }

    @Override
    public PaymentDTO updatePayment(PaymentDTO paymentDTO) {
        Payment existingPayment = paymentRepository.findById(paymentDTO.getId())
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentDTO.getId()));
        existingPayment.setUser(userRepository.findById(paymentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + paymentDTO.getUserId())));
        existingPayment.setAmount(paymentDTO.getAmount());
        existingPayment.setStatus(paymentDTO.getStatus());
        existingPayment.setPaymentMethod(paymentDTO.getPaymentMethod());
        return entityToDTO(paymentRepository.save(existingPayment));
    }

    @Override
    public void deletePaymentById(Long id) {
        paymentRepository.deleteById(id);
    }
}