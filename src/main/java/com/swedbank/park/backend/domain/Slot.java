package com.swedbank.park.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * THis domain represents individual parking slot and stores slot number and its availability status
 */

@Entity
@Table(name="slot")
public class Slot {

    @Id
    private Long slotNumber;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Column(name = "is_available")
    private boolean availability;


    public long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Long slotNumber) {
        this.slotNumber = slotNumber;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean hasAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
