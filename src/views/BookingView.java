package views;

import models.Table;
import representers.View;
import representers.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private Collection<ViewObserver> observers;
    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables){
            System.out.println(table);
        }
    }

    @Override
    public void registerObserver(ViewObserver observer) {
        if (observers == null){
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер брони: №%d\n", reservationNo);
        }
        else {
            System.out.println("Произошла ошибка при бронировании столика. \n Повторите попытку");
        }
    }

    @Override
    public void showChangesReservationTableResult(int newReservationNo) {
        if (newReservationNo > 0) {
            System.out.printf("Резервирование изменено. Номер брони: №%d\n", newReservationNo);
        }
        else {
            System.out.println("Изменения не приняты.");
        }
    }

    public void reservatioTable(Date orderDate, int tableNo, String name){
        if (observers != null)
            for (ViewObserver observer: observers) {
                observer.onReservationTable(orderDate, tableNo, name);
            }
    }

    public void changeReservationTable(int oldNo, Date date, int newNo, String name) {
        for (ViewObserver observer: observers) {
            observer.onChangeReservationTable(oldNo, date, newNo, name);
        }
    }
}
