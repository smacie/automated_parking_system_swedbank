package com.swedbank.park.backend.repository;

import com.swedbank.park.backend.domain.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query(value = "select * from Slot as s where s.slot_number =?1", nativeQuery = true)
    Slot findSlotBySlotNumber(Long slotNumber);

    @Query(value = "select * from Slot as s where s.is_available =?1", nativeQuery = true)
    List<Slot> findSlotsByAvailability(boolean isAvailable);

    @Transactional
    @Modifying
    @Query(value = "" +
            "INSERT INTO Slot(slot_number, width, height, is_available) values " +
            "(1L,2.5,2.0,true), " +
            "(2L,2.5,2.0,true), " +
            "(3L,8.0,3.0,true), " +
            "(4L,2.5,2.0,true)," +
            "(5L,2.5,2.0,true)" +
            "",
            nativeQuery = true)
    void insertDummySlots();
}
