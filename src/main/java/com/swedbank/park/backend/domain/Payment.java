package com.swedbank.park.backend.domain;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * This class holds ticket payment details
 */
public class Payment {
    private long id;
    private long ticketNumber;
    private BigDecimal price;
    private Date date;

    public Payment(long ticketNumber, BigDecimal price, Date date) {
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.date = date;
    }

    public Payment(long id, long ticketNumber, BigDecimal price, Date date) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
