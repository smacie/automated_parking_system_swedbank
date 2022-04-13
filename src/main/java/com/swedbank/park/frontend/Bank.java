package com.swedbank.park.frontend;

/**
 * Card validation, assuming always successfully paid
 */
public class Bank {
    String cardNumber;
    String cvvCode;
    String expiryDate;

    public Bank(CardInfo cardInfo) {
        this.cardNumber = cardInfo.getCardNumber();
        this.cvvCode = cardInfo.getCvvCode();
        this.expiryDate = cardInfo.getExpiryDate();
    }

    // Simulation and assuming card validation is always successfully done.
    public boolean validateCreditCard() {
        return true;
    }
}
