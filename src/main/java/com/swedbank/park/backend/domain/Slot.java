package com.swedbank.park.backend.domain;

/**
 * Represents individual parking slot and stores slot number and its availability status
 */
public class Slot {
    private long slotNumber;
    private double width;
    private double height;
    private boolean available;

    public Slot(long slotNumber, double width, double height, boolean available) {
        this.slotNumber = slotNumber;
        this.width = width;
        this.height = height;
        this.available = available;
    }

    public long getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(long slotNumber) {
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
