package com.swedbank.park.ui.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents individual parking slot and stores slot number and its availability status
 */

@Getter
@Setter
public class SlotInfo {
    private long slotNumber;
    private double width;
    private double height;
    private boolean available;

    public SlotInfo(){}

    public SlotInfo(long slotNumber, double width, double height, boolean available) {
        this.slotNumber = slotNumber;
        this.width = width;
        this.height = height;
        this.available = available;
    }

}
