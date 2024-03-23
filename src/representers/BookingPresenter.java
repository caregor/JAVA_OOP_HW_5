package representers;

import models.TablesRepository;
import views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver{

    private Model model;
    private View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int resrvationNo){
        view.showReservationTableResult(resrvationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int resrvationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(resrvationNo);
        }
        catch (Exception e) {
            updateReservationTableView(-1);
        }
    }
}
