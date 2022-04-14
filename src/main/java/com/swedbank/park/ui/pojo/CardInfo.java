package com.swedbank.park.ui.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Contains all the payment information required to complete the payment transaction
 */

@Getter
@Setter
public class CardInfo {
    String cardNumber;
    String cvvCode;
    String expiryDate;

    public  CardInfo(){}

    public CardInfo(String cardNumber, String cvvCode, String expiry) {
        this.cardNumber = cardNumber;
        this.cvvCode = cvvCode;
        this.expiryDate = expiry;
    }

}
