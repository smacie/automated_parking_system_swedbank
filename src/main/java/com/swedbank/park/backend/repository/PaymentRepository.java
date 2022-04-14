package com.swedbank.park.backend.repository;

import com.swedbank.park.backend.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query(value = "select * from Payment as p where p.id =?1", nativeQuery = true)
    Payment findPaymentById(Long id);

    @Query(value = "select * from Payment as p where p.ticket_id =?1", nativeQuery = true)
    Payment findPaymentByTicketId(Long ticketId);
}
