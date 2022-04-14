package com.swedbank.park.ui.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * This class holds ticket payment details
 */
@Getter
@Setter
public class PaymentInfo {
    private long id;
    private BigDecimal price;
    private Date date;

    private TicketInfo ticket;

    public PaymentInfo(){}

    public PaymentInfo(TicketInfo ticket, BigDecimal price, Date date) {
        this.ticket = ticket;
        this.price = price;
        this.date = date;
    }

    public PaymentInfo(long id, TicketInfo ticket, BigDecimal price, Date date) {
        this.id = id;
        this.ticket = ticket;
        this.price = price;
        this.date = date;
    }

}
