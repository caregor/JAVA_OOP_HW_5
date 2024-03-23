package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Reservation {
    private int counter = 1000;

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

    private int id;
    private Date date;
    private String name;

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    private Collection<Reservation> reservations = new ArrayList<>();
    public void setTable(Table table) {
        this.table = table;
    }

    private Table table;


    public Reservation(Date date, String name, Table table) {
        id = counter++;
        this.date = date;
        this.name = name;
        this.table = table;
    }
}
