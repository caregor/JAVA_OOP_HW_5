package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Reservation {
    private static int counter = 1000;

    private int id;
    private Date date;
    private String name;

    private boolean reservationStatus;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }

    public boolean isReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(boolean reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    private Collection<Reservation> reservations = new ArrayList<>();
    public void setTable(Table table) {
        this.table = table;
    }

    private Table table;


    public Reservation(Date date, String name, Table table) {
        id = ++counter;
        this.date = date;
        this.name = name;
        this.table = table;
        this.reservationStatus = true;
    }
}
