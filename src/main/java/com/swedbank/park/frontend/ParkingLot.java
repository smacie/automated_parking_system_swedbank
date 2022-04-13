package com.swedbank.park.frontend;

import com.swedbank.park.backend.domain.Slot;

import java.util.ArrayList;

/**
 * Count of parking slots list of all parking slots
 */
public class ParkingLot {
    private static final int numberOfSlots = 5;

    private ArrayList<Slot> listOfSlots = null;

    public ParkingLot() {
        listOfSlots = new ArrayList<>();
    }

    /**
     * This method returns list of all the parking slots
     *
     * @return list of the slots in the parking lot
     */
    public ArrayList<Slot> getParkingSlots() {
        for (int i = 1; i <= numberOfSlots; i++) {
            Slot slot = new Slot(i, 0, 0, true);
            listOfSlots.add(slot);
        }
        return listOfSlots;
    }

}
