package models;

import representers.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TablesRepository implements Model {

    private Collection<Table> tables;
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name, table);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }
}
