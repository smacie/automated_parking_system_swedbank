package com.swedbank.park.backend.domain;

import java.sql.Date;

/**
 * This class holds the ticket details generated by the system and displayed to the user
 */
public class Ticket {
    private long ticketId;
    private long slotNumber;
    private long startTime;
    private long endTime;
    private Date date;

    public Ticket(long slotNumber, long startTime, Date date) {
        this.slotNumber = slotNumber;
        this.startTime = startTime;
        this.date = date;
    }
    public Ticket(long ticketId, long slotNumber, long startTime, Date date) {
        this.ticketId = ticketId;
        this.slotNumber = slotNumber;
        this.startTime = startTime;
        this.date = date;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getSlotNumber() {
        return slotNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }
}
