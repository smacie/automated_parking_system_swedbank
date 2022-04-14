package com.swedbank.park.util;

import com.swedbank.park.backend.domain.Payment;
import com.swedbank.park.backend.domain.Slot;
import com.swedbank.park.backend.domain.Ticket;
import com.swedbank.park.ui.pojo.PaymentInfo;
import com.swedbank.park.ui.pojo.SlotInfo;
import com.swedbank.park.ui.pojo.TicketInfo;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static <T> T toInfo(Object object, Class<T> tClass){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, tClass);
    }

    public static SlotInfo toSlotInfo(Slot slot){
        return toInfo(slot, SlotInfo.class);
    }
    public static List<SlotInfo> toSlotInfo(List<Slot> slotList){
        return slotList.stream().map(slot -> toInfo(slot, SlotInfo.class)).collect(Collectors.toList());
    }

    public static PaymentInfo toPaymentInfo(Payment payment){
        return toInfo(payment, PaymentInfo.class);
    }
    public static List<PaymentInfo> toPaymentInfo(List<PaymentInfo> paymentLst){
        return paymentLst.stream().map(payment -> toInfo(payment, PaymentInfo.class)).collect(Collectors.toList());
    }

    public static TicketInfo toTicketInfo(Ticket ticket){
        return toInfo(ticket, TicketInfo.class);
    }
    public static List<TicketInfo> toTicketInfo(List<Ticket> ticketList){
        return ticketList.stream().map(ticket -> toInfo(ticket, TicketInfo.class)).collect(Collectors.toList());
    }
}
