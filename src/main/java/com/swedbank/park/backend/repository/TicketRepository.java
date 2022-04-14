package com.swedbank.park.backend.repository;

import com.swedbank.park.backend.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select * from Ticket as t where t.id =?1", nativeQuery = true)
    Ticket findTicketByTicketId(Long ticketId);

    @Query(value = "select * from Ticket as t where t.slot_number =?1", nativeQuery = true)
    List<Ticket> findTicketsBySlotNumber(Long slotNumber);
}
