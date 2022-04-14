package com.swedbank.park;

import com.swedbank.park.backend.repository.PaymentRepository;
import com.swedbank.park.backend.repository.SlotRepository;
import com.swedbank.park.backend.repository.TicketRepository;
import com.swedbank.park.ui.ParkingSystemApp;
import com.swedbank.park.ui.SlotFrame;
import com.swedbank.park.ui.pojo.SlotInfo;
import com.swedbank.park.ui.pojo.TicketInfo;
import com.swedbank.park.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * This is the User Interface which allows user to Park and Pay for the parking slot
 */
@SpringBootApplication
public class ParkingSystemApplicationUI extends JFrame {

    @Autowired
    SlotRepository slotRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    PaymentRepository paymentRepository;

    private JPanel contentPane;
    JButton btnPark;

    private static ParkingSystemApp app = new ParkingSystemApp();

    public static ParkingSystemApplicationUI mainFrame;
    // initial slots
    public static List<SlotInfo> allSlots;
    public static List<SlotInfo> allSlotsAvailable;

    /**
     * Launch application.
     */
    public static void main(String[] args) {

        // starts spring
        SpringApplication.run(ParkingSystemApplicationUI.class, args);

        // runs java UI
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainFrame = new ParkingSystemApplicationUI();
                    mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*
    * insert dummy slots;
    * */
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        slotRepository.insertDummySlots();
        allSlots = Convert.toSlotInfo(slotRepository.findAll());
        allSlotsAvailable = Convert.toSlotInfo(slotRepository.findSlotsByAvailability(true));
        System.out.println("Total available slots:"+ slotRepository.findAll().size());
    }

    /**
     * Create the frame.
     */
    public ParkingSystemApplicationUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome to the Automated Parking System!");
        setBounds(100, 100, 550, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(1, 2));
        setContentPane(contentPane);

        btnPark = new JButton("Park");
        btnPark.setBackground(new Color(11, 218, 81));
        btnPark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicketInfo ticket = app.park();

                if (ticket == null) {
                    JOptionPane.showMessageDialog(btnPark, "Parking full!");
                } else {
                    Date date = ticket.getDate();
                    long ticketNumber = ticket.getSlot().getSlotNumber();
                    long time = ticket.getStartTime();

                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    date = new Date(time);
                    dateFormat.setTimeZone(TimeZone.getTimeZone("PST"));

                    JOptionPane.showMessageDialog(btnPark, "Today's Date: " + dateFormat.format(date) + "\n" +
                            "Your parking ticket number: " + ticketNumber + "\n" +
                            "Start Time: " + timeFormat.format(date));
                }
            }
        });
        contentPane.add(btnPark, BorderLayout.CENTER);

        JButton btnPayExit = new JButton("Pay & Exit");
        btnPayExit.setForeground(new Color(0, 0, 0));
        btnPayExit.setBackground(new Color(255, 87, 51));
        btnPayExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.captureEndTime();

                SlotFrame slotFrame = null;

                try {
                    slotFrame = new SlotFrame(app); // display new frame for entering ticket number
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                mainFrame.setVisible(false); // hide the first frame
                slotFrame.setVisible(true);
            }
        });
        contentPane.add(btnPayExit, BorderLayout.EAST);
    }

}
