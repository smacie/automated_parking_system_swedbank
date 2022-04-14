package com.swedbank.park.ui;

import com.swedbank.park.ParkingSystemApplicationUI;
import com.swedbank.park.ui.pojo.CardInfo;
import com.swedbank.park.ui.pojo.SlotInfo;
import com.swedbank.park.ui.pojo.TicketInfo;

import java.sql.Date;
import java.util.ArrayList;

/**
 * This application simulates the working of a automated parking system.
 * <p>
 * User parks the car in the slot alloted by the automated parking system. It generates a ticket with ticket number for the user.
 * Also, driver uses this system and the ticket printed to pay the fee for the duration the car was parked in the slot.
 * This application tracks the available slots and also informs the user if the parking lot is full.
 */
public class ParkingSystemApp {

    /**
     * Launch the application.
     */
    static ParkingSystemApplicationUI mainFrame;


    private ArrayList<SlotInfo> slots = null;
    ArrayList<TicketInfo> ticketList = null;
    SlotInfo slot = null;

    private long startTimeMilliseconds;
    private long startTime = 0;
    private long endTimeMilliseconds;
    private String durationParked;
    private Date date;

    private static final double fee = 0.5; // Parking fee $0.5 for 15 minutes
    private static final int minimumTime = 15;
    int timeInMinutes = 0;
    private double totalFee = 0;
    CardInfo payInfo = null;

    public ParkingSystemApp() {
        ParkingLot lot = new ParkingLot();
        slots = lot.getParkingSlots();

        ticketList = new ArrayList<>(); // to save tickets
    }

    /**
     * This method checks for available parking slot and generates a ticket if slot is available
     *
     * @return Ticket object reference if there is a slot available or null if no slots available
     */
    public TicketInfo park() {
        SlotInfo slot = checkAvailability(); // check for available slots

        if (slot != null) {
            startTimeMilliseconds = System.currentTimeMillis();

            TicketInfo ticket = new TicketInfo(slot, startTimeMilliseconds, date);
            ticketList.add(ticket); // save the ticket in ticketList

            slot.setAvailable(false); // this slot is no more available
            return ticket;
        }
        return null;
    }


    /**
     * This method checks for available slots in the parking lot
     *
     * @return slot if available or null if no slots are available
     */
    public SlotInfo checkAvailability() {
        for (int i = 0; i < slots.size(); i++) {
            slot = slots.get(i);

            // check availability
            if (slot.isAvailable() == true) {
                return slot;
            }
        }
        return null;
    }

    /**
     * This method saves the end time
     */
    public void captureEndTime() {
        // capture end time
        endTimeMilliseconds = System.currentTimeMillis();
    }

    /**
     * This method validates the ticket number entered by the user when exiting the parking lot
     *
     * @param ticketNumEntered entered by the user when exiting from the parking lot
     * @return true if valid slot number is entered else returns false
     */
    public boolean validateTicketNumber(int ticketNumEntered) {
        boolean isValid = false;

        for (int i = 0; i < ticketList.size(); i++) {
            long slotNumber = ticketList.get(i).getSlot().getSlotNumber();

            if (ticketNumEntered == slotNumber) {
                isValid = true;
                startTime = ticketList.get(i).getStartTime();
                break;
            }
        }
        return isValid;
    }

    /**
     * This method calculates the total time (in minutes) the car was parked in the parking lot
     */
    public void calculateTotalMinutes() {
        long durationMilliSeconds = endTimeMilliseconds - startTime; // total time the card was parked in the slot
        durationParked = convertTimeFormat(durationMilliSeconds);
        String[] time = durationParked.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        timeInMinutes = (hours * 60) + minutes + (seconds / 60);
    }

    /**
     * This method calculate the total fee due payment for the duration the car was parked in the parking lot
     *
     * @return total fee calculated
     */
    public double getTotalFee() {
        if (totalFee == 0) {
            if (timeInMinutes < 15)
                totalFee = 0.5;
            else
                totalFee = (timeInMinutes / minimumTime) * fee;
        }

        return totalFee;
    }

    /**
     * This method sets the slot to available once the user choses to exit the parking lot
     *
     * @param ticketNumber slot number where the car was parked
     */
    public void makeSlotAvailable(int ticketNumber) {
        for (int i = 0; i < slots.size(); i++) {
            long slotNumber = slots.get(i).getSlotNumber();

            if (ticketNumber == slotNumber) {
                slot = slots.get(i);
                slot.setAvailable(true);
            }
        }
    }

    /**
     * This method creates a payment information object and sets all the credit card details.
     *
     * @param ccNumber  users credit card number
     * @param cvvNumber ccv number of the credit card
     * @param expiry    credit card expiry date
     */
    public void setPaymentInformation(String ccNumber, String cvvNumber, String expiry) {
        payInfo = new CardInfo(ccNumber, cvvNumber, expiry);
    }

    /**
     * This method sends the payment information to the bank class
     *
     * @return true if validation is successful else false (For demo - Assumption is made that the validation is successful always.)
     */
    public boolean validateCreditCard() {
        Bank bank = new Bank(payInfo);
        return bank.validateCreditCard();
    }

    public String convertTimeFormat(long milliSeconds) {
        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = milliSeconds / 1000;
        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;
        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;
        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;
        // Obtain the total hours
        long totalHours = totalMinutes / 60;
        // Compute the current hour
        long currentHour = totalHours % 24;

        return currentHour + ":" + currentMinute + ":" + currentSecond;

    }

}
