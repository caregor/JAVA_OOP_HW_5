import models.TablesRepository;
import representers.BookingPresenter;
import views.BookingView;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TablesRepository tablesRepository = new TablesRepository();
        BookingView bookingView = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(tablesRepository, bookingView);
        bookingPresenter.updateTablesView();
        bookingView.reservatioTable(new Date(), 2, "Ivan");
        bookingPresenter.updateTablesView();
        bookingView.reservatioTable(new Date(), 2, "Sergey");
        bookingPresenter.updateTablesView();
        bookingView.changeReservationTable(2, new Date(), 4, "Станислав");
    }
}