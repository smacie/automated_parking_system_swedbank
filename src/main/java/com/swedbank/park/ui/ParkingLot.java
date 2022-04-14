package com.swedbank.park.ui;

import com.swedbank.park.ui.pojo.SlotInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Count of parking slots list of all parking slots
 */
public class ParkingLot {
    private static final int numberOfSlots = 5;

    private ArrayList<SlotInfo> listOfSlots = null;

    public ParkingLot() {
        listOfSlots = new ArrayList<>();
    }

    /**
     * This method returns list of all the parking slots
     *
     * @return list of the slots in the parking lot
     */
    public ArrayList<SlotInfo> getParkingSlots() {
        for (int i = 1; i <= numberOfSlots; i++) {
            SlotInfo slot = new SlotInfo(i, 0, 0, true);
            listOfSlots.add(slot);
        }
        return listOfSlots;
    }

}
